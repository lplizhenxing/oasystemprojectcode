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
import com.zszd.ai.pojo.Schedule;
import com.zszd.ai.service.schedule.ScheduleService;
import com.zszd.ai.service.schedule.ScheduleServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/schedule")
public class ScheduleController {
	private Logger logger = Logger.getLogger(ScheduleController.class);

	@Resource
	ScheduleService scheduleService = new ScheduleServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request, HttpSession session) {
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		List<Schedule> list = null;
		if (roleId == Constants.NORMALSTAFF) {
			list = scheduleService.getScheduleByFinishName(name);
		} else {
			list = scheduleService.getScheduleByCreateName(name);
		}
		request.setAttribute("list", list);
		return "schedule/schedule_list";
	}

	// 实现跳转到添加班级页
	@RequestMapping(value = "/addSchedule.html")
	public String addSchedule() {
		return "schedule/schedule_add";
	}

	@RequestMapping(value = "toaddSchedule.html")
	public String toaddSchedule(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		String content = request.getParameter("content");
		String finishName = request.getParameter("finishName");
		Schedule schedule = new Schedule();
		if (roleId == Constants.NORMALSTAFF) {
			schedule.setContent(content);
			schedule.setCreateName(name);
			schedule.setFinishName(name);
		} else {
			schedule.setContent(content);
			schedule.setCreateName(name);
			schedule.setFinishName(finishName);
		}
		int row = scheduleService.addScheduleInfo(schedule);
		if (row > 0) {
			return "redirect:/sys/schedule/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/schedule/view.html";
		}

	}

	// 实现跳转到操作请假页
	@RequestMapping(value = "/oprSchedule.html")
	public String oprSchedule(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String opr = request.getParameter("opr");
		int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
		Date now = new Date();
		Schedule schedule = new Schedule();
		schedule.setId(scheduleId);
		switch (opr) {
		case Constants.FINISH:
			schedule.setFinishDate(now);
			schedule.setState(1);
			break;
		case Constants.CANCEL:
			schedule.setFinishDate(now);
			schedule.setState(0);
			break;
		}
		int row = scheduleService.oprScheduleInfo(schedule);
		if (row > 0) {
			return "redirect:/sys/schedule/view.html";
		} else {
			request.setAttribute("error", "操作失败");
			return "redirect:/sys/schedule/view.html";
		}

	}
}
