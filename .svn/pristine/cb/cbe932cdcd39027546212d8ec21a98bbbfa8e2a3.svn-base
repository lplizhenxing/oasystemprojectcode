package com.zszd.ai.service.company;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.zszd.ai.dao.company.CompanyDao;
import com.zszd.ai.pojo.Classes;
import com.zszd.ai.pojo.Company;
import com.zszd.ai.tools.MyBatisUtil;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Resource
	private CompanyDao companyDao ;
	
	/**
	 * 
	 * <p>Title queryCompanyInfo</p>
	 * <p>显示所有公司信息 </p>
	 * @return
	 * @see com.zszd.ai.service.company.CompanyService#queryCompanyInfo()
	 */
	@Override
	public List<Company> queryCompanyInfo() {
		return companyDao.queryCompanyInfo();
	}

	/**
	 * 
	 * <p>Title insertCompany</p>
	 * <p>添加公司信息 </p>
	 * @param company
	 * @return
	 * @see com.zszd.ai.service.company.CompanyService#insertCompany(com.zszd.ai.pojo.Company)
	 */
	@Override
	public int insertCompany(Company company) {		
		return companyDao.insertCompany(company);
	}
	
	/**
	 * 查询公司信息  用于修改
	 * <p>Title queryCompanyById</p>
	 * <p>Description </p>
	 * @param id
	 * @return
	 * @see com.zszd.ai.service.company.CompanyService#queryCompanyById(int)
	 */
	@Override
	public Company queryCompanyById(int id) {
		return companyDao.queryCompanyById(id);
	}

	/**
	 * 修改公司信息
	 * <p>Title updateCompany</p>
	 * <p>Description </p>
	 * @param company
	 * @return
	 * @see com.zszd.ai.service.company.CompanyService#updateCompany(com.zszd.ai.pojo.Company)
	 */
	@Override
	public int updateCompany(Company company) {
		return companyDao.updateCompany(company);
	}

	/**
	 * 删除公司信息 不物理删除 只对状态进行变更
	 * <p>Title deleteCompanyById</p>
	 * <p>Description </p>
	 * @param id
	 * @return
	 * @see com.zszd.ai.service.company.CompanyService#deleteCompanyById(int)
	 */
	@Override
	public int deleteCompanyById(int id) {
		return companyDao.deleteCompanyById(id);
	}

	@Override
	public int countDepartmentByCompanyId(int companyId) {
		SqlSession sqlSession = null;
		int count=0;
		try{
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(CompanyDao.class).countDepartmentByCompanyId(companyId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return count;
	}

	@Override
	public List<Company> queryCompanyInfoByClassLeader(String name) {
		// TODO Auto-generated method stub
		return companyDao.queryCompanyInfoByClassLeader(name);
	}

	@Override
	public int getCompanyCount(String queryClassName, String queryCompanyName) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyCount(queryClassName,queryCompanyName);
	}

	@Override
	public List<Company> getCompanyListBy(String queryClassName,
			String queryCompanyName, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return companyDao.getCompanyListBy(queryClassName,queryCompanyName,currentPage,pageSize);
	}

	

}
