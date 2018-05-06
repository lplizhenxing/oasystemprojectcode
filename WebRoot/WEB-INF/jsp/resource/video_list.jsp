<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="view">
	<div id="right">
		<table>
			<c:if test="${requestScope.list!=null}">
				<tr>
					<th>视频名称&nbsp;&nbsp;</th>
					<th>视频路径&nbsp;&nbsp;</th>
					<th>视频创建时间&nbsp;&nbsp;</th>
					<th>视频创建者&nbsp;&nbsp;</th>
					<c:if test="${sessionScope.employee_Session.roleId != 6}">
						<th>视频类型&nbsp;&nbsp;</th>
						<th>视频状态&nbsp;&nbsp;</th>
						<th>操作权限&nbsp;&nbsp;</th>
					</c:if>
				</tr>
				<c:forEach items="${requestScope.list}" var="video">
					<tr>
						<td>${video.name}&nbsp;&nbsp;</td>
						<td><video controls preload="none" width="240" height="200">
								<source src="${video.path}" type='video/mp4' />
							</video>&nbsp;&nbsp;</td>
						<td>${video.createTime}&nbsp;&nbsp;</td>
						<td>${video.createBy}&nbsp;&nbsp;</td>
						<c:if test="${sessionScope.employee_Session.roleId != 6}">
							<td>${video.showType}&nbsp;&nbsp;</td>
							<td>${video.stateName}&nbsp;&nbsp;</td>
							<c:if test="${video.stateName eq '待审核'}">
								<td><a
									href="${pageContext.request.contextPath}/sys/resource/review.html?type=1&id=${video.id}">审核</a>
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

