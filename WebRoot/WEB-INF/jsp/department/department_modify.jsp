<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form action="department?opr=submitModify" method="post">
			<table>
				<tr>
					<td style="width:500px;"><input type="hidden"
						value="${requestScope.department.id}" name="departmentId">
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改部门名称：<input type="text"
						value="${requestScope.department.name}" name="departmentName">
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改部门电话：<input type="text"
						value="${requestScope.department.telephone}" name="departmentTel"
						id="departmentTel"> <font id="telText"></font>
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改部门传真：<input type="text"
						value="${requestScope.department.fax}" name="departmentFax"
						id="departmentFax"> <font id="faxText"></font>
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改部门地址：<select id="s_province"
						name="s_province"></select> <select id="s_city" name="s_city"></select>
						<select id="s_county" name="s_county"></select><input
						style="margin:2px 0 0 112.3px;" name="detail"></td>
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
		_init_area();
		$("#departmentTel").blur(checkTel);
		$("#departmentFax").blur(checkFax);
		function checkTel() {
			var mobile = $("#departmentTel").val();
			var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
			if (!reg.test(mobile)) {
				$("#telText").html("电话号码不正确！");
				return false;
			}
			$("#telText").html("");
			return true;
		}
		function checkFax() {
			var mobile = $("#departmentFax").val();
			var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
			if (!reg.test(mobile)) {
				$("#faxText").html("传真号码不正确！");
				return false;
			}
			$("#faxText").html("");
			return true;
		}
	});
</script>