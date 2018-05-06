<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>功能管理页面</span> </a>
		</div>
		<br />
		<div class="search">
			<form method="post"
				action="${pageContext.request.contextPath }/sys/functionRole/queryAllFunctionInfoBy.html">
				<input name="method" value="query" class="input-text" type="hidden">
				<span>功能名称：</span> <input name="queryFunctionName"
					class="input-text" type="text" value="${queryFunctionName}">
				<span>功能路径：</span> 
					<input name="queryFunctionPath"
					class="input-text" type="text" value="${queryFunctionPath}">
				<input type="hidden" name="pageIndex" value="1" /> <input
					value="查 询" type="submit" id="searchbutton">
			</form>
		</div>
		<div class="content">
			<a href="/zszd/sys/functionRole/addfunction.html">新增功能</a>
			<table>
				<c:if test="${requestScope.list!=null}">
					<tr>
						<th>功能序号&nbsp;&nbsp;</th>
						<th>功能名称&nbsp;&nbsp;</th>
						<th>功能配置路径&nbsp;&nbsp;</th>
						<th>操作权限</th>
					</tr>
					<c:forEach items="${requestScope.list}" var="functions"
						varStatus="num">
						<tr>
							<td>${num.count}&nbsp;&nbsp;</td>
							<td>${functions.functionName}&nbsp;&nbsp;</td>
							<td>${functions.functionPath}&nbsp;&nbsp;</td>
							<td><a
								href="/zszd/sys/functionRole/modifyfunction.html?id=${functions.id}">修改</a>
								<a
								href="/zszd/sys/functionRole/deletefunction.html?id=${functions.id}">删除</a>
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