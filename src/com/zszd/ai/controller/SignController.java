package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.SignRecord;
import com.zszd.ai.service.signrecord.SignRecordService;
import com.zszd.ai.service.signrecord.SignRecordServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.DateUtil;

@Controller
@RequestMapping("/sys/sign")
public class SignController {
	private Logger logger = Logger.getLogger(SignController.class);

	@Resource
	SignRecordService signRecordService = new SignRecordServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request, HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		List<SignRecord> list = null;	
		if (roleId == Constants.NORMALSTAFF) {
			list = signRecordService.queryAllSignRecordInfoByCompanyIdAndName(companyId,name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = signRecordService.queryAllSignRecordInfoByCompanyId(companyId);
		} else {
			list = signRecordService.queryAllSignRecordInfo();
		}
		request.setAttribute("list", list);
		return "sign/sign_list";
	}

	@RequestMapping(value = "sign.html")
	public String sign(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String signDate = DateUtil.getTime(); 
		List<SignRecord> list = signRecordService.queryAllSignRecordInfoByNameAndSignOutDate(name,signDate);
		if(list.size()>0){
			request.setAttribute("error", "当天已签到");
			return "redirect:/sys/sign/view.html";
		}else{
			List<SignRecord> signOutlist = signRecordService.queryAllSignRecordInfoByNameAndSignOutDate(name,signDate);
			if(signOutlist.size()>0){
				int row =  signRecordService.updateSignRecordInfoByNameAndSignDate(name,signDate);
				if (row > 0) {
					return "redirect:/sys/sign/view.html";
				} else {
					request.setAttribute("error", "添加失败");
					return "redirect:/sys/sign/view.html";
				}
			}else{
				int row =  signRecordService.insertSignRecordInfoByNameAndSignDate(name,signDate);
				if (row > 0) {
					return "redirect:/sys/sign/view.html";
				} else {
					request.setAttribute("error", "添加失败");
					return "redirect:/sys/sign/view.html";
				}
			}	
		}
	}
	
	@RequestMapping(value = "signOut.html")
	public String signOut(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String signOutDate = DateUtil.getTime(); 
		List<SignRecord> list = signRecordService.queryAllSignRecordInfoByNameAndSignOutDate(name,signOutDate);
		if(list.size()>0){
			request.setAttribute("error", "当天已签退");
			return "redirect:/sys/sign/view.html";
		}else{
			List<SignRecord> signlist = signRecordService.queryAllSignRecordInfoByNameAndSignDate(name,signOutDate);
			if(signlist.size()>0){
				int row =  signRecordService.updateSignRecordInfoByNameAndSignOutDate(name,signOutDate);
				if (row > 0) {
					return "redirect:/sys/sign/view.html";
				} else {
					request.setAttribute("error", "操作失败");
					return "redirect:/sys/sign/view.html";
				}
			}else{
				int row =  signRecordService.insertSignRecordInfoByNameAndSignOutDate(name,signOutDate);
				if (row > 0) {
					return "redirect:/sys/sign/view.html";
				} else {
					request.setAttribute("error", "操作失败");
					return "redirect:/sys/sign/view.html";
				}
			}
		}
	}
}
