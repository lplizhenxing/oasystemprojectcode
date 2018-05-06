<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<br />
	<h1>请上传您的头像</h1>
	<br />
	<form action="photo?opr=upload&loginname=<%=name%>"
		enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="user" value=<%=name%> /></td>
			</tr>
			<tr>
				<td style="width:1000px;">选择文件：<input type="file" name="photo" />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

