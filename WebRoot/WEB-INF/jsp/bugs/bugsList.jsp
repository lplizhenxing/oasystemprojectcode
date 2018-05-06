<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
    <form action="${pageContext.request.contextPath}/bugs/list" method="post">
        bugs提出者：<input type="text" name="userName" value=""/>
        <input type="submit" value="查询" /> 
    </form>
    
	<h1>查询bug列表</h1>
	<c:forEach var="bug" items="${queryBugsList}">
	    <div>
	        id: ${bug.id}   ----
	        用户名: ${bug.userName}   ----
	       标题: ${bug.title}   ----
	        项目编码: ${bug.projectId}   ----
	        提交时间: ${bug.submitTime}   ----
	    </div>
	</c:forEach>
</div>
</section>
<%@ include file="../common/footer.jsp"%>