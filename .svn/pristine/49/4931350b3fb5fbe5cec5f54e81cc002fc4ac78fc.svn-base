<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form
			action="${pageContext.request.contextPath}/sys/complaint/toaddComplaint.html"
			" method="post">
			<table>
				<tr>
					<td>投诉内容：&nbsp;&nbsp;</td>
					<td><textarea id="complaintContent" name="complaintContent"
							rows="10" cols="70"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交">
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
			var postContent = $("#complaintContent").val();
			if (postContent.trim() == "") {
				alert("投诉内容不能为空！");
				return false;
			}
			return true;
		});
	});
</script>

