<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<h1>
			注意：<br /> 1.上传类型有图片，视频，压缩文件等<br /> 2.大小请控制在100M以内<br />
			3.上传的资源需要审核通过后才能查看和下载 <br />
		</h1>
		<br /> <br />
		<h3>上传系统资源</h3>
		<form action="${pageContext.request.contextPath}/sys/resource/toupload.html" enctype="multipart/form-data"
			method="post">
			<table>
				<tr>
					<td>选择文件：</td>
					<td><input type="file" name="uploadfile"  id="uploadfile"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

