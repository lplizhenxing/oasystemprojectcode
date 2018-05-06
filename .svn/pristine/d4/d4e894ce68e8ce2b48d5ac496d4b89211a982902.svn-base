<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<div class="location">
			<a><strong>你现在所在的位置是:</strong> <span>修改功能页面</span> </a>
		</div>
		<br />
		<div class="content">
			<form
				action="${pageContext.request.contextPath}/sys/functionRole/tomodifyfunction.html"
				method="post">
				<table>
					<tr>
						<td><input type="hidden" value="${requestScope.functions.id}"
							name="id"><a>修改功能</a>
						</td>
					</tr>
					<tr>
						<td>修改功能名称：<input type="text"
							value="${requestScope.functions.functionName}"
							name="functionName"></td>
					</tr>
					<tr>
						<td>修改功能路径：<input type="text"
							value="${requestScope.functions.functionPath}"
							name="functionPath"></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交修改 ">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>


