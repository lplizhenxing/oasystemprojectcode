<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form
			action="${pageContext.request.contextPath}/sys/leave/toaddLeave.html"
			method="post">
			<table>
				<tr>
					<td>请假理由：&nbsp;&nbsp;</td>
					<td><textarea rows="20" cols="40" id="leaveReason"
							name="leaveReason"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交">
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
			var postTitle = $("#leaveReason").val();
			if (postTitle.trim() == "") {
				alert("请假理由不能为空！");
				return false;
			}
			return true;
		});
	});
</script>

