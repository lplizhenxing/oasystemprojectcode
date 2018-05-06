package com.zszd.ai.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zszd.ai.pojo.Workpoint;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.workpoint.WorkPointService;
import com.zszd.ai.service.workpoint.WorkPointServiceImpl;

@Controller
@RequestMapping("/sys/workpoint")
public class WorkPointRecordController {
	private Logger logger = Logger.getLogger(WorkPointRecordController.class);

	@Resource
	WorkPointService workPointService = new WorkPointServiceImpl();
	
	@Resource
	EmployeeService employeeService = new EmployeeServiceImpl();
	
	@RequestMapping(value="/queryworkpointrecordByEmployeeId.html")
	public String queryworkpointrecordByEmployeeId(HttpServletRequest request,HttpSession session){	
		String employeeId = request.getParameter("id");
		String employeeName = employeeService.queryNameById(Integer.parseInt(employeeId));
		List<Workpoint> list = workPointService.queryWorkPointInfoByEmployeeId(Integer.parseInt(employeeId));
		request.setAttribute("employeeName", employeeName);
		request.setAttribute("list", list);
		return "workpoint/workpointrecord_employeelist";
	}

}
