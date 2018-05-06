<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<%
			String keywords = (String) request.getAttribute("keywords");
		%>
		<form action="${pageContext.request.contextPath}/sys/post/view.html"
			method="post">
			帖子关键词：<input type="text" name="keywords" value="<%=keywords%>" /> <input
				type="submit" value="查找" /> <span> <a
				href="${pageContext.request.contextPath}/sys/post/addPost.html"
				style="color:red">发个帖子?</a> <c:if
					test="${sessionScope.employee_Session.roleId eq '2'}">
		           &nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/sys/post/addSensitiveWords.html">增加敏感词</a>
				</c:if> &nbsp;&nbsp;&nbsp;&nbsp; <span style='color:red'>请大家认真发帖，文明灌水！</span>
				&nbsp;&nbsp;&nbsp;&nbsp; </span>
		</form>
		<br />
		<div id="postpage">
			<c:if test="${requestScope.p != null}">
				<span>[${requestScope.p.currentPageNum} /
					${requestScope.p.totalPageNum}]</span>
				<span>总记录数：${requestScope.p.totalCount }</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/sys/post/view.html?currPageNum=1&keywords=<%=keywords%>">首页</a>
				<c:if test="${requestScope.p.currentPageNum > 1}">
					<a
						href="${pageContext.request.contextPath}/sys/post/view.html?currPageNum=${requestScope.p.currentPageNum-1}&keywords=<%=keywords%>">上一页</a>
				</c:if>
				<c:if test="${requestScope.p.currentPageNum <= 1}">
					<a>上一页</a>
				</c:if>
				<c:if
					test="${requestScope.p.currentPageNum <= requestScope.p.totalPageNum}">
					<a
						href="${pageContext.request.contextPath}/sys/post/view.html?currPageNum=${requestScope.p.currentPageNum+1}&keywords=<%=keywords%>">下一页</a>
				</c:if>
				<c:if
					test="${requestScope.p.currentPageNum > requestScope.p.totalPageNum}">
					<a>下一页</a>
				</c:if>
				<a
					href="${pageContext.request.contextPath}/sys/post/view.html?currPageNum=${requestScope.p.totalPageNum}&keywords=<%=keywords%>">末页</a>
			</c:if>
		</div>
		<br />
		<table>
			<c:if test="${requestScope.list!=null}">
				<c:forEach items="${requestScope.list}" var="post">
					<tr>
						<td style="width:800px;text-align:left;"><a
							href="${pageContext.request.contextPath}/sys/post/toPost.html?postId=${post.id}">${post.postType}:&nbsp;&nbsp;${post.postTitle}</a>
						</td>
					</tr>
					<tr>
						<td style="width:1000px;text-align:left;"><span>
								发表人：${post.userName} &nbsp;&nbsp; 发表时间：${post.postDate}
								&nbsp;&nbsp; 评论数：（${post.commentCount == 0?"暂无评论":
								post.commentCount}）&nbsp;&nbsp; 访问量：（${post.clickCount ==
								0?"暂无评论": post.clickCount}） </span> <c:if
								test="${sessionScope.employee_Session.roleId ne '6' or  post.userName eq sessionScope.employee_Session.name}">
								<a href="${pageContext.request.contextPath}/sys/post/modifyPost.html?postId=${post.id}">修改</a>
							</c:if> <c:if test="${sessionScope.employee_Session.roleId eq '2'}">
								<a href="${pageContext.request.contextPath}/sys/post/deletePost.html?postId=${post.id}">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

