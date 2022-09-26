package dip.clever.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import dip.clever.model.Reply;
import dip.clever.service.MangeQuestService;
import dip.clever.service.ReplyService;
import dip.clever.service.UserService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private MangeQuestService managequestservice;

//	// 댓글 리스트출력
//	@GetMapping("reply")
//	public String Replyinfo(Model model) {
//		
//		int questNo = 2;
//		List<HashMap<String, Object>> quest=managequestservice.joinQuest(questNo);
//		model.addAttribute("quest",quest);
//		//System.out.println(quest);
//		
//		//model.addAttribute("user",userservice.findAll());
//		//User regUser = (User)httpServletRequest.getSession().getAttribute("user");
//		//System.out.println(regUser);
//		//reply.setRegUser(regUser.getUserId());
//		//List<Reply> user = replyservice.findAll();
//		
//		int questnum=1;
//		List<HashMap<String, Object>> user=replyservice.joinUser(questnum);
//		model.addAttribute("user",user);
//		//System.out.println(user);
//		
//		return "reply";
//	} 

	@PostMapping("/insertReply")
	public ResponseEntity<String> insertReply(Reply reply) {
		String message = "댓글이 작성되었습니다.";
		System.out.println("=============>댓글인서트 : " + reply);
		
//		User regUser = (User)HttpServletRequest.getSession().getAttribute("user");
//		System.out.println(regUser);
//		
//		reply.setRegUser(regUser.getUserId());
//		System.out.println(reply.toString());
		
		//reply.setRegUser("1");
		
		System.out.println("article.toString() =>" + reply.toString());
		replyservice.insertReply(reply);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	// 댓글 삭제 method
	@PostMapping("/delete-reply/{id}")
	public ResponseEntity<String> deleteReply(@PathVariable String id) {
		String message = "삭제완료";
		System.out.println(id);
		// User user = userService.findSearchResult(id); 
		// articleService.deleteAllArticleByUser(user);
		// commentService.deleteCommentByUser(user);
		replyservice.deleteReply(id);

		System.out.println("삭제완료");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
		/*
		 * @PostMapping("/modifyReply/{id}") public ResponseEntity<String>
		 * modifyReply(@PathVariable int id, @RequestBody Reply reply) {
		 * ResponseEntity<String> entity = null; try { reply.setReplyNo(id);
		 * replyservice.modifyReply(reply); entity = new
		 * ResponseEntity<String>("modSuccess", HttpStatus.OK); } catch (Exception e) {
		 * e.printStackTrace(); entity = new ResponseEntity<String>(e.getMessage(),
		 * HttpStatus.BAD_REQUEST); } return entity; }
		 */
// updateForm으로 넘겨주는 method
	@PostMapping("/edit-reply/{id}")
	public String updateCommentBtn(@PathVariable String id, Model model) {
		Reply reply = replyservice.findReplyById(id);
		System.out.println("=================> toString: " + reply.toString());
		model.addAttribute("reply", reply);
		return "edit_forms/edit-comment";
	}

	
	  // 댓글 update query문을 실행하는 method
	  
	@Transactional
	@PutMapping("/edit-reply2/{id}") 
	public ResponseEntity<Reply> updateComment(@PathVariable int id, Reply reply) {
		reply.setReplyNo(id);
//		System.out.println("======> setting 전: " + reply1.toString());
		// 아이디를 통해서 수정 전 댓글을 가져옴
		System.out.println(reply);
		
//		reply.setContent(reply1.getContent());
		
		System.out.println("======> setting 후: " + reply.toString());
		replyservice.modifyReply(reply);
		return new ResponseEntity<Reply>(reply, HttpStatus.OK);
	}
		 
	@PostMapping("/reply/{userId}")
	public String myReply(Model model, @PathVariable String userId) {
		model.addAttribute("replyList", replyservice.selectMyReply(userId));

		return "/mypage/activity/mypage-reply";
	}
}
