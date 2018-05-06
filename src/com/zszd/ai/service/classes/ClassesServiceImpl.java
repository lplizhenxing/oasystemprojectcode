package com.zszd.ai.service.classes;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.classes.ClassesDao;
import com.zszd.ai.pojo.Classes;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Resource
	private ClassesDao classesDao;

	/**
	 * 查询所有的班级信息
	 * <p>
	 * Title queryAllClasses
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @return
	 * @see com.zszd.ai.service.classes.ClassesService#queryAllClasses()
	 */
	@Override
	public List<Classes> queryAllClasses() {
		return classesDao.queryAllClasses();
	}

	/**
	 * 删除班级
	 * <p>
	 * Title deleteClassByClassId
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @param classId
	 * @return
	 * @see com.zszd.ai.service.classes.ClassesService#deleteClassByClassId(int)
	 */
	@Override
	public int deleteClassByClassId(int classId) {
		// TODO Auto-generated method stub
		return classesDao.deleteClassByClassId(classId);
	}

	/**
	 * 查询班级
	 * <p>
	 * Title queryClassByClassId
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @param classId
	 * @return
	 * @see com.zszd.ai.service.classes.ClassesService#queryClassByClassId(int)
	 */
	@Override
	public Classes queryClassByClassId(int classId) {
		// TODO Auto-generated method stub
		return classesDao.queryClassByClassId(classId);
	}

	/**
	 * 插入班级
	 * <p>
	 * Title insertClasses
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @param classes
	 * @return
	 * @see com.zszd.ai.service.classes.ClassesService#insertClasses(com.zszd.ai.pojo.Classes)
	 */
	@Override
	public int insertClasses(Classes classes) {
		return classesDao.insertClasses(classes);
	}

	/**
	 * 修改班级
	 * <p>
	 * Title updateClassesById
	 * </p>
	 * <p>
	 * Description
	 * </p>
	 * 
	 * @param classes
	 * @return
	 * @see com.zszd.ai.service.classes.ClassesService#updateClassesById(com.zszd.ai.pojo.Classes)
	 */
	@Override
	public int updateClassesById(Classes classes) {
		return classesDao.updateClassesById(classes);
	}

	@Override
	public List<Classes> queryAllClassesByClassLeader(String name) {
		return classesDao.queryAllClassesByClassLeader(name);
	}

	@Override
	public int getClassesCount(String queryClassName, String queryClassLeader,
			String queryClassTeacher) {
		// TODO Auto-generated method stub
		return classesDao.getClassesCount(queryClassName,queryClassLeader,queryClassTeacher);
	}

	@Override
	public List<Classes> getClassesListBy(String queryClassName,
			String queryClassLeader, String queryClassTeacher, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return classesDao.getClassesListBy(queryClassName,queryClassLeader,queryClassTeacher,currentPage,pageSize);
	}

}
