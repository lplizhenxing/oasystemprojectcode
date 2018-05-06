package com.zszd.ai.dao.classes;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Classes;

public interface ClassesDao {
	/**
	 * 
	 * @Title          queryAllClasses
	 * @Description    查询所有班级
	 * @Tags           @return   
	 * @Return         List<Classes>   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 28, 2018        3:52:09 PM
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
	 * @date           Jan 28, 2018        3:53:13 PM
	 */
	int insertClasses(Classes classes);
	/**
	 * 
	 * @Title          updateClassesById
	 * @Description    通过id修改班级名称
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 28, 2018        3:54:10 PM
	 */
	int updateClassesById(Classes classes);
	/**
	 * 删除班级
	 * @Title          deleteClassByClassId
	 * @Description    TODO
	 * @Tags           @param classId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午8:59:27
	 */
	int deleteClassByClassId(@Param("id")int classId);
	/**
	 * 查询班级  
	 * @Title          queryClassByClassId
	 * @Description    TODO
	 * @Tags           @param classId
	 * @Tags           @return   
	 * @Return         Classes   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午8:59:34
	 */
	Classes queryClassByClassId(@Param("id")int classId);
	/**
	 * 班主任在进行新增公司的时候 选择班级是属于自己的班级
	 * @Title          queryAllClassesByClassLeader
	 * @Description    TODO
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Classes>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-24        下午11:37:39
	 */
	List<Classes> queryAllClassesByClassLeader(@Param("name")String name);
	int getClassesCount(@Param("queryClassName")String queryClassName, @Param("queryClassLeader")String queryClassLeader,
			@Param("queryClassTeacher")String queryClassTeacher);
	List<Classes> getClassesListBy(@Param("queryClassName")String queryClassName, @Param("queryClassLeader")String queryClassLeader,
			@Param("queryClassTeacher")String queryClassTeacher, @Param("currentPageNo")int currentPageNo,
			@Param("pageSize")int pageSize);
}
