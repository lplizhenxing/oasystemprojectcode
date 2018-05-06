<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/company/tomodifycompany.html"
			method="post">
			<table>
				<tr>
					<td style="width:500px;"><input type="hidden"
						value="${requestScope.company.id}" name="companyId"><a>修改公司信息</a>
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改公司名称：<input type="text"
						value="${requestScope.company.name}" name="companyName" required>&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改公司网站：<input type="text" id="url"
						value="${requestScope.company.url}" name="companyUrl"><font
						id="urlText"></font>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td style="width:500px;">修改公司电话：<input type="text" id="tel"
						value="${requestScope.company.telephone}" name="companyTel"><font
						id="telText"></font>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td style="width:500px;">修改公司传真：<input type="text" id="fax"
						value="${requestScope.company.fax}" name="companyFax"><font
						id="faxText"></font>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td style="width:500px;">修改公司地址：<select id="s_province"
						name="s_province"></select> <select id="s_city" name="s_city"></select>
						<select id="s_county" name="s_county"></select><input
						style="margin:2px 0 0 112.3px;" name="detail">&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td style="width:500px;">修改所属班级：<select name="classId"
						id="classId"></select>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>修改创建时间：&nbsp;&nbsp;<input type="date" name="buildTime" value="${requestScope.company.buildTime}
						id="buildTime" placeholder="选择日期" />&nbsp;
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交修改 ">
					<input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script class="resources library"
	src="http://sandbox.runjs.cn/uploads/rs/267/g3ugugjp/area.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$("form").submit(function() {
		var comname = $("#comname").val();
		if (comname.trim() == "") {
			alert("公司名称不能为空！");
			return false;
		}

		var buildTime = $("#buildTime").val();
		if (buildTime.trim() == "") {
			alert("成立日期不能为空！");
			return false;
		}
		
		var tel = $("#tel").val();
		if (tel.trim() == "") {
			alert("公司电话不能为空！");
			return false;
		}
		return true;
	});

	$(function() {
		_init_area();
		$.ajax({
			type : "GET",
			url : "/zszd/sys/classes/queryAllClasses.html",
			dataType : "json",
			success : function(data) {
				var obj = eval(data);
				var optionStr = "";
				$(obj).each(
						function(index) {
							var val = obj[index];
							optionStr += "<option value=\""+val.id+"\">"
									+ val.className + "</option>";
						});
				$("#classId").html(optionStr);
			}
		});

		$("#tel").blur(checkTel);
		$("#fax").blur(checkFax);
		$("#url").blur(checkUrl);
		$("#submit").submit(function() {
			var flag = true;
			if (checkTel())
				flag = false;
			if (!checkFax())
				flag = false;
			if (!checkUrl())
				flag = false;
			return flag;
		});
		function checkTel() {
			var mobile = $("#tel").val();
			var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
			if (!reg.test(mobile)) {
				$("#telText").html("*电话号码不正确！");
				return false;
			}
			$("#telText").html("*");
			return true;
		}
		function checkFax() {
			var mobile = $("#fax").val();
			if (mobile != "") {
				var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
				if (!reg.test(mobile)) {
					$("#faxText").html("*传真号码不正确！");
					return false;
				}
				$("#faxText").html("*");
			}
			return true;
		}
		function checkUrl() {
			var mobile = $("#url").val();
			if (mobile != "") {
				var reg = /^(((ht|f)tp(s?))\:\/\/)?(www.|[a-zA-Z].)[a-zA-Z0-9\-\.]+\.(com|edu|gov|mil|net|org|biz|info|name|museum|us|ca|uk)$/;
				if (!reg.test(mobile)) {
					$("#urlText").html("*网址不正确！");
					return false;
				}
				$("#urlText").html("*");
			}
			return true;
		}
	});
</script>

