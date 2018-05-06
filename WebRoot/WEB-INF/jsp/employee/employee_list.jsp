<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>员工管理</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/user/employeeviewBy.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>员工名称：</span> <input name="queryEmployeeName" class="input-text"
					type="text" value="${queryEmployeeName}"> 
					<span>用户角色：</span> 
				<select name="queryUserRole">
					<c:if test="${roleList != null }">
						<option value="0">--请选择--</option>
						<c:forEach var="role" items="${roleList}">
							<option
								<c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
								value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</c:if>
				</select> 	
				<br/>
					<span>研发组名称：</span>
				<input name="queryDevgroupName" class="input-text" type="text"
					value="${queryDevgroupName}"> 
							<span>部门名称：</span>
				<input name="queryDepartmentName" class="input-text" type="text"
					value="${queryDepartmentName}">
							<span>公司名称：</span>
				<input name="queryCompanyName" class="input-text" type="text"
					value="${queryCompanyName}">
				
   		<input type="hidden"
					name="pageIndex" value="1" /> <input value="查 询" type="submit"
					id="searchbutton">
			</form>
		</div>
		<div id="content">
			<c:if
				test="${sessionScope.employee_Session.roleId eq '1' or sessionScope.employee_Session.roleId eq '2' }">
				<a
					href="${pageContext.request.contextPath}/sys/user/addEmployee.html">录入新员工?</a>
			</c:if>
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>序号&nbsp;&nbsp;</th>
						<th>员工名称&nbsp;&nbsp;</th>
						<th>角色名称&nbsp;&nbsp;</th>
						<th>所属研发组&nbsp;&nbsp;</th>
						<th>所属部门&nbsp;&nbsp;</th>
						<th>所属公司&nbsp;&nbsp;</th>
						<th>员工工分&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/sys/user/employeeviewBy.html?sort=asc">升序</a>
						<a href="${pageContext.request.contextPath}/sys/user/employeeviewBy.html?sort=desc">降序</a>
						</th>
						<th>操作权限</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="employee"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${employee.name}&nbsp;&nbsp;</td>
							<td>${employee.roleName}&nbsp;&nbsp;</td>
							<td>${employee.devgroupName}&nbsp;&nbsp;</td>
							<td>${employee.departmentName}&nbsp;&nbsp;</td>
							<td>${employee.companyName}&nbsp;&nbsp;</td>
							<td><a
								href="${pageContext.request.contextPath}/sys/workpoint/queryworkpointrecordByEmployeeId.html?id=${employee.id}">${employee.workpoints}</a>
							</td>
							<td><c:if
									test="${sessionScope.employee_Session.roleId eq '2'}">
									<a
										href="${pageContext.request.contextPath}/sys/user/modifyEmployee.html?id=${employee.id}">修改</a>
								</c:if> <c:if test="${sessionScope.employee_Session.roleId ne '2'}">
									<a>目前班主任角色开放管理权限</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			
			<input type="hidden" id="totalPageCount" value="${totalPageCount}" />
			<c:import url="/sys/rollPage/rollPage.html">
				<c:param name="totalCount" value="${totalCount}" />
				<c:param name="currentPageNo" value="${currentPageNo}" />
				<c:param name="totalPageCount" value="${totalPageCount}" />
			</c:import>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>