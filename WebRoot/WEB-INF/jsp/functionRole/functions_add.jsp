<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>添加功能页面</span> </a>
		</div>
		<br />
		<div class="content">
			<form
				action="${pageContext.request.contextPath}/sys/functionRole/toaddfunction.html"
				method="post">
				<table>
					<tr>
						<td colspan="2"><a>添加功能</a>
						</td>
					</tr>
					<tr>
						<td>功能名称</td>
						<td><input id="functionsName" type="text"
							name="functionsName" /></td>
					</tr>
					<tr>
						<td>功能路径</td>
						<td><input id="functionsPath" type="text"
							name="functionsPath" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="提交">
						</td>
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
		var role = "opr=query";
		$.get("role", role, function callback(data) {
			var jsonObj = eval("(" + data + ")");
			var optionstring = "";
			for ( var item in jsonObj) {
				optionstring += "<option value=\""+ item +"\" >"
						+ jsonObj[item] + "</option>";
			}
			$("#roleId").html(optionstring);
		});

		var functions = "opr=query";
		$.get("functions", functions, function callback(data) {
			var jsonObj = eval("(" + data + ")");
			var optionstring = "";
			for ( var item in jsonObj) {
				optionstring += "<option value=\""+ item +"\" >"
						+ jsonObj[item] + "</option>";
			}
			$("#functionId").html(optionstring);
		});
	});

	$("form").submit(function() {
		var functionsName = $("#functionsName").val();
		if (functionsName.trim() == "") {
			alert("功能名称不能为空！");
			return false;
		}

		var functionsPath = $("#functionsPath").val();
		if (functionsPath.trim() == "") {
			alert("功能路径不能为空！");
			return false;
		}
		return true;
	});
</script>
