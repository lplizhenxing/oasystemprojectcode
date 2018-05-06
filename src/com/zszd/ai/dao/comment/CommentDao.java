package com.zszd.ai.dao.comment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Comment;
/**
 * 评论DAO接口
 * @author lizx 20180103
 *
 */
public interface CommentDao {

	int addCommentInfo( Comment comment);

	List<Comment> getAllCommentByPostId(@Param("postId")Integer postId);

	Comment getCommentByCommentId(Integer commentId);

	int updateCommentInfo( Comment comment);

	int deleteCommentById(Integer id);

}
