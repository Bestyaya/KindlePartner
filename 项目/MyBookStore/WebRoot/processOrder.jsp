<%@ page contentType="text/html;charset=gbk" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单处理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/main.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
  <jsp:include page="navbar.jsp"></jsp:include>
  		<div class="container">

		<div class="starter-template">
			<form action = "user_bug">
			您的VIP等级为${user.vip} <br>
			优惠后您需要支付${totalMoney * (10 - user.vip) * 0.1}元
			<input type="submit" value="结账"/>
			<h1>可以使用支付宝</h1>
			<img src="img/pay.jpg" /> 
			</form>
		</div>

	</div>
	<!-- /.container -->
  </body>
</html>
