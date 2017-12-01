package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>登录</title>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/stylebase.jsp", out, false);
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\trev=\"stylesheet\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction checkData(){\r\n");
      out.write("\t\t\tif($('#loginid').val()==\"\"){\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示信息\", \"请输入账号信息。\", \"info\");\r\n");
      out.write("\t\t\t}else if($('#password').val()==\"\"){\r\n");
      out.write("\t\t\t\t$.messager.alert(\"提示信息\", \"请输入密码信息。\", \"info\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tdoLogin();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//执行登录\r\n");
      out.write("\t\t/**\r\n");
      out.write("\t\t * 返回的数据的格式为：{\"json\":{},\"user\":{}}\r\n");
      out.write("\t\t * @memberOf {TypeName} \r\n");
      out.write("\t\t * @return {TypeName} \r\n");
      out.write("\t\t */\r\n");
      out.write("\t\tfunction doLogin(){\r\n");
      out.write("            $('#form').form('submit',{\r\n");
      out.write("                url: 'user_login',\r\n");
      out.write("                onSubmit: function(){\r\n");
      out.write("                    return $(this).form('validate');\r\n");
      out.write("                },\r\n");
      out.write("                success: function(result){\r\n");
      out.write("                    if (result == null) return;\r\n");
      out.write("                    result = $.parseJSON(result);    //转换为json对象\r\n");
      out.write("                    //result = $.parseJSON(result.json);   //取出json数据来再转换为json对象\r\n");
      out.write("                    var msg = result.message;\r\n");
      out.write("                    if (result.success) {\r\n");
      out.write("                        $.messager.alert(\"信息提示\", msg, \"info\", function () {\r\n");
      out.write("                            window.location.href = 'main.jsp';\r\n");
      out.write("                        })\r\n");
      out.write("                    }else{\r\n");
      out.write("                        $.messager.alert(\"错误\", \"操作失败！\" + msg, \"error\");\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("\t<div class=\"dl\">\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<img src=\"css/images/ico02.jpg\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form name=\"form\" id=\"form\" method=\"post\" action=\"user_login\"\r\n");
      out.write("\t\t\tautocomplete=\"off\">\r\n");
      out.write("\t\t\t<div class=\"log\">\r\n");
      out.write("\t\t\t\t<ul class=\"xuzhi02\">\r\n");
      out.write("\t\t\t\t\t<img src=\"images/earth.jpg\" />\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"deng02\">\r\n");
      out.write("\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:60px;\"><label>账号：</label> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"loginid\" name=\"user.loginid\" style=\"height: 35px;width: 300px\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-textbox\" required=\"true\" missingMessage=\"填写账号\" /></li>\r\n");
      out.write("\t\t\t\t\t<div style=\"clear:both;\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%; height:40px;\"><label>密码：</label> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"password\" name=\"user.password\" type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"height: 35px;width: 300px\" class=\"easyui-textbox\"\r\n");
      out.write("\t\t\t\t\t\trequired=\"true\" missingMessage=\"填写密码\" /></li>\r\n");
      out.write("\t\t\t\t\t<li style=\" width:100%;\">\r\n");
      out.write("\t\t\t\t\t\t<p style=\"margin-left: 270px\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"register.jsp\" class=\"regbtn\">新用户注册</a>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"logonbtn\" class=\"btn-login02\" onclick=\"checkData()\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"button\" style=\"margin-left: 110px;width: 200px\">\r\n");
      out.write("\t\t\t\t\t\t\t<span>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</span>\r\n");
      out.write("\t\t\t\t\t\t</button></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
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
