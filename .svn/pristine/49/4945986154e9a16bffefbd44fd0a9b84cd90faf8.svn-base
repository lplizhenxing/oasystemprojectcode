package com.zszd.ai.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.report.ReportDao;
import com.zszd.ai.pojo.Report;
import com.zszd.ai.pojo.ReportType;

@Service
public class ReportServiceImpl implements ReportService {

	@Resource
	private ReportDao reportDao;

	@Override
	public int addReport(Report report) {
		return reportDao.addReport(report);
	}

	@Override
	public int modifyReport(Report report) {
		return reportDao.modifyReport(report);
	}

	@Override
	public int deleteUserbyUsername(String username) {
		return reportDao.deleteUserbyUsername(username);
	}

	@Override
	public int deleteUserbyId(Integer id) {
		return reportDao.deleteUserbyId(id);
	}

	@Override
	public List<Report> getAllReportList() {
		return reportDao.getAllReportList();
	}

	@Override
	public List<Report> getReportListByReportType(Integer typeId) {
		return reportDao.getReportListByReportType(typeId);
	}

	@Override
	public List<Report> getUserbyuserName(String userName) {
		return reportDao.getUserbyuserName(userName);
	}

	@Override
	public Report getReportbyId(Integer id) {
		return reportDao.getReportbyId(id);
	}

	@Override
	public List<ReportType> getAllReportType() {
		return reportDao.getAllReportType();
	}

	@Override
	public ReportType gettypeIdByReportTypename(String typename) {
		return reportDao.gettypeIdByReportTypename(typename);
	}

	@Override
	public List<Report> getAllReportListByCompanyId(int companyId) {
		return reportDao.getAllReportListByCompanyId(companyId);
	}

	@Override
	public int deleteReportbyUsername(String username) {
		return 0;
	}

	@Override
	public int deleteReportbyId(Integer id) {
		return 0;
	}

	@Override
	public List<Report> getReportbyuserName(String userName) {
		return null;
	}

	//分页
	@Override
	public int getAllReportCountByUserNameBy(String queryEmployeeName,
			String queryReporttype, String createDate, String name) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportCountByUserNameBy(queryEmployeeName,queryReporttype,createDate,name);
	}

	@Override
	public int getAllReportCountByCompanyIdBy(String queryEmployeeName,
			String queryReporttype, String createDate, int companyId) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportCountByCompanyIdBy(queryEmployeeName,queryReporttype,createDate,companyId);
	}

	@Override
	public int getAllReportCountBy(String queryEmployeeName,
			String queryReporttype, String createDate) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportCountBy(queryEmployeeName,queryReporttype,createDate);
	}
	
	@Override
	public List<Report> getAllReportListByUserNameBy(String queryEmployeeName,
			String queryReporttype, String createDate, String name,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportListByUserNameBy(queryEmployeeName,queryReporttype,createDate,name, currentPage, pageSize);
	}


	@Override
	public List<Report> getAllReportListByCompanyIdBy(String queryEmployeeName,
			String queryReporttype, String createDate, int companyId,
			int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportListByCompanyIdBy(queryEmployeeName,queryReporttype,createDate,companyId, currentPage, pageSize);
	}

	@Override
	public List<Report> getAllReportListBy(String queryEmployeeName,
			String queryReporttype, String createDate, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return reportDao.getAllReportList(queryEmployeeName,queryReporttype,createDate, currentPage, pageSize);
	}


}
