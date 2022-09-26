package dip.clever.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dip.clever.model.Action;
import dip.clever.model.Log;
import dip.clever.model.Round;
import dip.clever.model.Test;
import dip.clever.model.User;
import dip.clever.service.LogService;
import dip.clever.service.RoundService;
import dip.clever.service.TestService;
import dip.clever.util.Json;

@Controller
@RequestMapping("round")
public class RoundController {
	@Autowired
	private RoundService roundService;
	@Autowired
	private TestService testService;
	@Autowired
	private LogService logService;

	@PostMapping("")
	public String round(Model model, @RequestParam HashMap<String, String> param) {
		model.addAttribute("roundList", Json.parse(param.get("param")));

		return "roundList";
	}

	// 시험 목록 반환
	@PostMapping("/list")
	public ResponseEntity<List<Round>> testList(Model model, Test test) {
		return new ResponseEntity<List<Round>>(roundService.selectRoundList(test), HttpStatus.OK);
	}

	@GetMapping("/{no}")
	public String round(Model model, @PathVariable int no) {
		Round round = new Round();

		round.setRoundNo(no);
		round = roundService.selectRound(round);

		model.addAttribute("round", round);

		return "round";
	}

	// 회차등록
	@PostMapping("/insert")
	public String inserRound(HttpSession httpSession, Model model, Round round) {
		User user = User.getUser(httpSession);
		Log log;
		
		Test test = new Test();
		test.setTestNo(round.getTestNo());
		model.addAttribute("test", testService.selectTest(test));
		
		roundService.insertRound(round);
		log = new Log(user.getUserId(), Action.CREATE, roundService.selectLastInsert());
		logService.insertLog(log);

		return "redirect:/test/" + round.getTestNo();
	}

	@PostMapping("/new")
	public String newRound(Model model) {
		model.addAttribute("rankList",roundService.selectNewRound());
		
		return "newRound";
	}
}
