//检查表单是否合法
function checkData(){
			if($('#loginid').val()==""){
				$.messager.alert("提示信息", "请输入账号信息。", "info");
			}else if($('#password').val()==""){
				$.messager.alert("提示信息", "请输入密码信息。", "info");
			}else{
				doLogin();
			}
		}
		
		//执行登录
		/**
		 * 返回的数据的格式为：{"json":{},"admin":{}}
		 * @memberOf {TypeName} 
		 * @return {TypeName} 
		 */
		function doLogin(){
            $('#form').form('submit',{
                url: 'admin_Login',
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    if (result == null) return;
                    result = $.parseJSON(result);    //转换为json对象
                    var msg = result.message;
                    if (result.success) {
                        $.messager.alert("信息提示", msg, "info", function () {
                            window.location.href = 'backstafe.jsp';
                        })
                    }else{
                        $.messager.alert("错误", "操作失败！" + msg, "error");
                    }
                }
            });
		}