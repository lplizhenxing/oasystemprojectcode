<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<a href="${pageContext.request.contextPath}/sys/requirements/addRequirements.html">提个需求?</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>提出者&nbsp;&nbsp;</th>
					<th>标题&nbsp;&nbsp;</th>
					<th>内容&nbsp;&nbsp;</th>
					<th>项目编码&nbsp;&nbsp;</th>
					<th>提交日期&nbsp;&nbsp;</th>
					<th>解决日期&nbsp;&nbsp;</th>
					<th>解决者&nbsp;&nbsp;</th>
					<th>状态&nbsp;&nbsp;</th>
					<th>操作权限</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="requirement">
					<tr>
						<td>${requirement.userName}&nbsp;&nbsp;</td>
						<td style="width:100px;">${requirement.title}&nbsp;&nbsp;</td>
						<td style="width:100px;">${requirement.content}&nbsp;&nbsp;</td>
						<td>${requirement.projectId}&nbsp;&nbsp;</td>
						<td>${requirement.submitTime}&nbsp;&nbsp;</td>
						<td>${requirement.resolveTime}&nbsp;&nbsp;</td>
						<td>${requirement.resolveDevName}&nbsp;&nbsp;</td>
						<td>${requirement.state}</td>
						<td><c:if
								test="${requirement.userName eq sessionScope.employee_Session.name and requirement.state eq '待审核'}">
								<a href='${pageContext.request.contextPath}/sys/requirements/oprRequirements.html?opr=modify&id=${requirement.id}'>修改</a>
							</c:if> <c:if
								test="${sessionScope.employee_Session.roleId eq 5 and requirement.state eq '待审核'}">
								<a href='${pageContext.request.contextPath}/sys/requirements/oprRequirements.html?opr=check&id=${requirement.id}'>审核</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

