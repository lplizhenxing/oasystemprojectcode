<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<div id="mess">${empty
			requestScope.message?"":"验证信息:"}${requestScope.message}</div>
		<form
			action="${pageContext.request.contextPath}/sys/user/toaddEmployee.html"
			method="post">
			<table>
				<tr>
					<td>新员工名称&nbsp;&nbsp;</td>
					<td><input type="text" name="username"
						id="username">&nbsp;<font color="red">*</font></td>
					<td></td>
				</tr>
				<tr>
					<td>新员工证件号码&nbsp;&nbsp;</td>
					<td><input type="text"
						name="validDocuments" id="validDocuments">&nbsp;<font
						color="red">*</font></td>
					<td></td>
				</tr>
				<tr>
					<td>新员工帐号(登录账号)&nbsp;&nbsp;</td>
					<td><input type="text" name="abbr"
						id="abbr" />&nbsp;<font color="red">*</font>
					</td>
					<td>
					<div id="usernameDiv" style="display: inline"></div></td>
				</tr>
				<tr>
					<td>新学员性别&nbsp;&nbsp;</td>
					<td><input id="man" type="radio" name="sex" value="man"
						checked><label for="man">男&nbsp;</label>&nbsp;&nbsp; <input
						id="woman" type="radio" name="sex" value="woman" /><label
						for="woman">女&nbsp;</label>
					</td>
					<td></td>
				</tr>
				<tr>
					<td>新员工密码(登录密码)&nbsp;&nbsp;</td>
					<td><input type="password" name="password"
						value='<%=request.getParameter("password") == null ? "" : request
					.getParameter("password")%>'>&nbsp;<font
						color="red">*</font></td>
					<td></td>
				</tr>
				<tr>
					<td>再次输入密码：&nbsp;&nbsp;</td>
					<td><input type="password" name="repassword"
						value='<%=request.getParameter("repassword") == null ? "" : request
					.getParameter("repassword")%>'>&nbsp;<font
						color="red">*</font></td>
					<td></td>
				</tr>
				<tr>
					<td>新员工所属公司&nbsp;&nbsp;</td>
					<td><select name="companyId" id="companyId">
							<c:if test="${companies != null }">
								<option value="0">--请选择--</option>
								<c:forEach var="company" items="${companies}">
									<option value="${company.id}">${company.name}</option>
								</c:forEach>
							</c:if>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<td>员工角色：</td>
					<td><select name="roleId" id="roleId">
							<c:if test="${roles != null }">
								<option value="0">--请选择--</option>
								<c:forEach var="role" items="${roles}">
									<option  <c:if test="${role.id == employee.roleId }">selected="selected"</c:if>
									value="${role.id}">${role.roleName}</option>
								</c:forEach>
							</c:if>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="提交" id="submit">
						<input type="reset" value="重置"><br />
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
	     $("#abbr").bind("blur",function(){
	          $.ajax({
	              url:"/zszd/sys/user/abbrExist.html",
	              data:{"abbr": $("#abbr").val()},
	              type:"GET",
	              dataType:"json",
	              success:function(data){
	                  if(data.abbr == "exist"){
	                     $("#usernameDiv").html("该账号已存在！");
	                  }else{
	                     $("#usernameDiv").html("该账号可以使用！");
	                  }
	              },
	              error:function(data){
	                   $("#usernameDiv").html("你访问的页面不存在！");
	              }
	          });
	     })
	     .bind("focus",function(){
	     
	     });
	});
</script>