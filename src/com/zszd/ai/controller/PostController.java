package com.zszd.ai.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zszd.ai.pojo.Comment;
import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Post;
import com.zszd.ai.pojo.Sensitivewords;
import com.zszd.ai.service.comment.CommentService;
import com.zszd.ai.service.comment.CommentServiceImpl;
import com.zszd.ai.service.post.PostService;
import com.zszd.ai.service.post.PostServiceImpl;
import com.zszd.ai.service.sensitivewords.SensitivewordsService;
import com.zszd.ai.service.sensitivewords.SensitivewordsServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/post")
public class PostController {
	private Logger logger = Logger.getLogger(PostController.class);

	@Resource
	PostService postService = new PostServiceImpl();
	
	@Resource
	CommentService commentService = new CommentServiceImpl();
	
	@Resource
	SensitivewordsService sensitivewordsService = new SensitivewordsServiceImpl();

	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request) {
		String keywords = request.getParameter("keywords");
		if (keywords == null) {
			keywords = "";
		}

		// 获取当前页的页码
		String currentPageNumStr = request.getParameter("currPageNum");
		int currentPageNum = 1;// 默认当前页是第一页
		if (currentPageNumStr != null) {
			try {
				currentPageNum = Integer.parseInt(currentPageNumStr);
			} catch (Exception e) {// 如果有字符串，就调到第一页
				currentPageNum = 1;
			}
		}

		// 设置每页显示的数量
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = 10; // 默认每页显示8条记录
		if (pageSizeStr != null) {
			try {
				pageSize = Integer.parseInt(pageSizeStr);
			} catch (Exception e) {// 如果有字符串，每页显示6条记录
				pageSize = 10;
			}
		}

		// 设置总记录数
		int totalCount = postService.getPostInfoCountLikeName(keywords);

		Page p = new Page();
		p.setPageSize(pageSize);
		p.setTotalCount(totalCount);

		// 判断总页数小于当前页
		int totalPageNum = p.getTotalPageNum();
		if (currentPageNum > totalPageNum) {
			currentPageNum = totalPageNum;
		}

		if (currentPageNum < 1) {
			currentPageNum = 1;
		}
		p.setCurrentPageNum(currentPageNum);

		List<Post> list = postService.queryPostInfoLikeNamePage(p, keywords);
		request.setAttribute("list", list);
		request.setAttribute("keywords", keywords);
		request.setAttribute("p", p);
		return "post/post_list";
	}

	// 实现跳转到添加帖子页
	@RequestMapping(value = "/addPost.html")
	public String addPost() {
		return "post/post_add";
	}

	@RequestMapping(value = "/toaddPost.html")
	public String toaddPost(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String postType = request.getParameter("postType");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		// postContent = (String) request.getAttribute("WordFilterContent");
		Post post = new Post();
		post.setUserName(name);
		post.setPostType(postType);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		int row = postService.addPostInfo(post);
		if (row > 0) {
			return "redirect:/sys/post/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/post/view.html";
		}
	}

	// 实现跳转到添加帖子页
	@RequestMapping(value = "/addSensitiveWords.html")
	public String addSensitiveWords() {
		return "post/sensitivewords_add";
	}

	@RequestMapping(value = "/toaddSensitiveWords.html")
	public String toaddSensitiveWords(HttpServletRequest request,
			HttpSession session) {
		
		String sensitivewords = request.getParameter("sensitivewords");
		Sensitivewords sensitiveword = new Sensitivewords();
		sensitiveword.setContent(sensitivewords);

		int row = sensitivewordsService.addSensitiveWordsInfo(sensitiveword);
		List<Sensitivewords>  senList = sensitivewordsService.getAllSensitivewords();			
		if (row > 0) {
			//application.setAttribute("ALL_SensitiveWords_List", senList);
			return "redirect:/sys/post/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/post/view.html";
		}
	}

	
	// 实现跳转到添加帖子页
	@RequestMapping(value = "/toPost.html")
	public String toPost(HttpServletRequest request) {
		String postId = request.getParameter("postId");
		Post post = new Post();
		post = postService.getPostByPostId(Integer.parseInt(postId));
		List<Comment> comments = commentService.getAllCommentByPostId(Integer.parseInt(postId));
		int rows = postService.updatePost(post);
		post = postService.getPostByPostId(Integer.parseInt(postId));
		post.setComments(comments);
		if(comments !=null){
		    post.setCommentCount(comments.size());
		}
		request.setAttribute("post", post);
		return "post/post_page";
	}
	
	//ajax添加评论并获取评论结果
	@RequestMapping(value = "/toaddComment.html" ,method = RequestMethod.POST)
	@ResponseBody
	public String toaddComment(HttpServletRequest request, HttpSession session) {
		String name = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String ip = request.getLocalAddr();
		String postId = request.getParameter("postId");
	    String content = request.getParameter("content");
		String result ="";
	    if(content != null && content.trim() != ""){
		    //content = (String) request.getAttribute("WordFilterContent");
	        Date now = new Date();      
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setUserName(name);
			comment.setUserIP(ip);
			comment.setPostId(Integer.parseInt(postId));
			comment.setCommentDate(now);
			int row = commentService.addCommentInfo(comment);	
			if (row==1) {
				logger.debug("评论添加成功！");
				result ="success";
			} else {
				logger.debug("评论添加失败！请联系管理员查找原因！");
				result ="评论添加失败！请联系管理员查找原因！";
			}			
	    }else{
	    	result ="评论内容不能为空！";
			logger.debug("评论内容不能为空！");
	    }
	    return result;
	}
	
	// 实现跳转到修改帖子
	@RequestMapping(value = "/modifyPost.html")
	public String modifyPost(HttpServletRequest request) {
		String postId = request.getParameter("postId");
		Post post = postService.getPostByPostId(Integer
				.valueOf(postId));
		request.setAttribute("post", post);
		return "post/post_modify";
	}
	
	@RequestMapping(value = "/tomodifyPost.html")
	public String tomodifyPost(HttpServletRequest request) {
		String postType = request.getParameter("postType");
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String postId = request.getParameter("postId");
		postContent = (String) request.getAttribute("WordFilterContent");
		Post post = new Post();
		post.setId(Integer.valueOf(postId));
		post.setPostType(postType);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		int row = postService.updatePostInfo(post);
		if (row > 0) {
			return "redirect:/sys/post/view.html";
		} else {
			request.setAttribute("error", "添加失败");
			return "redirect:/sys/post/view.html";
		}
	}
	
	// 实现跳转到修改帖子
	@RequestMapping(value = "/deletePost.html")
	public String deletePost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int postId = Integer.parseInt(request.getParameter("postId"));
		if(commentService.getAllCommentByPostId(postId).size() != 0 ){
	        logger.info("删除失败。该帖子下还有评论，不能删除！");
			request.setAttribute("error", "删除失败。该帖子下还有评论，不能删除！");
			return "redirect:/sys/post/view.html";
		}else{
			int row =  postService.deletePostById(postId);
			if (row > 0) {
				logger.info("删除成功！！");
				return "redirect:/sys/post/view.html";
			} else {
				logger.info("删除失败！！");
				request.setAttribute("error", "删除失败");
				return "redirect:/sys/post/view.html";
			}
		}
		
	}
}
