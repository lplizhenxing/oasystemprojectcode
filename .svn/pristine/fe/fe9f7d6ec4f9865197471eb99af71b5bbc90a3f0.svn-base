<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
	    <c:if test="${sessionScope.employee_Session.roleId ne 1}">
		    <a href="/zszd/sys/complaint/addComplaint.html">我要投诉！</a>
		</c:if>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>序号&nbsp;&nbsp;</th>
					<th>投诉内容&nbsp;&nbsp;</th>
					<c:if test="${sessionScope.employee_Session.roleId eq 1}">
						<th>投诉人&nbsp;&nbsp;</th>
					</c:if>
					<th>投诉时间&nbsp;&nbsp;</th>
					<th>反馈内容&nbsp;&nbsp;</th>
					<th>反馈人&nbsp;&nbsp;</th>
					<th>反馈时间&nbsp;&nbsp;</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="complaint"
					varStatus="num">
					<tr>
						<td>${num.count}&nbsp;&nbsp;</td>
						<td>${complaint.content}&nbsp;&nbsp;</td>
						<c:if test="${sessionScope.employee_Session.roleId eq 1}">
							<td>${complaint.userName}&nbsp;&nbsp;</td>
						</c:if>
						<td>${complaint.creationDate}&nbsp;&nbsp;</td>
						<td>${complaint.feedback}&nbsp;&nbsp;</td>
						<td>${complaint.feedbackMan}&nbsp;&nbsp;</td>
						<td>${complaint.feedbackTime}&nbsp;&nbsp;</td>
						<td><c:if test="${sessionScope.employee_Session.roleId eq 1}">
								<a
									href="/zszd/sys/complaint/feedbackcomplaint.html?id=${complaint.id}">我要反馈！</a>
							</c:if>
							<c:if test="${sessionScope.employee_Session.roleId ne 1}"> 
							    <a>暂时不开放管理权限</a>
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
