package com.mlfrog.presentation.View;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Test View Controller 입니다.
 * 추후 변경되거나 없어질 부분입니다.
 */

@RestController
public class TestView {
	
	@RequestMapping("/")
	public String mainPage() {
		return "Main 입니다";
	}
	
	@RequestMapping("/{id}")
	public String idTest(@PathVariable int id) {
		return Integer.toString(id);
	}
	
}
