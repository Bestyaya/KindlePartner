<%@page import="cn.gov.entity.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

</style>
<!-- 引入百度地图 -->
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=bMVyXYsBpiHdIBpQ06Wb5Te50sGXaAQo">
</script>

<!--  先判断是否登录，未登录则提示去登录  -->
	<script type="text/javascript">
		
	<%User user = (User) session.getAttribute("user");
			if (user == null) {%>
		alert("检测到您还未登录，清先登录！");
		window.location.href = "login.jsp";
	<%}%>
		
	</script>

<meta name="viewport" content="width=device-width" />
<%@ include file="base/stylebase.jsp"%>
<style type="text/css">
div#menu li {
	padding-top: 10px;
}

.tree-title {
	font-size: 1.2em;
}

.tree-title a {
	text-decoration: none;
}

a:link {
	font-size: 14px;
	color: #000000;
	text-decoration: none;
}

a:visited {
	font-size: 14px;
	color: #000000;
	text-decoration: none;
}

a:hover {
	font-size: 14px;
	color: #999999;
	text-decoration: underline;
}
</style>
<script type="text/javascript">
		
		$(function () {
            openTab('河道管理', 'zhuang_add.action?router=addinfo', 'icon-man');
        });

        $(function () {
            $("#menu a").click(function () {
                var title = '河道管理';
                var url = $(this).attr("rel");
                var icon = $(this).attr("iconCls");
                if (url) {
                    openTab(title, url, icon);
                    return false;    //使超链接的单击事件失效
                }
            });
        });
        
        //确定退出
        function logout() {
            $.messager.confirm("退出", "确定退出吗？", function (r) {
                if (r) {
                    top.location = 'user_logout';
                }
            });
        }
        //修改密码
        function editPassWord() {
            $("#editPasswordDiv").css("display", "block");
            $("#editPasswordDiv").dialog("open").dialog('setTitle', '修改密码');
            $("#oldPwd").val("");
            $("#newPwd").val("");
            $("#againPwd").val("");
        }
        
        //修改密码
        function saveUser() {
            var oldPwd = $("#oldPwd").val();
            var newPwd = $("#newPwd").val();
            var againPwd = $("#againPwd").val();
            
            if(oldPwd==""){
            	$.messager.alert("提示", "请输入原密码信息。", "error");
                return;
            }else if(newPwd==""){
            	$.messager.alert("提示", "请输入新密码信息。", "error");
                return;
            }
            else if (newPwd != againPwd) {
                $.messager.alert("提示", "两次密码输入的不一致，请重新输入", "error");
                return;
            }
            var url = "user_changePassword?foo=" + Math.random();
         
            //还是使用frm.submit方法来处理
            $('#fm').form('submit',{
                //url: 'user_login',
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                	//alert(result);
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    //result = $.parseJSON(result.json);   //取出json数据来再转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert('信息提示', msg, 'info', function () {
                            $("#editPasswordDiv").dialog("close");
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
        }

    </script>
</head>
<body class="easyui-layout">
	<div region="north" split="true"
		style="background: url('images/top_bg.jpg') repeat-x ; height:60px; overflow: hidden">
		<h2 style="padding-left: 35px;line-height: 20px;color: white ">河
			道 管 理 系 统</h2>
	</div>

	<div region="west" split="true"
		style="width: 210px;padding-bottom: 50px" title="功能导航">
		<div id="menu">
			<ul class="easyui-tree">
				<li><span>导航列表</span>
					<ul>
						<li iconCls="icon-man"><a href="javascript:void(0);"
							iconCls="icon-man" rel="zhuang_add">添加</a></li>
						<li iconCls="icon-search"><a href="javascript:void(0);"
							iconCls="icon-search" rel="zhuang_add.action?router=searchAll">查询警告点</a>
						</li>
						<li iconCls="icon-search"><a href="javascript:void(0);"
							iconCls="icon-search" rel="warn_list">查询列表</a>
						</li>
						<li iconcls="icon-key"><a href="javascript:void(0);"
							iconcls="icon-key" onclick="editPassWord()">修改密码</a></li>
						<li iconcls="icon-cancel"><a href="javascript:void(0);"
							iconcls="icon-cancel" onclick="logout()">退出登录</a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div region="center">
		<div id="tabs" class="easyui-tabs" border="false" fit="true"></div>
	</div>
	<%--修改密码弹框--%>
	<div id="editPasswordDiv" class="easyui-dialog"
		style="width: 350px; height: 220px; padding: 20px 20px" closed="true"
		buttons="#editPasswordDiv-buttons">
		<form id="fm" method="post" novalidate>
			<table align="center">

				<tr>
					<td>原密码:</td>
					<td><input id="oldPwd" name="oldPwd" type="password"
						class="easyui-validatebox" required="true" />
					</td>
				</tr>
				<tr>
					<td>新密码:</td>
					<td><input id="newPwd" name="newPwd" type="password"
						class="easyui-validatebox" required="true" />
					</td>
				</tr>
				<tr>
					<td>重复一次:</td>
					<td><input id="againPwd" name="againPwd" type="password"
						class="easyui-validatebox" required="true" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="editPasswordDiv-buttons" style="text-align: center">
		<a href="javascript:void(0);" class="easyui-linkbutton c6"
			iconcls="icon-ok" onclick="saveUser()">确定</a> <a
			href="javascript:void(0);" class="easyui-linkbutton"
			iconcls="icon-cancel" onclick="$('#editPasswordDiv').dialog('close')">取消</a>
	</div>
	
	<%-- center主要内容展示区域开始 --%>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<div id="main-center" class="easyui-tabs" fit="true" border="false">
			<div title="河道管理" style="padding: 20px;" id="allmap">
				<script type="text/javascript">
					//调用百度地图API
					var map = new BMap.Map("allmap"); // 创建Map实例
					map.centerAndZoom(new BMap.Point(
					116.404, 39.915), 11); // 初始化地图,设置中心点坐标和地图级别
					map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
					map.setCurrentCity("北京"); // 设置地图显示的城市 此项是必须设置的
					map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
				</script>
			</div>
		</div>
	</div>
	<%-- center主要内容展示区域结束 --%>

</body>
</html>
