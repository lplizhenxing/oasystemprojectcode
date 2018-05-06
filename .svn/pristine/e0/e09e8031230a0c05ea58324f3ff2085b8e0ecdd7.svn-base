<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>角色管理页面</span></a>
		</div>
		<br/>
		<div class="content">
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>序号&nbsp;&nbsp;</th>
						<th>角色名称&nbsp;&nbsp;</th>
						<th>角色职责&nbsp;&nbsp;</th>
						<th>操作权限&nbsp;&nbsp;</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="role" varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${role.roleName}&nbsp;&nbsp;</td>
							<td>${role.responsibility}&nbsp;&nbsp;</td>
							<td><a>暂不开放</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>