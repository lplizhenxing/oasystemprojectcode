package com.zszd.ai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/rollPage")
public class RollPageController {

	@RequestMapping(value = "/rollPage.html")
	public String rollPage() {
		return "/common/rollPage";
	}


}
