<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="modify">
		<form
			action="${pageContext.request.contextPath}/sys/user/tomodifypassword.html"
			method="post">
			<table>
				<tr>
					<td><span>请输入旧密码：</span></td>
					<td><input type="password" name="oldPassword"></td>
				</tr>
				<tr>
					<td><span>请输入新密码：</span></td>
					<td><input type="password" name="newPassword"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="提交修改 "></td>
				</tr>
				<tr>
					<td colspan="2"><h1 style="color:red;">${error}</h1></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

