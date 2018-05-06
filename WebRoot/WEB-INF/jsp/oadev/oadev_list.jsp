<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<a>OA系统研发人员联系信息</a>
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>花名&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>QQ&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>email&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>职责&nbsp;&nbsp;&nbsp;&nbsp;</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="oadev">
					<tr>
						<td>${oadev.huaName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>${oadev.qq}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>${oadev.email}&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td>${oadev.responsibility}&nbsp;&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>