<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	
	<!--用百度的静态资源库的cdn安装bootstrap环境-->  
	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">  
        <!--font-awesome 核心我CSS 文件-->  
        <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">  
        <!-- 在bootstrap.min.js 之前引入 -->  
        <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>  
        <!-- Bootstrap 核心 JavaScript 文件 -->  
        <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>  
        <!--jquery.validate-->  
        <script type="text/javascript" src="js/jquery.validate.min.js" ></script>  
        <script type="text/javascript" src="js/login.js" charset="utf-8"></script>  
       
	<style type="text/css">  
            body{background: url(img/login.jpg) no-repeat;background-size:cover;font-size: 16px;} 
            .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}  
            #login_form{display: block;}  
            #register_form{display: none;}  
            .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}  
            input[type="text"],input[type="password"]{padding-left:26px;}  
            .checkbox{padding-left:21px;}  
    </style>  
        
  </head>
  
  <body>
   <div class="container">  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form" method ="post">  
                <h3 class="form-title">Login to your account</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="Username" name="user.username" autofocus="autofocus" maxlength="20"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Password" name="user.password" maxlength="8"/>  
                    </div>  
                    <div class="form-group">  
                        <label class="checkbox">  
                            <input type="checkbox" name="remember" value="1"/> Remember me  
                        </label>  
                        <hr />  
                        <a href="javascript:;" id="register_btn" class="">Create an account</a>  
                    </div>  
                    <div class="form-group">  
                        <input type="submit" id ="login_btn" class="btn btn-success pull-right" value="Login "/>     
                    </div>  
                </div>  
            </form>  
        </div>  
  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form" action="user_login">  
                <h3 class="form-title">Login to your account</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg"></i>  
                        <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-lock fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-check fa-lg"></i>  
                            <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>  
                    </div>  
                    <div class="form-group">  
                            <i class="fa fa-envelope fa-lg"></i>  
                            <input class="form-control eamil" type="text" placeholder="Email" name="email"/>  
                    </div>  
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>  
                        <input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back"/>  
                    </div>  
                </div>  
            </form>  
        </div>  
        </div>  
    <script type="text/javascript" src="js/main.js" ></script>  
  </body>
</html>
