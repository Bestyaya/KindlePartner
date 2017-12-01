package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base/stylebase.jsp", out, false);
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $('#dg').datagrid({\r\n");
      out.write("                url: 'warn_listData',\r\n");
      out.write("                onLoadSuccess: function (data) {\r\n");
      out.write("            \t\t//alert(data);\r\n");
      out.write("                    if (data.rows < 1) {\r\n");
      out.write("                        var body = $(this).data().datagrid.dc.body2;\r\n");
      out.write("                        body.find('table tbody').append('<tr><td width=\"' + body.width() + '\" style=\"height: 25px; text-align: center;\" colspan=\"5\" ><font color=\"gray\" size=\"2\">无记录!</font></td></tr>');\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        });\r\n");
      out.write("        //按时间查询\r\n");
      out.write("        function refreshGrid() {\r\n");
      out.write("            var dateStart = $(\"#dateStart\").datebox('getValue');\r\n");
      out.write("            var dateEnd = $(\"#dateEnd\").datebox('getValue');\r\n");
      out.write("\r\n");
      out.write("            $('#dg').datagrid({\r\n");
      out.write("                url: 'warn_selectTime',\r\n");
      out.write("                queryParams: {\r\n");
      out.write("                    dateStart: dateStart,\r\n");
      out.write("                    dateEnd: dateEnd\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function picFormatter(value, row, index) {\r\n");
      out.write("            if (row.file) {\r\n");
      out.write("                return '<a href=\"upload/warn/' + row.file + '\" target=\"_blank\">查看</a>'\r\n");
      out.write("            } else {\r\n");
      out.write("                return '无';\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function videoFormatter(value, row, index) {\r\n");
      out.write("            if (row.video) {\r\n");
      out.write("                return '<a href=\"upload/warn/' + row.video + '\" target=\"_blank\">查看</a>'\r\n");
      out.write("            } else {\r\n");
      out.write("                return '无';\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        function audioFormatter(value, row, index) {\r\n");
      out.write("            if (row.audio) {\r\n");
      out.write("                return '<a href=\"upload/warn/' + row.audio + '\" target=\"_blank\">查看</a>'\r\n");
      out.write("            } else {\r\n");
      out.write("                return '无';\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        #fm {\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 10px 30px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .ftitle {\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            padding: 5px 0;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("            border-bottom: 1px solid #ccc;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .fitem {\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .fitem label {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            width: 80px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .fitem input {\r\n");
      out.write("            width: 600px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table id=\"dg\" class=\"easyui-datagrid\" title=\"查询列表\" style=\"width:100%;height:800px\"\r\n");
      out.write("       toolbar=\"#toolbar\" pagination=\"true\"\r\n");
      out.write("       rownumbers=\"true\" fitColumns=\"true\" singleSelect=\"true\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th field=\"createTime\" width=\"35\">时间</th>\r\n");
      out.write("        <th field=\"name\" width=\"55\">地点</th>\r\n");
      out.write("        <th field=\"description\" width=\"50\">上报信息</th>\r\n");
      out.write("        <th data-options=\"field:'file',align:'center',formatter:picFormatter\" width=\"40\">图片</th>\r\n");
      out.write("        <th data-options=\"field:'video',align:'center',formatter:videoFormatter\" width=\"45\">视频</th>\r\n");
      out.write("        <th data-options=\"field:'audio',align:'center',formatter:audioFormatter\" width=\"45\">音频</th>\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("</table>\r\n");
      out.write("<div id=\"toolbar\">\r\n");
      out.write("    <div id=\"search-form\" style=\"margin: 3px auto; height: 24px; line-height: 24px\">\r\n");
      out.write("        起始时间:\r\n");
      out.write("        <input class=\"easyui-datetimebox\" id=\"dateStart\">\r\n");
      out.write("        结束时间:\r\n");
      out.write("        <input class=\"easyui-datetimebox\" id=\"dateEnd\">\r\n");
      out.write("        <a id=\"serch\" onclick=\"refreshGrid()\" class=\"easyui-linkbutton\" href=\"javascript:void(0)\" iconCls=\"icon-search\">查询</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
