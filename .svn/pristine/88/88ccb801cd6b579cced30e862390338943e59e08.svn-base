<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form
			action="${pageContext.request.contextPath}/sys/report/toaddReport.html"
			method="post">
			<table>
				<tr>
					<td>报告类型： <select name="reporttype">
							<c:if test="${requestScope.reportTypelist!=null }">
								<c:forEach items="${requestScope.reportTypelist}"
									var="reportType">
									<option id="type" value="${reportType.typename}">${reportType.typename}</option>
								</c:forEach>
							</c:if>
					</select></td>
				</tr>
				<tr>
					<td>
						<p>A:问题和风险</p> <textarea id="answer" name="question" rows="7"
							cols="50">1.</textarea>
						<p>B:完成的工作</p> <textarea id="answer2" name="finishwork" rows="7"
							cols="50">2.</textarea>
						<p>C:明日计划</p> <textarea id="answer3" name="plan" rows="7"
							cols="50">3.</textarea>
						<p>D:备注</p> <textarea id="answer3" name="remark" rows="7"
							cols="50">4.</textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交工作日志">
					</td>
				<tr>
			</table>

		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var answer = $("#answer").val();
			var answer2 = $("#answer2").val();
			var answer3 = $("#answer3").val();
			if (answer.trim() == "1.") {
				alert("问题不能为空！");
				return false;
			}
			if (answer2.trim() == "1.") {
				alert("完成的工作不能为空！");
				return false;
			}
			if (answer3.trim() == "1.") {
				alert("明日计划不能为空！");
				return false;
			}
			return true;
		});
	});
</script>
