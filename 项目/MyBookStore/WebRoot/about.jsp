<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "cn.gov.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'about.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<!-- Bootstrap core CSS -->

		<!-- starter-template.js -->
		<link href="js/starter-template.js" type="text/css" rel="stylesheet">

		<link
			href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
			rel="stylesheet">

	</head>

	<body>

		<!-- 导航栏  -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">我的电子书店</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="index.jsp">主页</a>
					</li>
					<li>
						<a href="login.jsp"> <%
						User user = (User)session.getAttribute("user");
						if(user == null) out.print("登录/注册");
						else out.print(user.getUsername());
						 %> </a>
					</li>
					<li>
						<a href="about.jsp">关于</a>
					</li>
				</ul>
			</div>
		</div>
		</nav>

		<div class="container">

			<!-- 内容  -->
			<div class="starter-template">
				<h1>项目名：我的电子书店</h1>
				<h1>组长：董成荣</h1>
				<h1>架构：杨聪毅</h1>
				<h1>文档：曹光强</h1>
				<h1>美工：王海燕</h1>
				<h1>编码：王昺垚</h1>
				<h1>编码：刘玉安</h1>
			</div>

		</div>
		<!-- /.container -->
	</body>
</html>
