<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form action="devgroup?opr=submitModify" method="post">
			<table>
				<tr>
					<td style="width:500px;"><input type="hidden"
						value="${requestScope.devgroup.id}" name="groupId"></td>
				</tr>
				<tr>
					<td style="width:500px;">修改组名：<input type="text"
						value="${requestScope.devgroup.name}" name="groupname"></td>
				</tr>
				<tr>
					<td style="width:500px;">修改口号：<input type="text"
						value="${requestScope.devgroup.watchword}" name="watch"></td>
				</tr>
				<tr>
					<td style="width:500px;">修改部门：<select name="deId"
						id="departmentId">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交修改 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
	});
</script>