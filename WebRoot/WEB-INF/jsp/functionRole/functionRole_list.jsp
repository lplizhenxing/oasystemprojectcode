<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>功能角色管理页面</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/functionRole/queryAllFunctionRoleInfoBy.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>用户角色：</span> <select name="queryUserRole">
					<c:if test="${roleList != null }">
						<option value="0">--请选择--</option>
						<c:forEach var="role" items="${roleList}">
							<option
								<c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
								value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</c:if>
				</select> &nbsp;&nbsp;&nbsp;&nbsp; <span>功能名称：</span> <input
					name="queryFunctionName" class="input-text" type="text"
					value="${queryFunctionName}"> &nbsp;&nbsp;&nbsp;&nbsp; <input
					type="hidden" name="pageIndex" value="1" /> <input value="查 询"
					type="submit" id="searchbutton">
			</form>
		</div>
		<div id="content">
			<a href="/zszd/sys/functionRole/addfunctionrole.html"
				style="color:red; font-size:26px">新增功能权限配置</a>
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>配置序号&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>角色名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>功能名称&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>操作权限&nbsp;&nbsp;&nbsp;&nbsp;</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="functionRole"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${functionRole.roleName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>${functionRole.functionName}&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><a
								href="/zszd/sys/functionRole/delfunctionrole.html?id=${functionRole.id}">删除配置</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

			<input type="hidden" id="totalPageCount" value="${totalPageCount}" />
			<c:import url="/sys/rollPage/rollPage.html">
				<c:param name="totalCount" value="${totalCount}" />
				<c:param name="currentPageNo" value="${currentPageNo}" />
				<c:param name="totalPageCount" value="${totalPageCount}" />
			</c:import>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>