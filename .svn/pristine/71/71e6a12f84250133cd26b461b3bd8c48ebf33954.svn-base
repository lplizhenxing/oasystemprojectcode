<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form
			action="${pageContext.request.contextPath}/sys/schedule/toaddSchedule.html"
			method="post">
			<table>
				<tr>
					<td>待办事项内容</td>
					<td><textarea rows="20" cols="40" id="content" name="content"></textarea>
					</td>

				</tr>
				<c:if test="${sessionScope.employee_Session.roleId != 6}">
					<tr>
						<td>分配给谁完成</td>
						<td><input type="text" id="finishName" name="finishName" />
						</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="2"><input type="submit" value="提交">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var content = $("#content").val();
			if (content.trim() == "") {
				alert("待办事项内容不能为空！");
				return false;
			}
			return true;
		});
	});
</script>

