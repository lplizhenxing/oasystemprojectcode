<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="view">
		<table>
			<c:choose>
				<c:when test="${requestScope.message eq '文件上传成功'}">
					<h1 style="color:red">${requestScope.message}</h1>
					<a href="${pageContext.request.contextPath}/sys/resource/view.html?type=0">查看上传的图片</a>
					<br />
					<br />
					<a href="${pageContext.request.contextPath}/sys/resource/view.html?type=1">查看上传的视频</a>
					<br />
					<br />
					<a href="${pageContext.request.contextPath}/sys/resource/view.html?type=2">查看上传的文件</a>
					<br />
					<br />
				</c:when>
				<c:otherwise>
					<h1 style="color:red">${requestScope.message}</h1>
					<a href="${pageContext.request.contextPath}/sys/resource/upload.html">文件上传失败，请重新上传</a>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

