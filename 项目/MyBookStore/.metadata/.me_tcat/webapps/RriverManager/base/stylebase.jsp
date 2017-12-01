<%--
  Created by IntelliJ IDEA.
  User: mac-likh
  Date: 2017/4/12
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="js/jquery-easyui-1.5.1/themes/default/easyui.css" rel="stylesheet"/>
    <link href="js/jquery-easyui-1.5.1/themes/icon.css" rel="stylesheet"/>
    <script src="js/jquery-easyui-1.5.1/jquery.min.js" type="text/javascript"></script>
    <script src="js/jquery-easyui-1.5.1/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
    <link href="js/jquery-easyui-1.5.1/themes/color.css" rel="stylesheet"/>
    <script type="text/javascript">
        /**
         如果这个标题的标签存在，则选择该标签
         否则添加一个标签到标签组
         */
        function openTab(title, url, icon) {
            if ($("#tabs").tabs('exists', title)) {
                var currTab =  self.parent.$('#tabs').tabs('getSelected'); //获得当前tab
                self.parent.$('#tabs').tabs('update', {
                    tab : currTab,
                    options : {
                        content : createTabContent(url)
                    }
                });
            } else {
                $("#tabs").tabs('add', {
                    title: title,
                    content: createTabContent(url),
                    closable: true,
                    iconCls: icon
                });
            }
        }

        /* 生成标签内容 */
        function createTabContent(url) {
            return '<iframe style="width:100%;height:100%;overflow:hidden;" frameborder="0" src="' + url + '"></iframe>';
        }

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

        /**
         * 在页面中任何嵌套层次的窗口中获取顶层窗口
         * @return 当前页面的顶层窗口对象
         */
        function getTopWinow() {
            var p = window;
            while (p != p.parent) {
                p = p.parent;
            }
            return p;
        }
    </script>
</head>
<body>
</body>
</html>
