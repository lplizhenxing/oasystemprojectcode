<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>修改班级页面</span> </a>
		</div>
		<br />
		<div class="content">
			<form
				action="${pageContext.request.contextPath}/sys/classes/tomodifyclasses.html"
				method="post">
				<table>
					<tr>
						<td><input type="hidden" value="${requestScope.classes.id}"
							name="classId"><a>修改班级</a></td>
					</tr>
					<tr>
						<td>修改班级名称：<input type="text"
							value="${requestScope.classes.className}" name="className"
							required>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td>修改班主任：&nbsp;&nbsp;<select name="classLeader"
							id="classLeader"></select>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<
						<td>修改学术老师：&nbsp;&nbsp;<select name="classTeacher"
							id="classTeacher"></select>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><input type="submit" value="提交修改 "><input
							type="reset" value="重置">&nbsp;&nbsp;</td>
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

