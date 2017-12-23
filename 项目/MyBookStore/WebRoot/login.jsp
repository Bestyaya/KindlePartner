<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.gov.entity.User"%>
<%@ page import = "cn.gov.entity.Admin" %>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                        + request.getServerName() + ":"
                        + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>
<jsp:include page="base/stylebase.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" type="text/css" rel="stylesheet"
	rev="stylesheet" />
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
		function checkData(){
			if($('#loginid').val()==""){
				$.messager.alert("提示信息", "请输入账号信息。", "info");
			}else if($('#password').val()==""){
				$.messager.alert("提示信息", "请输入密码信息。", "info");
			}else{
				doLogin();
			}
		}
		
		//执行登录
		/**
		 * 返回的数据的格式为：{"json":{},"user":{}}
		 * @memberOf {TypeName} 
		 * @return {TypeName} 
		 */
		function doLogin(){
            $('#login_form').form('submit',{
                url: 'user_login',
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert("信息提示", msg, "info", function () {
                            window.location.href = 'book_getBooks';
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
		}
		function re(){
			if($('#loginid').val()==""){
				$.messager.alert("提示信息", "请输入账号信息。", "info");
			}else if($('#password').val()==""){
				$.messager.alert("提示信息", "请输入密码信息。", "info");
			}else{
				doRegister();
			}
		
		function doRegister(){
            $('#register_form').form('submit',{
                url: 'user_register',
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert("信息提示", msg, "info", function () {
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
		}
	</script>
<style type="text/css">
body {
	background: url(img/login.jpg) no-repeat;
	background-size: cover;
	font-size: 16px;
}

.form {
	background: rgba(255, 255, 255, 0.2);
	width: 400px;
	margin: 100px auto;
}

#login_form {
	display: block;
}

#register_form {
	display: none;
}

.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"],input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}
</style>

</head>

<body>
	<!-- 导航栏  -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">我的电子书店</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="start.jsp">主页</a>
				</li>
				<li><a href="login.jsp"> <%
 	Admin admin = (Admin)session.getAttribute("admin");
 	User user = (User) session.getAttribute("user");
 	if(admin != null)
 			response.sendRedirect("admin/bookManager.jsp");
 	if (user != null)
 			response.sendRedirect("user.jsp");
 	else
 			out.print("登录/注册");
 		
 %> </a>
				</li>
				<li><a href="about.jsp">关于</a>
				</li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

		<div class="container">
			<div class="form row">
				<form class="form-horizontal col-sm-offset-3 col-md-offset-3"
					id="login_form" method="post">
					<h3 class="form-title">Login to your account</h3>
					<div class="col-sm-9 col-md-9">
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <input
								class="form-control required" type="text" placeholder="Username"
								name="user.username" autofocus="autofocus" maxlength="20" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <input
								class="form-control required" type="password"
								placeholder="Password" name="user.password" maxlength="8" />
						</div>
						<div class="form-group">
							<label class="checkbox"> <input type="checkbox"
								name="remember" value="1" /> Remember me </label>
							<hr />
							<a href="javascript:;" id="register_btn" class="">Create an
								account</a>
						</div>
						<div class="form-group">
							<input type="submit" id="login_btn"
								class="btn btn-success pull-right" value="Login "  onclick() = "checkData()" />
						</div>
					</div>
				</form>
			</div>

			<div class="form row">
				<form class="form-horizontal col-sm-offset-3 col-md-offset-3"
					name="register_form" id="register_form" >
					<h3 class="form-title">Login to your account</h3>
					<div class="col-sm-9 col-md-9">
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <input
								class="form-control required" type="text" placeholder="Username"
								name="user.username" autofocus="autofocus" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <input
								class="form-control required" type="password"
								placeholder="Password" id="register_password"
								name="user.password" />
						</div>
						<div class="form-group">
							<i class="fa fa-check fa-lg"></i> <input
								class="form-control required" type="password"
								placeholder="Re-type Your Password" name="rpassword" />
						</div>
						<div class="form-group">
							<i class="fa fa-envelope fa-lg"></i> <input
								class="form-control eamil" type="text" placeholder="Email"
								name="user.email" />
						</div>
						<div class="form-group">
							<input type="button" id="reg_btn"
								class="btn btn-success pull-right"  onclick()="re()" value="Sign Up " /> <input
								type="button" class="btn btn-info pull-left" id="back_btn"
								value="Back" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="js/main.js"></script></body>
</html>
