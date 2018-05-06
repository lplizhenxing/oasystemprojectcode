package com.zszd.ai.service.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.comment.CommentDao;
import com.zszd.ai.pojo.Comment;
/**
 * 评论接口实现
 * @author lizx 20180103
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource 
	private CommentDao commentDao;

	@Override
	public int addCommentInfo(Comment comment) {
       return commentDao.addCommentInfo(comment);
	}
	@Override
	public List<Comment> getAllCommentByPostId(int postId) {
		return commentDao.getAllCommentByPostId(postId);
	}
	
	@Override
	public Comment getCommentByCommentId(int commentId) {
		return commentDao.getCommentByCommentId(commentId);
	}
	
	@Override
	public int updateCommentInfo(Comment comment) {
		return commentDao.updateCommentInfo(comment);
	
	}
	@Override
	public int deleteCommentById(int id) {
		return commentDao.deleteCommentById(id);
	}

}
