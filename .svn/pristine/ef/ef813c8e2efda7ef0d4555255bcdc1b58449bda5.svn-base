package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Comment;
import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Post;
import com.zszd.ai.service.comment.CommentService;
import com.zszd.ai.service.comment.CommentServiceImpl;
import com.zszd.ai.service.post.PostService;
import com.zszd.ai.service.post.PostServiceImpl;
/**
 * 帖子
 * @author lizx 20180103
 *
 */
@WebServlet(urlPatterns = { "/post" }, name = "post")
public class PostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		PostService postService = new PostServiceImpl();
		CommentService commentService = new CommentServiceImpl();
		String opr = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		if ("post".equals(opr)) {
			String postId = request.getParameter("postId");
			Post post = new Post();
			post = postService.getPostByPostId(Integer.parseInt(postId));
			List<Comment> comments = commentService.getAllCommentByPostId(Integer.parseInt(postId));
			int rows = postService.updatePost(post);
			post = postService.getPostByPostId(Integer.parseInt(postId));
			post.setComments(comments);
			request.setAttribute("post", post);
			request.getRequestDispatcher("jsp/post/post_page.jsp").forward(
					request, response);
		} else if ("add".equals(opr)) {
			String postType = request.getParameter("postType");
			String postTitle = request.getParameter("postTitle");
			String postContent = request.getParameter("postContent");
			postContent = (String) request.getAttribute("WordFilterContent");
			Post post = new Post();
			post.setUserName(name);
			post.setPostType(postType);
			post.setPostTitle(postTitle);
			post.setPostContent(postContent);

			try {
				int row = postService.addPostInfo(post);

				if (row > 0) {
					out.print("<script type='text/javascript'>");
					out.print("alert('帖子发表成功，点击确认回到首页！');");
					out.print("location.href=\"" + basePath
							+ "post?opr=search\";");
					out.print("</script>");
				} else {
					out.print("<script type='text/javascript'>");
					out.print("alert('帖子发表失败，请重新添加！');");
					out.print("location.href=\"" + basePath
							+ "jsp/post/post_add.jsp\";");
					out.print("</script>");
				}
			} catch (Exception e) {
				out.print("<script type='text/javascript'>");
				out.print("alert('帖子发表失败，记录已存在，点击确认返回首页！');");
				out.print("location.href=\"" + basePath + "post?opr=search\";");
				out.print("</script>");
			}
		} else if ("modify".equals(opr)) {
			String postId = request.getParameter("postId");
			postService = new PostServiceImpl();
			Post post = postService.getPostByPostId(Integer
					.valueOf(postId));
			request.setAttribute("post", post);
			request.getRequestDispatcher("jsp/post/post_modify.jsp").forward(
					request, response);
		} else if ("delete".equals(opr)) {
			String postId = request.getParameter("postId");
			out.print("<script type='text/javascript'>");
			out.print("alert('确认要删除吗？点击确认删除！');");
			out.print("location.href=\"" + basePath
					+ "post?opr=deletePost&postId=" + postId + "\";");
			out.print("</script>");
		} else if ("submitModify".equals(opr)) {
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
				out.print("<script type='text/javascript'>");
				out.print("alert('当前帖子信息更新成功，点击确认返回帖子信息列表！');");
				out.print("location.href=\"" + basePath + "post?opr=search\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('当前帖子信息更新成功，点击确认返回帖子信息列表！');");
				out.print("location.href=\"" + basePath + "post?opr=search\";");
				out.print("</script>");
			}
		} else if ("deletePost".equals(opr)) {
			String postId = request.getParameter("postId");
			if (postService.deletePostById(Integer.valueOf(postId)) > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('当前帖子信息更新成功，点击确认返回帖子信息列表！');");
				out.print("location.href=\"" + basePath + "post?opr=search\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('当前帖子信息更新成功，点击确认返回帖子信息列表！');");
				out.print("location.href=\"" + basePath + "post?opr=search\";");
				out.print("</script>");
			}
		} else if ("search".equals(opr)) {
			String keywords = request.getParameter("keywords");
			if (keywords == null) {
				keywords = "";
			}

			//获取当前页的页码
			String currentPageNumStr = request
					.getParameter("currPageNum");
			int currentPageNum = 1;//默认当前页是第一页
			if (currentPageNumStr != null) {
				try {
					currentPageNum = Integer.parseInt(currentPageNumStr);
				} catch (Exception e) {//如果有字符串，就调到第一页
					currentPageNum = 1;
				}
			}

			//设置每页显示的数量
			String pageSizeStr = request.getParameter("pageSize");
			int pageSize = 10; // 默认每页显示8条记录
			if (pageSizeStr != null) {
				try {
					pageSize = Integer.parseInt(pageSizeStr);
				} catch (Exception e) {//如果有字符串，每页显示6条记录
					pageSize = 10;
				}
			}

			//设置总记录数
			int totalCount = postService
					.getPostInfoCountLikeName(keywords);

			Page p = new Page();
			p.setPageSize(pageSize);
			p.setTotalCount(totalCount);


			//判断总页数小于当前页
			int totalPageNum = p.getTotalPageNum();
			if (currentPageNum > totalPageNum) {
				currentPageNum = totalPageNum;
			}
			
			if(currentPageNum<1){
			    currentPageNum=1;
			}
			p.setCurrentPageNum(currentPageNum);

			List<Post> list = postService
					.queryPostInfoLikeNamePage(p,keywords);
			request.setAttribute("list", list);
			request.setAttribute("keywords", keywords);
			request.setAttribute("p", p);

			request.getRequestDispatcher("jsp/post/post_list.jsp")
					.forward(request, response);
		}
	}
}
