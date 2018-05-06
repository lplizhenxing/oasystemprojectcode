<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<a href="${pageContext.request.contextPath}/sys/bugs/addBugs.html">提个bug?</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>提出者</th>
					<th>标题</th>
					<th>内容</th>
					<th>项目编码</th>
					<th>提交日期</th>
					<th>解决日期</th>
					<th>解决者</th>
					<th>状态</th>
					<th>操作权限</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="bug">
					<tr>
						<td>${bug.userName}</td>
						<td style="width:100px;">${bug.title}</td>
						<td style="width:100px;">${bug.content}</td>
						<td>${bug.projectId}</td>
						<td>${bug.submitTime}</td>
						<td>${bug.resolveTime}</td>
						<td>${bug.resolveDevName}</td>
						<td>${bug.state}</td>
						<td><c:if
								test="${bug.userName eq sessionScope.employee_Session.name and bug.state eq '待审核'}">
								<a href='${pageContext.request.contextPath}/sys/bugs/oprBugs.html?opr=modify&id=${bug.id}'>修改</a>
							</c:if> <c:if
								test="${sessionScope.employee_Session.roleId eq 5 and bug.state eq '待审核'}">
								<a href='${pageContext.request.contextPath}/sys/bugs/oprBugs.html?opr=check&id=${bug.id}'>审核</a>
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