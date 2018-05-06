package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.zszd.ai.pojo.Classes;
import com.zszd.ai.pojo.Company;
import com.zszd.ai.pojo.Department;
import com.zszd.ai.service.classes.ClassesService;
import com.zszd.ai.service.classes.ClassesServiceImpl;
import com.zszd.ai.service.company.CompanyService;
import com.zszd.ai.service.company.CompanyServiceImpl;
import com.zszd.ai.service.department.DepartmentService;
import com.zszd.ai.service.department.DepartmentServiceImpl;


/**
 * 
 * @ClassName       ClassServlet
 * @Description    班级控制器
 * @author           lvjc
 * @date           2018-1-30        上午11:53:14
 */
@WebServlet(urlPatterns = { "/classes" }, name = "ClassServlet")
public class ClassServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		HttpSession session = request.getSession();// 获取session
		int companyId = (Integer) session.getAttribute("companyId");
		
		ClassesService classesService = new ClassesServiceImpl();
		CompanyService companyService = new CompanyServiceImpl();
		DepartmentService departmentService = new DepartmentServiceImpl();
		String opr = request.getParameter("opr");
		String level = request.getParameter("level");
		PrintWriter out = response.getWriter();
		if ("query".equals(opr)) {
			switch (level) {
			case "company":
				List<Classes> cList = classesService.queryAllClasses();
				Map<Integer, String> classesMap = new HashMap<Integer, String>();
				if (cList != null) {
					for (Classes classes : cList) {
						classesMap.put(classes.getId(), classes.getClassName());
					}
				}
				String classesJson = JSON.toJSONString(classesMap);
				out.print(classesJson);
				break;
			case "department":
				List<Company> comList = companyService.queryCompanyInfo();
				Map<Integer, String> companyMap = new HashMap<Integer, String>();
				if (comList != null) {
					for (Company company : comList) {
						companyMap.put(company.getId(), company.getName());
					}
				}
				String companyJson = JSON.toJSONString(companyMap);
				out.print(companyJson);
				break;
			case "devgroup":
				List<Department> deList = departmentService
						.queryDepartmentInfoByCompanyId(companyId);
				Map<Integer, String> departmentMap = new HashMap<Integer, String>();
				if (deList != null) {
					for (Department department : deList) {
						departmentMap.put(department.getId(),
								department.getName());
					}
				}
				String departmentJson = JSON.toJSONString(departmentMap);
				out.print(departmentJson);
				break;
			}

		}
	}

}
