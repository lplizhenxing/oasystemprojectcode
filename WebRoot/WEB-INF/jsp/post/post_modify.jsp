<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form action="${pageContext.request.contextPath}/sys/post/tomodifyPost.html" method="post">
			<input type="hidden" value=${requestScope.post.id } name="postId">
			<table>
				<tr>
					<td style="width:100px">修改帖子类型：&nbsp;&nbsp;</td>
					<td><input type="text" value="${requestScope.post.postType}"
						name="postType" readonly="readonly"><br /></td>
				</tr>
				<tr>
					<td style="width:100px">修改帖子标题：&nbsp;&nbsp;</td>
					<td><input id="postTitle" type="text"
						value="${requestScope.post.postTitle}" name="postTitle"><br />
					</td>
				</tr>
				<tr>
					<td style="width:100px">修改帖子内容：&nbsp;&nbsp;</td>
					<td><textarea id="postContent" name="postContent" rows="20"
							cols="70">${requestScope.post.postContent}</textarea>
					</td>
				</tr>
				<tr>
					<td style="width:100px"><input type="submit" value="提交修改 ">
					</td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var postTitle = $("#postTitle").val();
			if (postTitle.trim() == "") {
				alert("标题不能为空！");
				return false;
			}

			var postContent = $("#postContent").val();
			if (postContent.trim() == "") {
				alert("内容不能为空！");
				return false;
			}

			if (postContent.indexOf("<") != -1) {
				alert("内容不能包含<符合，为了不非法注入代码！");
				return false;
			}

			if (postContent.indexOf(">") != -1) {
				alert("内容不能包含>符合，为了不非法注入代码！");
				return false;
			}

			return true;
		});
	});
</script>
