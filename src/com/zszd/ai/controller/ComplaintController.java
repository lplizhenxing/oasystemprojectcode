package com.zszd.ai.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Complaint;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.service.complaint.ComplaintService;
import com.zszd.ai.service.complaint.ComplaintServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/complaint")
public class ComplaintController {
	private Logger logger = Logger.getLogger(ComplaintController.class);

	@Resource
	ComplaintService complaintService = new ComplaintServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request,HttpSession session) {
		int roleId = ((Employee) session.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		List<Complaint> list = null;
		if(roleId == Constants.MANAGER){
			list = complaintService.queryComplaint();
		}else{
			list = complaintService.queryComplaintByName(name);
		}
		request.setAttribute("list", list);
		return "complaint/complaint_list";
	}

	// 实现跳转到添加投诉页
	@RequestMapping(value = "/addComplaint.html")
	public String addComplaint() {
		return "/complaint/complaint_add";
	}

	@RequestMapping(value = "toaddComplaint.html")
	public String toaddComplaint(HttpSession session,HttpServletRequest request) {
		String name = ((Employee) session.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String complaintContent = request.getParameter("complaintContent");
		Complaint comp = new Complaint();
		comp.setContent(complaintContent);
		comp.setUserName(name);
		int row = complaintService.addComplaint(comp);
		if (row > 0) {
			return "redirect:/sys/complaint/view.html";
		} else {
			request.setAttribute("error", "投诉失败，请联系管理员");
			return "redirect:/sys/complaint/addComplaint.html";
		}

	}

	// 实现跳转到功能修改页
	@RequestMapping(value = "/feedbackcomplaint.html")
	public String feedbackcomplaint(HttpServletRequest request) {
		int complaintId = Integer.parseInt(request.getParameter("id"));
		Complaint complaint = complaintService.queryComplaintById(complaintId);
		request.setAttribute("complaint", complaint);
		return "/complaint/complaint_feedback";
	}

	// 修改功能
	@RequestMapping(value = "/tofeedbackcomplaint.html")
	public String tofeedbackcomplaint(HttpSession session,HttpServletRequest request) {
		String name = ((Employee) session.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String complaintId = request.getParameter("complaintId");
		String feedbackContent = request.getParameter("feedbackContent");
		Date feedbackTime = new Date();
		Complaint comp = new Complaint();
		comp.setId(Integer.parseInt(complaintId));
		comp.setFeedback(feedbackContent);
		comp.setFeedbackMan(name);
		comp.setFeedbackTime(feedbackTime);
		int row = complaintService.updateComplaint(comp);
		if (row > 0) {
			return "redirect:/sys/complaint/view.html";
		} else {
			request.setAttribute("error", "反馈失败，请联系管理员");
			return "redirect:/sys/complaint/feedbackcomplaint.html";
		}
	}

}
