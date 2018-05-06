<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/bugs/oprBugs.html?opr=tocheck"
			method="post">
			<input type="hidden" value="${requestScope.bugs.id}" name="id"><br />
			<table>
				<tr>
					<td>修改bug标题：&nbsp;&nbsp;</td>
					<td><input id="bugsTitle" type="text" name="bugsTitle"
						value="${requestScope.bugs.title}" /></td>
				</tr>
				<tr>
					<td>修改bug内容：&nbsp;&nbsp;</td>
					<td><textarea id="bugsContent" name="bugsContent" rows="20"
							cols="70">${requestScope.bugs.content}</textarea></td>
				</tr>
				<tr>
					<td>分派人员：&nbsp;&nbsp;</td>
					<td><input id="resolveDevName" type="text"
						name="resolveDevName" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="提交">
					</td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
