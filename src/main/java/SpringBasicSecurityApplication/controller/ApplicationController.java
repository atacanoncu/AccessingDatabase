package SpringBasicSecurityApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {
	
	@GetMapping(path="/getMsg")
	public String greeting() {
		return "spring security example";
	}
	
	@GetMapping(path="/error")
	public String errorpage() {
		return "error";
	}
}



