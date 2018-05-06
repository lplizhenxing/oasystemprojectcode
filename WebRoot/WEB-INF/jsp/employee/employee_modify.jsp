<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<table>
			<h3>修改员工信息</h3>
			<form
				action="${pageContext.request.contextPath}/sys/user/tomodifyEmployee.html"
				method="post">
				<input type="hidden" value="${requestScope.employee.id}"
					name="employeeId">
				<tr>
					<td>修改员工名称：</td>
					<td><input type="text" value="${requestScope.employee.name}"
						name="employeename"></td>
				</tr>
				<tr>
					<td>修改员工证件号码：</td>
					<td><input type="text"
						value="${requestScope.employee.validDocuments}"
						name="validDocuments"></td>
				</tr>
				<tr>
					<td>修改员工工分：</td>
					<td><input type="text"
						value="${requestScope.employee.workpoints}" name="workpoints">
					</td>
				</tr>
				<tr>
					<td>修改员工角色：</td>
					<td><select name="roleId" id="roleId">
							<c:if test="${roles != null }">
								<option value="0">--请选择--</option>
								<c:forEach var="role" items="${roles}">
									<option  <c:if test="${role.id == employee.roleId }">selected="selected"</c:if>
									value="${role.id}">${role.roleName}</option>
								</c:forEach>
							</c:if>
					</select></td>
				</tr>
				<tr>
					<td>修改员工公司：</td>
					<td><select name="companyId" id="companyId">
							<c:if test="${companies != null }">
								<option value="0">--请选择--</option>
								<c:forEach var="company" items="${companies}">
									<option  <c:if test="${company.id == employee.companyId }">selected="selected"</c:if>
									value="${company.id}">${company.name}</option>
								</c:forEach>
							</c:if>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交修改 "></td>
				</tr>
			</form>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
