<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="base/stylebase.jsp"/>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                url: 'warn_listData',
                onLoadSuccess: function (data) {
            		//alert(data);
                    if (data.rows < 1) {
                        var body = $(this).data().datagrid.dc.body2;
                        body.find('table tbody').append('<tr><td width="' + body.width() + '" style="height: 25px; text-align: center;" colspan="5" ><font color="gray" size="2">无记录!</font></td></tr>');
                    }
                }
            })
        });
        //按时间查询
        function refreshGrid() {
            var dateStart = $("#dateStart").datebox('getValue');
            var dateEnd = $("#dateEnd").datebox('getValue');

            $('#dg').datagrid({
                url: 'warn_selectTime',
                queryParams: {
                    dateStart: dateStart,
                    dateEnd: dateEnd
                }
            });
        }

        function picFormatter(value, row, index) {
            if (row.file) {
                return '<a href="upload/warn/' + row.file + '" target="_blank">查看</a>'
            } else {
                return '无';
            }
        }
        function videoFormatter(value, row, index) {
            if (row.video) {
                return '<a href="upload/warn/' + row.video + '" target="_blank">查看</a>'
            } else {
                return '无';
            }
        }
        function audioFormatter(value, row, index) {
            if (row.audio) {
                return '<a href="upload/warn/' + row.audio + '" target="_blank">查看</a>'
            } else {
                return '无';
            }
        }


    </script>
    <style type="text/css">
        #fm {
            margin: 0;
            padding: 10px 30px;
        }

        .ftitle {
            font-size: 20px;
            font-weight: bold;
            padding: 5px 0;
            margin-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }

        .fitem {
            margin-bottom: 5px;
        }

        .fitem label {
            display: inline-block;
            width: 80px;
        }

        .fitem input {
            width: 600px;
        }
    </style>
</head>
<body>
<table id="dg" class="easyui-datagrid" title="查询列表" style="width:100%;height:800px"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="createTime" width="35">时间</th>
        <th field="name" width="55">地点</th>
        <th field="description" width="50">上报信息</th>
        <th data-options="field:'file',align:'center',formatter:picFormatter" width="40">图片</th>
        <th data-options="field:'video',align:'center',formatter:videoFormatter" width="45">视频</th>
        <th data-options="field:'audio',align:'center',formatter:audioFormatter" width="45">音频</th>

        <%--<th width="165" data-options="field:'id',align:'center',formatter:urlFormatter">操作</th>--%>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <div id="search-form" style="margin: 3px auto; height: 24px; line-height: 24px">
        起始时间:
        <input class="easyui-datetimebox" id="dateStart">
        结束时间:
        <input class="easyui-datetimebox" id="dateEnd">
        <a id="serch" onclick="refreshGrid()" class="easyui-linkbutton" href="javascript:void(0)" iconCls="icon-search">查询</a>
    </div>
</div>
</body>
</html>