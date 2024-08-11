package com.practice8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.practice8.request.IndexRequest;
import com.practice8.service.JudgeService;

@Controller
public class IndexController {
	
	private final JudgeService service;

	public IndexController(JudgeService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("request") IndexRequest req, Model model) {
		//htmlファイルの名前を返却
		return "index";
	}

	@GetMapping("/judge")
	public String judge(
			@Validated @ModelAttribute("request") IndexRequest req, BindingResult validResult, Model model) {
		
		if(! validResult.hasErrors()) {
			int val = Integer.valueOf(req.getValue());
			
			String message = service.makeMessage(val);
			
			//Thymeleafに情報を渡す。htmlファイルに${message}が必要
			model.addAttribute("message", message);
		}
		//htmlファイルの名前を返却
		return "index";
	}

}
