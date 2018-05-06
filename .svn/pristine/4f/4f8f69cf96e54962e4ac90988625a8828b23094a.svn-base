<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>图片名称&nbsp;&nbsp;</th>
					<th>图片路径&nbsp;&nbsp;</th>
					<th>图片创建时间&nbsp;&nbsp;</th>
					<th>图片创建者&nbsp;&nbsp;</th>
					<c:if test="${sessionScope.employee_Session.roleId != 6}">
						<th>图片类型&nbsp;&nbsp;</th>
						<th>图片状态&nbsp;&nbsp;</th>
						<th>操作权限&nbsp;&nbsp;</th>
					</c:if>
				</tr>
				<c:forEach items="${requestScope.list}" var="photo">
					<tr>
						<td>${photo.name}&nbsp;&nbsp;</td>
						<td><img alt="图片文件不存在，请联系后台管理员" src="${photo.path}"
							width=80px height=80px>&nbsp;&nbsp;</td>
						<td>${photo.createTime}&nbsp;&nbsp;</td>
						<td>${photo.createBy}&nbsp;&nbsp;</td>
						<c:if test="${sessionScope.employee_Session.roleId != 6}">
							<td>${photo.showType}&nbsp;&nbsp;</td>
							<td>${photo.stateName}&nbsp;&nbsp;</td>
							<c:if test="${photo.stateName eq '待审核'}">
								<td><a
									href="${pageContext.request.contextPath}/sys/resource/review.html?type=0&id=${photo.id}">审核</a>
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

