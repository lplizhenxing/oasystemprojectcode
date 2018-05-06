package com.zszd.ai.service.post;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.post.PostDao;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Post;

/**
 * 帖子接口实现
 * 
 * @author lizx 20180103
 * 
 */
@Service
public class PostServiceImpl implements PostService {

	@Resource
	private PostDao postDao;

	/**
	 * 获取总记录数
	 * <p>Title getPostInfoCountLikeName</p>
	 * <p>Description </p>
	 * @param keywords
	 * @return
	 * @see com.zszd.ai.service.post.PostService#getPostInfoCountLikeName(java.lang.String)
	 */
	@Override
	public int getPostInfoCountLikeName(String keywords) {
		return postDao.getPostInfoCountLikeName(keywords);
	}

	/**
	 * 分页查询
	 * <p>Title queryPostInfoLikeNamePage</p>
	 * <p>Description </p>
	 * @param p
	 * @param keywords
	 * @return
	 * @see com.zszd.ai.service.post.PostService#queryPostInfoLikeNamePage(com.zszd.ai.pojo.Page, java.lang.String)
	 */
	@Override
	public List<Post> queryPostInfoLikeNamePage(Page p, String keywords) {
		return	postDao.queryPotRecordPageLikeName(p, keywords);
	}
	
	/**
	 * 添加评论
	 * <p>Title addPostInfo</p>
	 * <p>Description </p>
	 * @param post
	 * @return
	 * @see com.zszd.ai.service.post.PostService#addPostInfo(com.zszd.ai.pojo.Post)
	 */
	@Override
	public int addPostInfo(Post post) {
		return postDao.addPostInfo(post);
	}

	@Override
	public Post getPostByPostId(int id) {
		return postDao.getPostByPostId(id);
	}

	

	@Override
	public int updatePost(Post post) {
		return postDao.updatePost(post);
	}

	@Override
	public int updatePostInfo(Post post) {
		return postDao.updatePostInfo(post);
	}

	@Override
	public int deletePostById(int id) {
		return postDao.deletePostById(id);
	}

}
