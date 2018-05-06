<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>研发组管理</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/devgroup/view.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>研发组名称：</span> <input name="queryDevgroupName" class="input-text"
					type="text" value="${queryDevgroupName}"> <span>部门名称：</span> <input
					name="queryDepartmentName" class="input-text" type="text"
					value="${queryDepartmentName}"> <span>公司名称：</span> <input
					name="queryCompanyName" class="input-text" type="text"
					value="${queryCompanyName}"> <input type="hidden"
					name="pageIndex" value="1" /> <input value="查 询" type="submit"
					id="searchbutton">
			</form>
		</div>
		<div id="content">
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>序号&nbsp;&nbsp;</th>
						<th>研发组名称&nbsp;&nbsp;</th>
						<th>所属部门&nbsp;&nbsp;</th>
						<th>所属公司&nbsp;&nbsp;</th>
						<th>研发组口号&nbsp;&nbsp;</th>
						<th>操作权限</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="devgroup"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${devgroup.name}&nbsp;&nbsp;</td>
							<td>${devgroup.departmentName}&nbsp;&nbsp;</td>
							<td>${devgroup.companyName}&nbsp;&nbsp;</td>
							<td>${devgroup.watchword}&nbsp;&nbsp;</td>
							<td><c:if
									test="${sessionScope.employee_Session.roleId eq 5}">
									<a
										href="/zszd/sys/devgroup/modifydevgroup.html?id=${devgroup.id}">修改</a>
									<a
										href="/zszd/sys/devgroup/deletedevgroup.html?id=${devgroup.id}">删除</a>
								</c:if> <c:if test="${sessionScope.employee_Session.roleId ne 5}">
									<a>目前技术总监角色开放管理权限</a>
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