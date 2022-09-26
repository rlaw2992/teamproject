package dip.clever.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dip.clever.service.LogService;
import dip.clever.util.Json;

@Controller
@RequestMapping("log")
public class LogController {
	@Autowired
	private LogService logService;
	
	@PostMapping("/quest2")
	public String quest(Model model, @RequestParam HashMap<String, String> param){	
		model.addAttribute("questList",Json.parse(param.get("param")));

		return "quest";
	}
}
