package dip.clever.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dip.clever.model.User;
import dip.clever.service.UserService;

@Controller
@RequestMapping("mypage")
public class MypageController {
	@Autowired
	private UserService userService;
	// ** mypage **
	// mypage 반환
	@GetMapping("")
	public String mypage(HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("user");
		
		httpSession.setAttribute("user", userService.selectUser(user));
		
		return "/mypage/mypage";
	}

	// 내가 푼 문제 조회
	@PostMapping("/quests")
	public String mySolvedQuest() {
		return "mypage/activity/mypage-activity";
	}

	// 내가 올린 문제 조회
	@PostMapping("/upload-quests")
	public String myQuest() {
		return "mypage/activity/mypage-quest";
	}

	// 내 댓글 조회
	@PostMapping("/comments")
	public String myReply() {
		return "mypage/activity/mypage-reply";
	}

	// 레벨 기준 조회
	@PostMapping("/level")
	public String myLevel() {
		return "mypage/activity/mypage-level";
	}

	// mypage settings
	// mypage - 개인정보 수정
	@RequestMapping("/setting")
	public String mypageSetting() {
		return "mypage/settings/mypage-setting";
	}

	// mypage - 프로필/계정 정보 수정
	@RequestMapping("/setting-{category}")
	public String settingsProfile(@PathVariable String category) {
		if (category.equals("profile")) {
			return "mypage/settings/settings-profile";
		} else {
			return "mypage/settings/settings-account";
		}
	}
}
