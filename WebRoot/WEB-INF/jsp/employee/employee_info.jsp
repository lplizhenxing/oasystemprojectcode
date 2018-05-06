<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/user/modifypersonInfo.html"
			method="post">
			<!-- disabled readonly -->
			<table>
				<tr>
					<td>员工名称：&nbsp;&nbsp;</td>
					<td><input name="name" id="name" type="text"
						value="${requestScope.employee.name}" disabled>&nbsp;&nbsp;</td>
					<td>登录帐号：&nbsp;&nbsp;</td>
					<td><input name="abbr" id="abbr" type="text"
						value="${requestScope.employee.abbr}" disabled>
					</td>
				</tr>
				<tr>
					<td>姓名拼音：&nbsp;&nbsp;</td>
					<td><input name="namePinyin" id="namePinyin" type="text"
						value="${requestScope.employee.namePinyin}" disabled>&nbsp;&nbsp;</td>
					<td>性别：&nbsp;&nbsp;</td>
					<td><input name="sex" id="sex" type="text"
						value="${requestScope.employee.sex}" disabled>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>班主任：&nbsp;&nbsp;</td>
					<td><input name="classLeader" id="classLeader" type="text"
						value="${requestScope.employee.classLeader}" disabled>&nbsp;&nbsp;</td>
					<td>学术老师：&nbsp;&nbsp;</td>
					<td><input name="classTeacher" id="classTeacher" type="text"
						value="${requestScope.employee.classTeacher}" disabled>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>生日：&nbsp;&nbsp;</td>
					<td><input name="birthday" id="birthday" type="date"
						value="${requestScope.employee.birthday}">&nbsp;&nbsp;</td>
					<td>年龄（自动计算）：&nbsp;&nbsp;</td>
					<td><input name="birthday" id="birthday" type="text"
						value="${requestScope.employee.age}" readonly>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>工作种类：&nbsp;&nbsp;</td>
					<td><input name="workType" id="workType" type="text"
						value="${requestScope.employee.workType}">&nbsp;&nbsp;</td>
					<td>工作单位：&nbsp;&nbsp;</td>
					<td><input name="workUnit" id="workUnit" type="text"
						value="${requestScope.employee.workUnit}">
					</td>
				</tr>
				<tr>
					<td>工作状态：&nbsp;&nbsp;</td>
					<td><input name="workState" id="workState" type="text"
						value="${requestScope.employee.workState}">&nbsp;&nbsp;</td>
					<td>专业：&nbsp;&nbsp;</td>
					<td><input name="major" id="major" type="text"
						value="${requestScope.employee.major}">
					</td>
				</tr>
				<tr>
					<td>毕业学校：&nbsp;&nbsp;</td>
					<td><input name="endSchool" id="endSchool" type="text"
						value="${requestScope.employee.endSchool}">&nbsp;&nbsp;</td>
					<td>最高学历：&nbsp;&nbsp;</td>
					<td><input name="education" id="education" type="text"
						value="${requestScope.employee.education}">
					</td>
				</tr>
				<tr>
					<td>毕业时间：&nbsp;&nbsp;</td>
					<td><input name="endTime" id="endTime" type="text"
						value="${requestScope.employee.endTime}">&nbsp;&nbsp;</td>
					<td>邮政编码：&nbsp;&nbsp;</td>
					<td><input name="postalcode" id="postalcode" type="text"
						value="${requestScope.employee.postalcode}">
					</td>
				</tr>
				<tr>
					<td>手机号码：&nbsp;&nbsp;</td>
					<td><input name="phone" id="phone" type="text"
						value="${requestScope.employee.phone}">&nbsp;&nbsp;</td>
					<td>通信地址：&nbsp;&nbsp;</td>
					<td><input name="address" id="address" type="text"
						value="${requestScope.employee.address}">
					</td>
				</tr>
				<tr>
					<td>就业意向城市：&nbsp;&nbsp;</td>
					<td><input name="intentionalCity" id="intentionalCity"
						type="text" value="${requestScope.employee.intentionalCity}">&nbsp;&nbsp;</td>
					<td>就业意向岗位：&nbsp;&nbsp;</td>
					<td><input name="intentionalPost" id="intentionalPost"
						type="text" value="${requestScope.employee.intentionalPost}">
					</td>
				</tr>
				<tr>
					<td>云豆号：&nbsp;&nbsp;</td>
					<td><input name="email" id="email" type="text"
						value="${requestScope.employee.email}">&nbsp;&nbsp;</td>
				</tr>
			</table>
			<input type="submit" value="保存">
		</form>
		<div id="msg" style="display:none;"></div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

<script type="text/javascript" src="/ShareBike/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//$("form input").attr("disabled", "disabled");
		var v = document.getElementById('email');
		v.onblur = function() {
			if (v.value == null) {
				v.value = '';
			}
		}

		$("#edit").click(function() {
			$("form input").removeAttr("disabled");

		});

	});
</script>