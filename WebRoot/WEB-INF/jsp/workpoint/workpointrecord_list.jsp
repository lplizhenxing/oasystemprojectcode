<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<c:if test="${sessionScope.roleId eq 1}">
		<h3>
			员工的工时记录 <a href="jsp/workpoint/workpointrecord_add.jsp"
				style="color:red">添加工分记录</a>
		</h3>
	</c:if>
	<c:if test="${sessionScope.roleId eq 6}">
		<h3>员工的工时记录</h3>
	</c:if>
	<hr />

	<%
		String keywords = (String) request.getAttribute("keywords");
	%>
	<form action="workpoint?opr=search" method="post">
		名字：<input type="text" name="keywords" value="<%=keywords%>" /> <input
			type="submit" value="查找" />
	</form>

	<div id="workpointpage">

		<c:if test="${requestScope.p != null}">
			<span>[${requestScope.p.currentPageNum} /
				${requestScope.p.totalPageNum}]</span>
			<span>总记录数：${requestScope.p.totalCount }</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="workpoint?opr=search&currPageNum=1&keywords=<%=keywords%>">首页</a>
			<c:if test="${requestScope.p.currentPageNum > 1}">
				<a
					href="workpoint?opr=search&currPageNum=${requestScope.p.currentPageNum-1}&keywords=<%=keywords%>">上一页</a>
			</c:if>
			<c:if test="${requestScope.p.currentPageNum <= 1}">
				<a>上一页</a>
			</c:if>
			<c:if
				test="${requestScope.p.currentPageNum <= requestScope.p.totalPageNum}">
				<a
					href="workpoint?opr=search&currPageNum=${requestScope.p.currentPageNum+1}&keywords=<%=keywords%>">下一页</a>
			</c:if>
			<c:if
				test="${requestScope.p.currentPageNum > requestScope.p.totalPageNum}">
				<a>下一页</a>
			</c:if>
			<a
				href="workpoint?opr=search&currPageNum=${requestScope.p.totalPageNum}&keywords=<%=keywords%>">末页</a>
		</c:if>
	</div>
	<table>
		<c:if test="${requestScope.list!=null}">
			<tr>
				<th>员工名称&nbsp;&nbsp;</th>
				<th>工分变化&nbsp;&nbsp;</th>
				<th>工分原因&nbsp;&nbsp;</th>
				<th>工分日期&nbsp;&nbsp;</th>
				<th>操作权限&nbsp;&nbsp;</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="workpointlist">
				<tr>
					<td colspan="5"><hr /></td>
				<tr>
				<tr>
					<td style="width:50px;">${workpointlist.employeeId}&nbsp;&nbsp;</td>
					<td style="width:50px;">${workpointlist.workpoint}&nbsp;&nbsp;</td>
					<td style="width:400px;">${workpointlist.remarks}&nbsp;&nbsp;</td>
					<td style="width:250px;">${workpointlist.operatedate}&nbsp;&nbsp;</td>
					<td><c:if test="${sessionScope.roleId eq 4}">
							<a href='#' style="color:red">修改</a>
							<a href='#' style="color:red">删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>



</div>
</section>
<%@ include file="../common/footer.jsp"%>

<script>
	function changeSize(keywords) {
		if (keywords == undefined) {
			keywords = "";
		}
		var size = $("#topic_size").val();
		/* var op = document.getElementsByTagName("option");

		for ( var i = 0; i < op.length; i++) {
			if (op[i].value == size) {
				op[i].selected('selected');
				break;
			}
		} */

		window.location.href = "workpoint?opr=search&keywords=" + keywords
				+ "&pageSize=" + size;
	}

	function changeNum(max, size, keywords) {
		if (keywords == undefined) {
			keywords = "";
		}
		var num = $("#topic_num").val();
		if (num <= max) {
			window.location.href = "workpoint?opr=search&currPageNum=" + num
					+ "&keywords=" + keywords + "&pageSize=" + size;
		} else {
			alert("当前页不能大于最大页数");
		}
	}
</script>

