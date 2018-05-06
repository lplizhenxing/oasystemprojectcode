<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form action="${pageContext.request.contextPath}/sys/bugs/toaddBugs.html" method="post">
			<table>
				<tr>
					<td style="width:80px">bug标题：&nbsp;&nbsp;</td>
					<td><input id="bugsTitle" type="text" name="bugsTitle" />
					</td>
				</tr>
				<tr>
					<td style="width:80px">bug内容：&nbsp;&nbsp;</td>
					<td><textarea id="bugsContent" name="bugsContent" rows="20"
							cols="70"></textarea>
					</td>
				</tr>
				<tr>
					<td style="width:80px"><input type="submit" value="提交">
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

<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var bugsTitle = $("#bugsTitle").val();
			if (bugsTitle.trim() == "") {
				alert("标题不能为空！");
				return false;
			}

			var bugsContent = $("#bugsContent").val();
			if (bugsContent.trim() == "") {
				alert("内容不能为空！");
				return false;
			}

			return true;
		});
	});
</script>
