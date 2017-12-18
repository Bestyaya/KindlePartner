<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.gov.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="../js/jquery-easyui-1.5.1/themes/default/easyui.css"
			rel="stylesheet" />
		<link href="../js/jquery-easyui-1.5.1/themes/icon.css" rel="stylesheet" />
		<script src="js/jquery-easyui-1.5.1/jquery.min.js"
			type="text/javascript"></script>
		<script src="../js/jquery-easyui-1.5.1/jquery.easyui.min.js"
			type="text/javascript"></script>
		<script src="../js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"
			type="text/javascript" charset="utf-8"></script>
		<link href="../js/jquery-easyui-1.5.1/themes/color.css" rel="stylesheet" />
		<!--用百度的静态资源库的cdn安装bootstrap环境-->
		<link
			href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
			rel="stylesheet">
		<!--font-awesome 核心我CSS 文件-->
		<link
			href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css"
			rel="stylesheet">
		<!-- 在bootstrap.min.js 之前引入 -->
		<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
		<!-- Bootstrap 核心 JavaScript 文件 -->
		<script
			src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<!--jquery.validate-->
		<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		<script type="text/javascript" src="../js/login.js" charset="utf-8"></script>

		<script type="text/javascript">
	function doLogin() {
		if ($('#name').val() == "") {
			$.messager.alert("提示信息", "请输入账号信息。", "info");
		} else if ($('#password').val() == "") {
			$.messager.alert("提示信息", "请输入密码信息。", "info");
		}
		$('#form').form('submit', {
			url : 'admin_Login',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(result) {
				if (result == null)
					return;
				result = $.parseJSON(result); //转换为json对象
				//result = $.parseJSON(result.json);   //取出json数据来再转换为json对象
				var msg = result.message;
				if (result.success) {
					$.messager.alert("信息提示", msg, "info", function() {
						window.location.href = 'main.jsp';
					})
				} else {
					$.messager.alert("错误", "操作失败！" + msg, "error");
				}
			}
		});
	}
</script>

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
 	User user = (User) session.getAttribute("user");
 	if (user == null)
 		out.print("登录/注册");
 	else
 		out.print(user.getUsername());
 %> </a>
					</li>
					<li>
						<a href="about.jsp">关于</a>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		</nav>

		<div class="container" id="login-area">
			<div class="col-md-5 col-md-offset-1" id="login-form">
				<form method="post" name="form">
					<h2>
						Sign In Your Account
					</h2>
					<fieldset>
						<div class="form-group">
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><span
									class="fa fa-user fa-fw"></span> </span>
								<label for="username" class="sr-only">
									Author ID
								</label>
								<input id = "name" type="text" placeholder="Author ID" class="form-control"
									name="admin.name" id="username" value="">
							</div>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"><span
									class="fa fa-key fa-fw"></span> </span>
								<label for="password" class="sr-only">
									Password
								</label>
								<input id = "password" type="password" placeholder="Password"
									class="form-control" name="admin.password" id="password">
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block btn-lg"
								onclick="doLogin()">
								Sign In
							</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</body>
</html>
