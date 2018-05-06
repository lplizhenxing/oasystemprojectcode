<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<a href="${pageContext.request.contextPath}/sys/sign/sign.html"">每日签到</a>
		<a href="${pageContext.request.contextPath}/sys/sign/signOut.html">每日签退</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>员工名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>签到时间&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>签退时间&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>操作权限</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="sign">
					<tr>
						<td>${sign.userName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>${sign.signTime}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>${sign.signOutTime}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><a>暂未开发</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>