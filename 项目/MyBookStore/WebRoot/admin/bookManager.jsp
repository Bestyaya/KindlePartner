<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<title>后台</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/main.css" type="text/css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<jsp:include page="../base/stylebase.jsp" />
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
	
</script>
</head>

<body>
	<jsp:include page="../navbar.jsp"></jsp:include>
	<div class="container">

		<div class="start-template">
			<ul class="nav nav-tabs">
				<li class = "active">书籍管理</li>
				<li ><a href = "admin_userManager">用户管理</a></li>
				<li><a href="admin_logout">退出</a>
				</li>
			</ul>
			  <table width="605" border="2">
                <tr>
                  <td><div align="center">书名</div></td>
                  <td><div align="center">操作</div></td>
                   <td><div align="center">操作</div></td>
                </tr>
                <c:set var="totalMoney" value="0" scope="session"></c:set>                 
                <c:choose>                
                <c:when test="${empty books}">
                  ${"没有商品"}
                </c:when>
                <c:otherwise>
                
                <c:forEach items="${books}"  var="book" varStatus="count">
                 <tr>
                  <td><div align="center">${book.title}</div></td>
                  <td><div align="center"><a href = "admin_deleteBook?delete_id =${book.id} ">删除</a></div></td>
                 <td><div align="center">添加</div></td>
                </tr>              
                </c:forEach>
                </c:otherwise>
                </c:choose>
              </table>
		</div>
</body>
</html>
