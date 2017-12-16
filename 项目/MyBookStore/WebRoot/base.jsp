<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'base.jsp' starting page</title>
<link href="js/jquery-easyui-1.5.1/themes/default/easyui.css"
	rel="stylesheet" />
<link href="js/jquery-easyui-1.5.1/themes/icon.css" rel="stylesheet" />
<script src="js/jquery-easyui-1.5.1/jquery.min.js"
	type="text/javascript"></script>
<script src="js/jquery-easyui-1.5.1/jquery.easyui.min.js"
	type="text/javascript"></script>
<script src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"
	type="text/javascript" charset="utf-8"></script>
<link href="js/jquery-easyui-1.5.1/themes/color.css" rel="stylesheet" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
        /**ajax 全局配置**/
        $.ajaxSetup({
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (XMLHttpRequest.status == 403) {
                    $.messager.alert('提示','您没有权限访问此资源或进行此操作','warning');
                    return false;
                }
            },
            complete: function (XMLHttpRequest, textStatus) {
                var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus，
                if (sessionstatus == 'timeout') {
                    var top = getTopWinow(); //获取当前页面的顶层窗口对象
                    $.messager.alert('提示','登录超时, 请重新登录','warning',function () {
                        //如果超时就处理 ，指定要跳转的页面
                        top.location.href = "login.jsp?timeout=true"; //跳转到登陆页面
                    });
                }
            }
        });
    </script>

</head>

<body>
</body>
</html>
