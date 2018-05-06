package com.zszd.ai.service.classes;

import java.util.List;

import com.zszd.ai.pojo.Classes;



public interface ClassesService {
	/**
	 * 
	 * @Title          queryAllClasses
	 * @Description    查询所有班级
	 * @Tags           @return   
	 * @Return         List<Classes>   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 28, 2018        4:13:19 PM
	 */
	List<Classes> queryAllClasses();
	/**
	 * 
	 * @Title          insertClasses
	 * @Description    添加班级
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 28, 2018        4:13:39 PM
	 */
	int insertClasses(Classes classes);
	/**
	 * 
	 * @Title          updateClassesById
	 * @Description    通过id修改班级
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 28, 2018        4:13:52 PM
	 */
	int updateClassesById(Classes classes );
	/**
	 * 删除班级
	 * @Title          deleteClassByClassId
	 * @Description    TODO
	 * @Tags           @param classId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午8:53:30
	 */
	int deleteClassByClassId(int classId);
	/**
	 * 查询班级 用于修改
	 * @Title          queryClassByClassId
	 * @Description    TODO
	 * @Tags           @param classId
	 * @Tags           @return   
	 * @Return         Classes   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午8:56:09
	 */
	Classes queryClassByClassId(int classId);
	/**
	 * 班主任在进行新增公司的时候 选择班级是属于自己的班级
	 * @Title          queryAllClassesByClassLeader
	 * @Description    TODO
	 * @Tags           @return   
	 * @Return         List<Classes>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-24        下午11:36:16
	 */
	List<Classes> queryAllClassesByClassLeader(String name);
	int getClassesCount(String queryClassName, String queryClassLeader,
			String queryClassTeacher);
	List<Classes> getClassesListBy(String queryClassName,
			String queryClassLeader, String queryClassTeacher, int currentPage,
			int pageSize);
}
