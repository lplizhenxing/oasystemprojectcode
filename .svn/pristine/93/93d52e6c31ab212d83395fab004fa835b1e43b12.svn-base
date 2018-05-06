<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>报告管理</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/report/reportviewBy.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>员工名称：</span> <input name="queryEmployeeName"
					class="input-text" type="text" value="${queryEmployeeName}">
				<span>日志类型：</span> <select name="queryReporttype">
					<c:if test="${typeList != null }">
						<option value="0">--请选择--</option>
						<c:forEach var="type" items="${typeList}">
							<option
								<c:if test="${type.id == queryReporttype }">selected="selected"</c:if>
								value="${type.id}">${type.typename}</option>
						</c:forEach>
					</c:if>
				</select>
				<span>提交日期：</span> 
				<input name="createDate"
					class="input-text" type="date" value="${createDate}">
				<input
					type="hidden" name="pageIndex" value="1" /> <input value="查 询"
					type="submit" id="searchbutton">
			</form>
		</div>
		<div id="content">
			<a
				href="${pageContext.request.contextPath}/sys/report/addReport.html">新增报告</a>
			<table>
				<c:if test="${requestScope.list!=null }">
					<tr>
						<th>员工名称&nbsp;&nbsp;</th>
						<th>日志类型&nbsp;&nbsp;</th>
						<th>问题和风险&nbsp;&nbsp;</th>
						<th>完成的工作&nbsp;&nbsp;</th>
						<th>明日计划&nbsp;&nbsp;</th>
						<th>备注&nbsp;&nbsp;</th>
						<th>提交日期&nbsp;&nbsp;</th>
						<th>操作权限</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="report">
						<tr>
							<td>${report.username}&nbsp;&nbsp;</td>
							<td>${report.typename}&nbsp;&nbsp;</td>
							<td>${report.question}&nbsp;&nbsp;</td>
							<td>${report.finishwork}&nbsp;&nbsp;</td>
							<td>${report.plan}&nbsp;&nbsp;</td>
							<td>${report.remark}&nbsp;&nbsp;</td>
							<td>${report.createDate}&nbsp;&nbsp;</td>
							<td><c:if
									test="${sessionScope.employee_Session.roleId eq 6}">
									<a
										href='${pageContext.request.contextPath}/sys/report/modifyReport.html?reportId=${report.id}'>修改
									</a>
								</c:if> <c:if test="${sessionScope.employee_Session.roleId ne 6}">
									<a>目前只对普通员工开放修改权限</a>
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