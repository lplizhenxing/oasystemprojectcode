package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Oadev;
import com.zszd.ai.service.oadev.OadevService;
import com.zszd.ai.service.oadev.OadevServiceImpl;

@Controller
@RequestMapping("/sys/oadev")
public class OadevController {
	private Logger logger = Logger.getLogger(OadevController.class);

	@Resource
	OadevService oadevService = new OadevServiceImpl();
	
	@RequestMapping(value="/view.html")
	public String view(HttpServletRequest request,HttpSession session){	
		List<Oadev> list = oadevService.queryAllOadevInfo();
		request.setAttribute("list", list);
		return "oadev/oadev_list";
	}

}
