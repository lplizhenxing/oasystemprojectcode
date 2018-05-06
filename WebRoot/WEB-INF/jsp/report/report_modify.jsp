<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/report/tomodifyReport.html"
			method="post">
			<table>
				<tr>
					<td>修改报告类型： <select name="reporttype">
							<c:if test="${requestScope.reportTypelist!=null }">
								<c:forEach items="${requestScope.reportTypelist}"
									var="reportType">
									<option id="type" value="${reportType.typename}">${reportType.typename}</option>
								</c:forEach>
							</c:if>
					</select>
					<input type="hidden" value=${report.id }
						name="reportIdchange"></td>
				</tr>
				<br />
				<tr>
					<td>修改A:问题和风险： <br /> <textarea id="answer" name="question"
							rows="7" cols="50">${report.question }</textarea> <br /></td>
				</tr>
				<tr>
					<td>修改B:完成的工作： <br /> <textarea id="answer2"
							name="finishwork" rows="7" cols="50">${report.finishwork}</textarea>
						<br /></td>
				</tr>
				<tr>
					<td>修改C:明日计划： <br /> <textarea id="answer3" name="plan"
							rows="7" cols="50">${report.plan}</textarea> <br /></td>
				</tr>
				<tr>
					<td>修改D:备注： <br /> <textarea id="answer4" name="remark"
							rows="7" cols="50">${report.remark}</textarea> <br /></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交修改 "></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<section id="section">
	<%@ include file="../common/footer.jsp"%>