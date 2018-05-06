<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>添加角色功能配置页面</span>
			</a>
		</div>
		<br />
		<div class="content">
			<form
				action="${pageContext.request.contextPath}/sys/functionRole/toaddfunctionrole.html"
				method="post">
				<table>
					<tr>
						<td colspan="2"><a>添加角色功能配置</a></td>
					</tr>
					<tr>
						<td>角色名称</td>
						<td><select name="roleId" id="roleId"></select>
						</td>
					</tr>
					<tr>
						<td>功能名称</td>
						<td><select name="functionId" id="functionId"></select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "GET",
			url : "/zszd/sys/functionRole/queryRoles.html",
			dataType : "json",
			success : function(data) {
				var obj = eval(data);
				var optionStr = "";
				$(obj).each(
						function(index) {
							var val = obj[index];
							optionStr += "<option value=\""+ val.id +"\" >"
									+ val.roleName + "</option>";
						});
				$("#roleId").html(optionStr);
			}
		});

		$.ajax({
			type : "GET",
			url : "/zszd/sys/functionRole/queryFunctions.html",
			dataType : "json",
			success : function(data) {
				var obj = eval(data);
				var optionStr = "";
				$(obj).each(
						function(index) {
							var val = obj[index];
							optionStr += "<option value=\""+ val.id +"\" >"
									+ val.functionName + "</option>";
						});
				$("#functionId").html(optionStr);
			}
		});
	});
</script>

