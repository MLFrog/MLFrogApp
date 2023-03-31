package com.mlfrog.presentation.View;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestView {
	
	@RequestMapping("/")
	public String mainPage() {
		return "Main 입니다";
	}
}
