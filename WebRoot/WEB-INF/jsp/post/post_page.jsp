<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<h3>${requestScope.post.postTitle}</h3>
		<br/>
		<p style="font-size:15px">类型：${requestScope.post.postType}
			日期：${requestScope.post.postDate} 作者：${requestScope.post.userName}
			评论数：${requestScope.post.commentCount}
			访问量：${requestScope.post.clickCount}</p>
		<div id="postContent"
			style="font-size:25px;white-space:pre-wrap;width:600px;WORD-WRAP: break-word;">
			${requestScope.post.postContent}</div>
		<hr />
		<div id="comment">
			<ul class="classlist">
				<table width="80%">
					<c:choose>
						<c:when test="${empty post.comments}">
							<tr>
								<td colspan="3">暂无评论！</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${post.comments}" var="comment">
								<tr>
									<td>留言人:${comment.userName}</td>
									<td>IP:${comment.userIP}</td>
									<td>留言时间:${comment.commentDate}</td>
								</tr>
								<tr>
									<td colspan="3">${comment.content}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</ul>
			<ul class="classList">
				<form action="" method="post">
					<input type="hidden" id="postId" name="postId"
						value="${requestScope.post.id}" />
					<table>
						<tr>
							<td>用户名：<input type="text" id="cname" name="cname"
								value="${sessionScope.employee_Session.name}" disabled /></td>
							<td>IP：<input type="text" id="cip" name="cip"
								value=<%=request.getRemoteAddr()%> disabled /></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content" rows="20" cols="60"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="button" value="发 表"
								id="commentSubmit" name="submit"></td>
						</tr>
					</table>
				</form>
			</ul>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var $formArea = $("ul.classList").eq(1);
						var $commentInputs = $formArea.find(":input");
						var $commentArea = $("#commentList");

						$("#commentSubmit")
								.click(

										function() {
											var paramsArray = $commentInputs
													.serializeArray();
											var query = $.param(paramsArray);
											$
													.post(
															"/zszd/sys/post/toaddComment.html",
															query, callBack,
															"json");

											function callBack(data) {
												if (data == "success") {
													var $postComment = $("<tr><td>留言人：</td><td>cname</td></tr>");
													$(paramsArray)
															.each(
																	function() {
																		$postComment
																				.find(
																						"td:contains('"
																								+ this.name
																								+ "')")
																				.text(
																						this.value);
																	});
													$commentArea
															.prepend($postComment);
													alert("评论发表成功，点击确认查看发表评论！");
													location.reload();
												} else {
													alert(data);
													location.reload();
												}
											}
										});
					});
</script>

