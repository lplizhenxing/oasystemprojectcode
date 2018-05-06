<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/complaint/tofeedbackcomplaint.html"
			method="post">
			<table>
				<tr>
					<td><input type="hidden" value="${requestScope.complaint.id}"
						name="complaintId"><a>反馈投诉信息</a></td>
				</tr>
				<tr>
					<td>投诉内容：&nbsp;&nbsp;</td>
					<td><textarea rows="5" cols="70" disabled>${requestScope.complaint.content}</textarea>
					</td>
				</tr>
				<tr>
					<td>反馈内容：&nbsp;&nbsp;</td>
					<td><textarea id="feedbackContent" name="feedbackContent"
							rows="5" cols="70">${requestScope.complaint.feedback}</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
					<td><input type="reset" value="重置">
					</td>
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
			var postContent = $("#feedbackContent").val();
			if (postContent.trim() == "") {
				alert("反馈内容不能为空！");
				return false;
			}
			return true;
		});
	});
</script>


