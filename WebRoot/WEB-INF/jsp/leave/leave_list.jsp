<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<a href="${pageContext.request.contextPath}/sys/leave/addLeave.html">请个假?</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>提出者&nbsp;&nbsp;</th>
					<th>请假理由&nbsp;&nbsp;</th>
					<th>请假时间&nbsp;&nbsp;</th>
					<th>审批人&nbsp;&nbsp;</th>
					<th>审批时间&nbsp;&nbsp;</th>
					<th>状态&nbsp;&nbsp;</th>
					<th>操作权限</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="leave">
					<tr>
						<td>${leave.userName}&nbsp;&nbsp;</td>
						<td>${leave.leaveReason}&nbsp;&nbsp;</td>
						<td>${leave.leaveTime}&nbsp;&nbsp;</td>
						<td>${leave.approvalName}&nbsp;&nbsp;</td>
						<td>${leave.approvalTime}&nbsp;&nbsp;</td>
						<td>${leave.state}&nbsp;&nbsp;</td>
						<td><c:if
								test="${sessionScope.employee_Session.roleId eq '2'}">
								<a href="${pageContext.request.contextPath}/sys/leave/oprLeave.html?opr=pass&leaveId=${leave.id}">审核通过</a>
								<a href="${pageContext.request.contextPath}/sys/leave/oprLeave.html?opr=reject&leaveId=${leave.id}">驳回请假</a>
							</c:if> <c:if test="${sessionScope.employee_Session.roleId eq '6' and leave.state eq '待审核'}">
								<a href="${pageContext.request.contextPath}/sys/leave/oprLeave.html?opr=cancel&leaveId=${leave.id}">取消请假</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>