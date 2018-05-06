<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<h1>修改评论信息</h1>
	<form action="comment?opr=submitModify" method="post">
		<input type="hidden" value="${requestScope.comment.id}"
			name="commentId"><br /> 修改评论内容：
		<textarea name="content" rows="20" cols="60">${requestScope.comment.content}
			 </textarea>
		<br /> <input type="submit" value="提交修改 ">
	</form>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

