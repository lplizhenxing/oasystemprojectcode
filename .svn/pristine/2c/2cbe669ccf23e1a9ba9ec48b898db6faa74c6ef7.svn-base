<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<c:if test="${requestScope.list!=null}">
			<table>
				<tr>
				    <th>序号&nbsp;&nbsp;</th>
					<th>员工名称&nbsp;&nbsp;</th>
					<th>工分日期&nbsp;&nbsp;</th>
					<th>工分值&nbsp;&nbsp;</th>
					<th>工分原因&nbsp;&nbsp;</th>
				</tr>
				<c:forEach items="${requestScope.list}" var="workpointlist" varStatus="num">
					<tr>
					    <td>${num.count}&nbsp;&nbsp;</td>
						<td>${requestScope.employeeName}&nbsp;&nbsp;</td>
						<td>${workpointlist.operatedate}&nbsp;&nbsp;</td>
						<td>${workpointlist.workpoint}&nbsp;&nbsp;</td>
						<td>${workpointlist.remarks}&nbsp;&nbsp;</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>