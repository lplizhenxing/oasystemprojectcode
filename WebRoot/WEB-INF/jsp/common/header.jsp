<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<title>浙江宙斯之盾OA系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="statics/css/userindex.css">
<link rel="stylesheet" type="text/css" href="statics/css/view.css">
<link rel="stylesheet" type="text/css" href="statics/css/add.css">
<link rel="stylesheet" type="text/css" href="statics/css/modify.css">
<link rel="stylesheet" type="text/css" href="statics/css/details.css">
</head>
<body>
<header id="header">
	<p>
		尊敬的【${employee_Session.companyName}】
		【${employee_Session.departmentName}】
		<c:if test="${employee_Session.roleId == 6}">     
		        【${employee_Session.devgroupName}】
		</c:if>
        <br/>
		<c:if test="${employee_Session.roleId != 6}">
			【${employee_Session.roleName}】
		</c:if>
		
		<span>${employee_Session.name}</span>,第<span>${sysuser_Session.logincount}</span>次访问,
		<a href="logout.html" style="font-size:16px;">登出</a> <a
			href="/zszd/sys/main.html" style="font-size:16px;">返回首页</a>
		<a href="/zszd/sys/oadev/view.html" style="font-size:16px;">帮助</a>
	</p>
</header>
<section id="section">
<div id="left">
	<ol id="functions">
	</ol>
</div>
