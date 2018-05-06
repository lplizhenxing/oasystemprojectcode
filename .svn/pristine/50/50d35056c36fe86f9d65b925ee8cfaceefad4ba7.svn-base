<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form action="${pageContext.request.contextPath}/sys/requirements/oprRequirements.html?opr=tomodify" method="post">
			<input type="hidden" value="${requestScope.requirements.id}"
				name="id"><br />
			<table>
				<tr>
					<td>修改需求标题：&nbsp;&nbsp;</td>
					<td><input id="requirementsTitle" type="text"
						name="requirementsTitle"
						value="${requestScope.requirements.title}" /></td>
				</tr>
				<tr>
					<td>修改需求内容：&nbsp;&nbsp;</td>
					<td><textarea id="requirementsContent"
							name="requirementsContent" rows="20" cols="70">${requestScope.requirements.content}</textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交修改 ">
					</td>
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

