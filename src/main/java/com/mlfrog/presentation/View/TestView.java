package com.mlfrog.presentation.View;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Test View Controller 입니다.
 * 추후 변경되거나 없어질 부분입니다.
 */

@RestController
public class TestView {
	
	/*
	 * Vue 개발 전까지 사용할 임시 메인 페이지
	 */
	@GetMapping("/")
	public String mainPage() {
		StringBuilder links = new StringBuilder();
		links.append("<center><h1>Main Page 입니다.</h1></center>"); 
		links.append("<br><hr>");
		links.append("<a href='/swagger-ui/index.html'>Swagger 바로가기</a>");
		links.append("<br><hr>");
		links.append("<a href='/h2-console/'>H2 DB 바로가기</a>");
		links.append("<br><hr>");
		return links.toString();
	}
	
	@GetMapping("/{id}")
	public String idTest(@PathVariable int id) {
		return Integer.toString(id);
	}
	
	/*
	 * 쓸데없이 Error페이지를 내보내게 하고 있어서
	 * 요청 무시하도록 설정
	 */
	@GetMapping("/favicon.ico")
    public void handleFaviconRequest() {
    }
	
}
