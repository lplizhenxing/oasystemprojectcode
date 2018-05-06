<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
				    <th>序号&nbsp;&nbsp;</th>
					<th>登录名称&nbsp;&nbsp;</th>
					<th>注册时间&nbsp;&nbsp;</th>
					<th>最后登录时间&nbsp;&nbsp;</th>
					<th>登录次数&nbsp;&nbsp;</th>
					<th>最后登录IP&nbsp;&nbsp;</th>
					<th>是否在线&nbsp;&nbsp;</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="sysuser" varStatus="num">
					<tr>
					    <td>${num.count}&nbsp;&nbsp;</td>
						<td>${sysuser.name}&nbsp;&nbsp;</td>
						<td>${sysuser.registerDate}&nbsp;&nbsp;</td>
						<td>${sysuser.lastloginDate}&nbsp;&nbsp;</td>
						<td>${sysuser.logincount}&nbsp;&nbsp;</td>
						<td>${sysuser.loginIPaddress}&nbsp;&nbsp;</td>
						<td><a>暂时不开放管理权限</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

