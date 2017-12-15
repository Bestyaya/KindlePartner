<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    <link href="js/jquery-easyui-1.5.1/themes/default/easyui.css" rel="stylesheet"/>
    <link href="js/jquery-easyui-1.5.1/themes/icon.css" rel="stylesheet"/>
    <script src="js/jquery-easyui-1.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="js/jquery-easyui-1.5.1/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
    <link href="js/jquery-easyui-1.5.1/themes/color.css" rel="stylesheet"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  </body>
</html>
