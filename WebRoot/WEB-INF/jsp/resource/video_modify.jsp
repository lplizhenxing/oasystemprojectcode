<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/resource/toreview.html"
			method="post">
			<input type="hidden" value="${requestScope.resource.type}"
				name="type"> <input type="hidden"
				value="${requestScope.resource.id}" name="id">
			<table>
				<tr>
					<td>修改视频名称</td>
					<td><input type="text" value="${requestScope.resource.name}"
						name="name">
					</td>
				</tr>
				<tr>
					<td>修改视频状态：</td>
					<td><select name="state">
							<option value="0" selected>待审核</option>
							<option value="1">审核通过</option>
							<option value="2">驳回请求</option>
					</select></td>
				</tr>
				<tr>
					<td>填写视频类型：</td>
					<td><input type="text"
						value="${requestScope.resource.showType}" name="showType">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交 ">
					</td>
					<td><input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

