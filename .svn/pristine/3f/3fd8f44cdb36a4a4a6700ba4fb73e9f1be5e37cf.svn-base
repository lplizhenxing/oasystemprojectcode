<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>班级管理页面</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/classes/view.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>班级名称：</span> <input name="queryClassName"
					class="input-text" type="text" value="${queryClassName}">
				<span>班主任：</span> 
					<input name="queryClassLeader"
					class="input-text" type="text" value="${queryClassLeader}">
				<span>学术老师：</span> 
					<input name="queryClassTeacher"
					class="input-text" type="text" value="${queryClassTeacher}">
				<input type="hidden" name="pageIndex" value="1" /> <input
					value="查 询" type="submit" id="searchbutton">
			</form>
		</div>
		<div id="content">
			<a
				href="${pageContext.request.contextPath}/sys/classes/addClasses.html">添加班级</a>
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>序号&nbsp;&nbsp;</th>
						<th>班级名称&nbsp;&nbsp;</th>
						<th>班主任&nbsp;&nbsp;</th>
						<th>学术老师&nbsp;&nbsp;</th>
						<th>操作权限&nbsp;&nbsp;</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="classes"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${classes.className}&nbsp;&nbsp;</td>
							<td>${classes.classLeader}&nbsp;&nbsp;</td>
							<td>${classes.classTeacher}&nbsp;&nbsp;</td>
							<td><c:if
									test="${sessionScope.employee_Session.roleId == 1}">
									<a href="/zszd/sys/classes/modifyclasses.html?id=${classes.id}">修改</a>
									<a href="/zszd/sys/classes/deleteclasses.html?id=${classes.id}">删除</a>
								</c:if></td>
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

