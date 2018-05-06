<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<h3>评论列表</h3>
	<table>
		<c:if test="${requestScope.list!=null}">
			<tr>
				<th>评论人</th>
				<th>评论主题</th>
				<th>评论内容</th>
				<th>评论时间</th>
				<th>操作权限</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="comment">
				<tr>
					<td colspan="5"><br />
					</td>
				<tr>
				<tr>
					<td>${comment.userName}</td>
					<td>${comment.postId}</td>
					<td style="width:500px">${comment.content}</td>
					<td>${comment.commentDate}</td>
					<td><c:if test="${sessionScope.login eq 'admin'}">
							<a href='comment?opr=modify&commentId=${comment.id}'
								style="color:red">修改</a>
							<br />
							<a href='comment?opr=delete&commentId=${comment.id}'
								style="color:red">删除</a>
						</c:if></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

