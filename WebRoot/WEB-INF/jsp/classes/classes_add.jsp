<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>添加班级页面</span> </a>
		</div>
		<br />
		<div class="content">
			<div id="mess">${empty requestScope.message
				?"":"验证信息:"}${requestScope.message}</div>
			<form
				action="${pageContext.request.contextPath}/sys/classes/toaddClasses.html"
				method="post">
				<table>
					<tr>
						<td colspan="3"><a>添加班级</a>
						</td>
					</tr>
					<tr>
						<td>班级名称：&nbsp;&nbsp;</td>
						<td><input type="text" name="className" id="className">&nbsp;<font
							color="red">*</font>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>班主任：&nbsp;&nbsp;</td>
						<td><select name="classLeader" id="classLeader"></select>&nbsp;<font
							color="red">*</font>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>学术老师：&nbsp;&nbsp;</td>
						<td><select name="classTeacher" id="classTeacher"></select>&nbsp;<font
							color="red">*</font>
						</td>
						<td></td>
					</tr>

					<tr>
						<td colspan="3"><input type="submit" value="提交" id="submit">
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
	$("form").submit(function() {
		var className = $("#className").val();
		if (className.trim() == "") {
			alert("班级名称不能为空！");
			return false;
		}
		return true;
	});

	$(function() {
		$.ajax({
			type : "GET",
			url : "/zszd/sys/user/queryAllClassLeader.html",
			dataType : "json",
			success : function(data) {
				var obj = eval(data);
				var optionStr = "";
				$(obj).each(
						function(index) {
							var val = obj[index];
							optionStr += "<option value=\""+val.id+"\">"
									+ val.name + "</option>";
						});
				$("#classLeader").html(optionStr);
			}
		});

		$.ajax({
			type : "GET",
			url : "/zszd/sys/user/queryAllClassTeacher.html",
			dataType : "json",
			success : function(data) {
				var obj = eval(data);
				var optionStr = "";
				$(obj).each(
						function(index) {
							var val = obj[index];
							optionStr += "<option value=\""+val.id+"\">"
									+ val.name + "</option>";
						});
				$("#classTeacher").html(optionStr);
			}
		});

	});
</script>

