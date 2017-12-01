package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cn.gov.entity.User;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/base/stylebase.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<!-- 引入百度地图 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"http://api.map.baidu.com/api?v=2.0&ak=bMVyXYsBpiHdIBpQ06Wb5Te50sGXaAQo\">\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!--  先判断是否登录，未登录则提示去登录  -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
User user = (User) session.getAttribute("user");
			if (user == null) {
      out.write("\r\n");
      out.write("\t\talert(\"检测到您还未登录，清先登录！\");\r\n");
      out.write("\t\twindow.location.href = \"login.jsp\";\r\n");
      out.write("\t");
}
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link href=\"js/jquery-easyui-1.5.1/themes/default/easyui.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <link href=\"js/jquery-easyui-1.5.1/themes/icon.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <script src=\"js/jquery-easyui-1.5.1/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery-easyui-1.5.1/jquery.easyui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"js/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\r\n");
      out.write("    <link href=\"js/jquery-easyui-1.5.1/themes/color.css\" rel=\"stylesheet\"/>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        /**\r\n");
      out.write("         如果这个标题的标签存在，则选择该标签\r\n");
      out.write("         否则添加一个标签到标签组\r\n");
      out.write("         */\r\n");
      out.write("        function openTab(title, url, icon) {\r\n");
      out.write("            if ($(\"#tabs\").tabs('exists', title)) {\r\n");
      out.write("                var currTab =  self.parent.$('#tabs').tabs('getSelected'); //获得当前tab\r\n");
      out.write("                self.parent.$('#tabs').tabs('update', {\r\n");
      out.write("                    tab : currTab,\r\n");
      out.write("                    options : {\r\n");
      out.write("                        content : createTabContent(url)\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            } else {\r\n");
      out.write("                $(\"#tabs\").tabs('add', {\r\n");
      out.write("                    title: title,\r\n");
      out.write("                    content: createTabContent(url),\r\n");
      out.write("                    closable: true,\r\n");
      out.write("                    iconCls: icon\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /* 生成标签内容 */\r\n");
      out.write("        function createTabContent(url) {\r\n");
      out.write("            return '<iframe style=\"width:100%;height:100%;overflow:hidden;\" frameborder=\"0\" src=\"' + url + '\"></iframe>';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        /**ajax 全局配置**/\r\n");
      out.write("        $.ajaxSetup({\r\n");
      out.write("            error: function (XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("                if (XMLHttpRequest.status == 403) {\r\n");
      out.write("                    $.messager.alert('提示','您没有权限访问此资源或进行此操作','warning');\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("            },\r\n");
      out.write("            complete: function (XMLHttpRequest, textStatus) {\r\n");
      out.write("                var sessionstatus = XMLHttpRequest.getResponseHeader(\"sessionstatus\"); //通过XMLHttpRequest取得响应头,sessionstatus，\r\n");
      out.write("                if (sessionstatus == 'timeout') {\r\n");
      out.write("                    var top = getTopWinow(); //获取当前页面的顶层窗口对象\r\n");
      out.write("                    $.messager.alert('提示','登录超时, 请重新登录','warning',function () {\r\n");
      out.write("                        //如果超时就处理 ，指定要跳转的页面\r\n");
      out.write("                        top.location.href = \"login.jsp?timeout=true\"; //跳转到登陆页面\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        /**\r\n");
      out.write("         * 在页面中任何嵌套层次的窗口中获取顶层窗口\r\n");
      out.write("         * @return 当前页面的顶层窗口对象\r\n");
      out.write("         */\r\n");
      out.write("        function getTopWinow() {\r\n");
      out.write("            var p = window;\r\n");
      out.write("            while (p != p.parent) {\r\n");
      out.write("                p = p.parent;\r\n");
      out.write("            }\r\n");
      out.write("            return p;\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("div#menu li {\r\n");
      out.write("\tpadding-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-title {\r\n");
      out.write("\tfont-size: 1.2em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tree-title a {\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:visited {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: #000000;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: #999999;\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function () {\r\n");
      out.write("            openTab('河道管理', 'zhuang_add.action?router=addinfo', 'icon-man');\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $(\"#menu a\").click(function () {\r\n");
      out.write("                var title = '河道管理';\r\n");
      out.write("                var url = $(this).attr(\"rel\");\r\n");
      out.write("                var icon = $(this).attr(\"iconCls\");\r\n");
      out.write("                if (url) {\r\n");
      out.write("                    openTab(title, url, icon);\r\n");
      out.write("                    return false;    //使超链接的单击事件失效\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        //确定退出\r\n");
      out.write("        function logout() {\r\n");
      out.write("            $.messager.confirm(\"退出\", \"确定退出吗？\", function (r) {\r\n");
      out.write("                if (r) {\r\n");
      out.write("                    top.location = 'user_logout';\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("        //修改密码\r\n");
      out.write("        function editPassWord() {\r\n");
      out.write("            $(\"#editPasswordDiv\").css(\"display\", \"block\");\r\n");
      out.write("            $(\"#editPasswordDiv\").dialog(\"open\").dialog('setTitle', '修改密码');\r\n");
      out.write("            $(\"#oldPwd\").val(\"\");\r\n");
      out.write("            $(\"#newPwd\").val(\"\");\r\n");
      out.write("            $(\"#againPwd\").val(\"\");\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        //修改密码\r\n");
      out.write("        function saveUser() {\r\n");
      out.write("            var oldPwd = $(\"#oldPwd\").val();\r\n");
      out.write("            var newPwd = $(\"#newPwd\").val();\r\n");
      out.write("            var againPwd = $(\"#againPwd\").val();\r\n");
      out.write("            \r\n");
      out.write("            if(oldPwd==\"\"){\r\n");
      out.write("            \t$.messager.alert(\"提示\", \"请输入原密码信息。\", \"error\");\r\n");
      out.write("                return;\r\n");
      out.write("            }else if(newPwd==\"\"){\r\n");
      out.write("            \t$.messager.alert(\"提示\", \"请输入新密码信息。\", \"error\");\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("            else if (newPwd != againPwd) {\r\n");
      out.write("                $.messager.alert(\"提示\", \"两次密码输入的不一致，请重新输入\", \"error\");\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("            var url = \"user_changePassword?foo=\" + Math.random();\r\n");
      out.write("         \r\n");
      out.write("            //还是使用frm.submit方法来处理\r\n");
      out.write("            $('#fm').form('submit',{\r\n");
      out.write("                //url: 'user_login',\r\n");
      out.write("                url: url,\r\n");
      out.write("                onSubmit: function(){\r\n");
      out.write("                    return $(this).form('validate');\r\n");
      out.write("                },\r\n");
      out.write("                success: function(result){\r\n");
      out.write("                \t//alert(result);\r\n");
      out.write("                    if (result == null) return;\r\n");
      out.write("                    result = $.parseJSON(result);    //转换为json对象\r\n");
      out.write("                    //result = $.parseJSON(result.json);   //取出json数据来再转换为json对象\r\n");
      out.write("                    var msg = result.message;\r\n");
      out.write("                    if (result.success) {\r\n");
      out.write("                        $.messager.alert('信息提示', msg, 'info', function () {\r\n");
      out.write("                            $(\"#editPasswordDiv\").dialog(\"close\");\r\n");
      out.write("                        })\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $.messager.alert(\"错误\", \"操作失败！\" + msg, \"error\");\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div region=\"north\" split=\"true\"\r\n");
      out.write("\t\tstyle=\"background: url('images/top_bg.jpg') repeat-x ; height:60px; overflow: hidden\">\r\n");
      out.write("\t\t<h2 style=\"padding-left: 35px;line-height: 20px;color: white \">河\r\n");
      out.write("\t\t\t道 管 理 系 统</h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div region=\"west\" split=\"true\"\r\n");
      out.write("\t\tstyle=\"width: 210px;padding-bottom: 50px\" title=\"功能导航\">\r\n");
      out.write("\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t<ul class=\"easyui-tree\">\r\n");
      out.write("\t\t\t\t<li><span>导航列表</span>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li iconCls=\"icon-man\"><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\ticonCls=\"icon-man\" rel=\"zhuang_add\">添加</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li iconCls=\"icon-search\"><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\ticonCls=\"icon-search\" rel=\"zhuang_add.action?router=searchAll\">查询警告点</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li iconCls=\"icon-search\"><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\ticonCls=\"icon-search\" rel=\"warn_list\">查询列表</a>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li iconcls=\"icon-key\"><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\ticoncls=\"icon-key\" onclick=\"editPassWord()\">修改密码</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li iconcls=\"icon-cancel\"><a href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\ticoncls=\"icon-cancel\" onclick=\"logout()\">退出登录</a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div region=\"center\">\r\n");
      out.write("\t\t<div id=\"tabs\" class=\"easyui-tabs\" border=\"false\" fit=\"true\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<div id=\"editPasswordDiv\" class=\"easyui-dialog\"\r\n");
      out.write("\t\tstyle=\"width: 350px; height: 220px; padding: 20px 20px\" closed=\"true\"\r\n");
      out.write("\t\tbuttons=\"#editPasswordDiv-buttons\">\r\n");
      out.write("\t\t<form id=\"fm\" method=\"post\" novalidate>\r\n");
      out.write("\t\t\t<table align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>原密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"oldPwd\" name=\"oldPwd\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>新密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"newPwd\" name=\"newPwd\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>重复一次:</td>\r\n");
      out.write("\t\t\t\t\t<td><input id=\"againPwd\" name=\"againPwd\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"editPasswordDiv-buttons\" style=\"text-align: center\">\r\n");
      out.write("\t\t<a href=\"javascript:void(0);\" class=\"easyui-linkbutton c6\"\r\n");
      out.write("\t\t\ticoncls=\"icon-ok\" onclick=\"saveUser()\">确定</a> <a\r\n");
      out.write("\t\t\thref=\"javascript:void(0);\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\ticoncls=\"icon-cancel\" onclick=\"$('#editPasswordDiv').dialog('close')\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<div data-options=\"region:'center'\"\r\n");
      out.write("\t\tstyle=\"padding: 5px; background: #eee;\">\r\n");
      out.write("\t\t<div id=\"main-center\" class=\"easyui-tabs\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t<div title=\"河道管理\" style=\"padding: 20px;\" id=\"allmap\">\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t\t\t//调用百度地图API\r\n");
      out.write("\t\t\t\t\tvar map = new BMap.Map(\"allmap\"); // 创建Map实例\r\n");
      out.write("\t\t\t\t\tmap.centerAndZoom(new BMap.Point(\r\n");
      out.write("\t\t\t\t\t116.404, 39.915), 11); // 初始化地图,设置中心点坐标和地图级别\r\n");
      out.write("\t\t\t\t\tmap.addControl(new BMap.MapTypeControl()); //添加地图类型控件\r\n");
      out.write("\t\t\t\t\tmap.setCurrentCity(\"北京\"); // 设置地图显示的城市 此项是必须设置的\r\n");
      out.write("\t\t\t\t\tmap.enableScrollWheelZoom(true); //开启鼠标滚轮缩放\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
