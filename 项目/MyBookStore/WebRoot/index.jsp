<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import = "cn.gov.entity.User" %>
<html>
	<head>
		<title>主页</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/style.css" type="text/css" rel="stylesheet"
			rev="stylesheet" />
		<!-- starter-template.js -->
		<link href="js/starter-template.js" type="text/css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
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
						<a href="login.jsp">
						<%
						User user = (User)session.getAttribute("user");
						if(user == null) out.print("登录/注册");
						else out.print(user.getUsername());
						 %>
						</a>
					</li>
					<li>
						<a href="#about">关于</a>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		</nav>


		<div class="container">
			<div class="starter-template">
				<h1>
					欢迎来到主界面
				</h1>
			</div>
		</div>
	</body>
</html>
