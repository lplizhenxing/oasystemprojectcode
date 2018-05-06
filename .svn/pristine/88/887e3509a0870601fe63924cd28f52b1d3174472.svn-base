<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<a
			href="${pageContext.request.contextPath}/sys/schedule/addSchedule.html">新增待办事项</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>待办事项名称&nbsp;&nbsp;</th>
					<th>创建代办事项者&nbsp;&nbsp;</th>
					<th>创建时间&nbsp;&nbsp;</th>
					<th>完成代办事项者&nbsp;&nbsp;</th>
					<th>完成时间&nbsp;&nbsp;</th>
					<th>操作权限</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="schedule">
					<tr>
						<td>${schedule.content}&nbsp;&nbsp;</td>
						<td>${schedule.createName}&nbsp;&nbsp;</td>
						<td>${schedule.createDate}&nbsp;&nbsp;</td>
						<td>${schedule.finishName}&nbsp;&nbsp;</td>
						<td>${schedule.finishDate}&nbsp;&nbsp;</td>
						<td>
						    <c:if test="${sessionScope.employee_Session.roleId eq '2'}">
								<a href="${pageContext.request.contextPath}/sys/schedule/oprSchedule.html?opr=cancel&scheduleId=${schedule.id}">取消代办事项</a>
							</c:if> 
						   <c:if test="${sessionScope.employee_Session.roleId eq '6' and empty schedule.finishDate}">
								<a href="${pageContext.request.contextPath}/sys/schedule/oprSchedule.html?opr=finish&scheduleId=${schedule.id}">完成代办事项</a>
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