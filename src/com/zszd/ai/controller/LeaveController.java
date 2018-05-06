package com.zszd.ai.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Leave;
import com.zszd.ai.service.leave.LeaveService;
import com.zszd.ai.service.leave.LeaveServiceImpl;
import com.zszd.ai.tools.Constants;
import com.zszd.ai.tools.LeaveState;

@Controller
@RequestMapping("/sys/leave")
public class LeaveController {
	private Logger logger = Logger.getLogger(LeaveController.class);

	@Resource
	LeaveService leaveService = new LeaveServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request, HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int companyId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getCompanyId();
		List<Leave> list = null;
		if (roleId == Constants.NORMALSTAFF) {
			list = leaveService.queryAllLeaveInfoByCompanyIdAndName(companyId,
					name);
		} else if (roleId == Constants.PRESIDENT || roleId == Constants.DIRETOR) {
			list = leaveService.queryAllLeaveInfoByCompanyId(companyId);
		} else {
			list = leaveService.queryAllLeaveInfo();
		}
		request.setAttribute("list", list);
		return "leave/leave_list";
	}

	// 实现跳转到添加班级页
	@RequestMapping(value = "/addLeave.html")
	public String addLeave() {
		return "leave/leave_add";
	}

	@RequestMapping(value = "toaddLeave.html")
	public String toaddLeave(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String leaveReason = request.getParameter("leaveReason");
		Leave leave = new Leave();
		leave.setUserName(name);
		leave.setLeaveReason(leaveReason);
		int row = leaveService.addLeaveInfo(leave);
		if (row > 0) {
			return "redirect:/sys/leave/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/leave/view.html";
		}

	}

	// 实现跳转到操作请假页
	@RequestMapping(value = "/oprLeave.html")
	public String oprLeave(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String opr = request.getParameter("opr");
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		Date now = new Date();
		Leave leave = new Leave();
		leave.setId(leaveId);
		leave.setApprovalName(name);
		leave.setApprovalTime(now);
		switch (opr) {
		case Constants.PASS:
			leave.setState(LeaveState.PASS);
			break;
		case Constants.REJECT:
			leave.setState(LeaveState.NOPASS);
			break;
		case Constants.CANCEL:
			leave.setState(LeaveState.CANCEl);
			break;
		}
		int row = leaveService.oprLeaveInfo(leave);
		if (row > 0) {
			return "redirect:/sys/leave/view.html";
		} else {
			request.setAttribute("error", "操作失败");
			return "redirect:/sys/leave/view.html";
		}
		
	}

}
