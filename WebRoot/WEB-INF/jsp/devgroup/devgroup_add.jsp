<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form action="devgroup?opr=submitAdd" method="post">
			<table>
				<tr>
					<td style="width:500px;">新增组名：<input type="text"
						name="groupname" required />
					</td>
				</tr>
				<tr>
					<td style="width:500px;">新增口号：<input type="text" name="watch"
						required />
					</td>
				</tr>
				<tr>
					<td style="width:500px;">部门名称：<select name="deId"
						id="departmentId"></select>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交 ">
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
	});
</script>