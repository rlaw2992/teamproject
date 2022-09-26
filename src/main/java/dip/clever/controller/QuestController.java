package dip.clever.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dip.clever.model.Action;
import dip.clever.model.Choice;
import dip.clever.model.Log;
import dip.clever.model.Quest;
import dip.clever.model.Round;
import dip.clever.model.User;
import dip.clever.service.LogService;
import dip.clever.service.MangeQuestService;
import dip.clever.service.QuestService;
import dip.clever.service.ReplyService;
import dip.clever.util.Json;
import dip.clever.util.Util;

@Controller
@RequestMapping("quest")
public class QuestController {
	@Autowired
	private QuestService questService;
	@Autowired
	private LogService logService;
	@Autowired
	private ReplyService replyservice;
	@Autowired
	private MangeQuestService mangeQuestService;
	
	@PostMapping("")
	public String quest(Model model, @RequestParam HashMap<String, String> param){
		model.addAttribute("questList", Json.parse(param.get("param")));
		System.out.println(param);

		return "questList";
	}
	
	//시험 목록 반환
	@PostMapping("select")
	public ResponseEntity<List<Quest>> questList(Round round) {
		return Util.resoponse(questService.selectQuestList(round));		
	}
	
	@GetMapping("{no}")
	public String quest(Model model, @PathVariable int no) {
		Quest quest = new Quest();
		
		quest.setQuestNo(no);
		System.out.println(no);
		
		List<HashMap<String, Object>> user=replyservice.joinUser(no);
		model.addAttribute("user",user);
		System.out.println(user);
		
		model.addAttribute("quest", questService.selectQuest(quest));
		model.addAttribute("info", questService.selectQuestInfo(quest));
		
		return "quest";
	}	
	@PostMapping("solvedList")
	public String selectSolvedList(Model model, User user) {
		model.addAttribute("solvedList", questService.selectSolvedList(user));
		System.out.println(questService.selectSolvedList(user));
		return "/quest/solve-quest";
	}
	
	@PostMapping("uploadList")
	public String selectUploadList(Model model, User user){
		model.addAttribute("uploadList", questService.selectUploadList(user));
		
		return "/quest/upload-quest";		
	}
	
	@PostMapping("next")
	public ResponseEntity<Integer> nextQuest(Quest quest) {
		Integer no = questService.selectNextQuest(quest);		
		
		return Util.resoponse(no != null ? no : 0);
	}
	
	@PostMapping("check")
	public ResponseEntity<Integer[]> checkAnswer(HttpSession httpSession, String param){
		Integer[] solvedQuest = questService.checkAnswer(Json.parse(param));
		User user = (User)httpSession.getAttribute("user");
		Log log;

		if(user != null) {
			for(int sq : solvedQuest) {
				log = new Log(user.getUserId(), Action.SOLVED, sq);
				
				logService.insertLog(log);
			}
		}		
		
		return Util.resoponse(solvedQuest);
	}

	// 문제등록
	@PostMapping("insertQuest")
	public String insertQuest(Model model, Choice choice, Quest quest) {
		Round round = new Round();
		round.setRoundNo(quest.getRoundNo());
		model.addAttribute("round", mangeQuestService.selectRound(round));
		quest.setRoundNo(quest.getRoundNo());
		mangeQuestService.insertQuest(quest);
		choice.setQuestNo(mangeQuestService.selectQuestNo());
		mangeQuestService.insertChoice(choice);
		
		return "redirect:/round/" + quest.getRoundNo();
	}
	
	private Choice selectChoice(Quest quest) {
		return questService.selectChoice(quest);
	}	
}
