<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>部门管理</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/department/view.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>部门名称：</span> <input name="queryDepartmentName" class="input-text"
					type="text" value="${queryDepartmentName}"> <span>公司名称：</span> <input
					name="queryCompanyName" class="input-text" type="text"
					value="${queryCompanyName}">
					<input type="hidden"
					name="pageIndex" value="1" /> <input value="查 询" type="submit"
					id="searchbutton">
			</form>
		</div>
		<div id="content">
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>序号&nbsp;&nbsp;</th>
						<th>部门名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>所属公司&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>成立时间&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>操作权限</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="department"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${department.name}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${department.companyName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${department.buildTime}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><c:if
									test="${sessionScope.employee_Session.roleId eq 4}">
									<a
										href="/zszd/sys/department/modifydepartment.html?id=${department.id}">修改</a>
									<a
										href="/zszd/sys/department/deletedepartment.html?id=${department.id}">删除</a>
								</c:if> <c:if test="${sessionScope.employee_Session.roleId ne 4}">
									<a>目前总裁角色开放管理权限</a>
								</c:if>
							</td>
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

