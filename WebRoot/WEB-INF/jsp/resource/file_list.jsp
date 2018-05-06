<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>文件名称&nbsp;&nbsp;</th>
					<th>文件路径&nbsp;&nbsp;</th>
					<th>文件创建时间&nbsp;&nbsp;</th>
					<th>文件创建者&nbsp;&nbsp;</th>
					<c:if test="${sessionScope.employee_Session.roleId != 6}">
						<th>文件类型&nbsp;&nbsp;</th>
						<th>文件状态&nbsp;&nbsp;</th>
						<th>操作权限</th>
					</c:if>
				</tr>
				<c:forEach items="${requestScope.list}" var="file">
					<tr>
						<td>${file.name}&nbsp;&nbsp;</td>
						<td><a href="${file.path}" target="_blank">${file.name}</a>&nbsp;&nbsp;
						</td>
						<td>${file.createTime}&nbsp;&nbsp;</td>
						<td>${file.createBy}&nbsp;&nbsp;</td>
						<c:if test="${sessionScope.employee_Session.roleId != 6}">
							<td>${file.showType}&nbsp;&nbsp;</td>
							<td>${file.stateName}&nbsp;&nbsp;</td>
							<c:if test="${file.stateName eq '待审核'}">
								<td><a
									href="${pageContext.request.contextPath}/sys/resource/review.html?type=2&id=${file.id}">审核</a>
								</td>
							</c:if>
						</c:if>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

