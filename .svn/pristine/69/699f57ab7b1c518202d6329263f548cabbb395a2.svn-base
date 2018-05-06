<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="add">
	<div id="right">
		<form action="${pageContext.request.contextPath}/sys/requirements/toaddRequirements.html" method="post">
			<table>
				<tr>
					<td>需求标题：&nbsp;&nbsp;</td>
					<td><input id="requirementsTitle" type="text"
						name="requirementsTitle" /></td>
				</tr>
				<tr>
					<td>需求内容：&nbsp;&nbsp;</td>
					<td><textarea id="requirementsContent"
							name="requirementsContent" rows="20" cols="70"></textarea></td>
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
			var requirementsTitle = $("#requirementsTitle").val();
			if (requirementsTitle.trim() == "") {
				alert("标题不能为空！");
				return false;
			}

			var requirementsContent = $("#requirementsContent").val();
			if (requirementsContent.trim() == "") {
				alert("内容不能为空！");
				return false;
			}

			return true;
		});
	});
</script>
