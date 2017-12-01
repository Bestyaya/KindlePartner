package org.apache.jsp.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stylebase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
