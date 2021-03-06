
/**
* ajax 提交表单 到后台去验证然后回到前台提示错误
* 验证通过后,再通过 form 自动提交
*/
before_request = 1; // 标识上一次ajax 请求有没回来, 没有回来不再进行下一次
/**
 *  公共新增提交方法
 * @param form_id    提交form id
 * @param submit_url 提交的保存地址
 * @param add_url    新增地址
 * @param list_url   返回列表地址
 * @returns {boolean}
 */
function ajax_submit_form(form_id,submit_url,add_url,list_url){

         if(before_request == 0)
            return false;
    $.ajax({
                type : "POST",
                url  : submit_url,
                data : $('#'+form_id).serialize(),// 你的formid
                dataType:"JSON",
                error: function(request) {
                        layer.alert("亲,系统正在升级中,请稍后再试!");
                },
                success: function(result) {
                    if(200==result.code){
                        $("#goodsId").val(result.message);
                        $("#file-goods-images").removeAttr("disabled");
                        layer.confirm('保存成功！', {btn: ['继续操作', '返回列表','留在本页']},
                            function () {
                                window.location.href = add_url;
                            }, function () {
                                window.location.href =list_url;
                            },function (index) {
                                layer.close(index);
                            });
                    }else{
                        layer.alert("保存失败!");
                    }
                }
            });   
            before_request = 0; // 标识ajax 请求已经发出
}


update_request = 1; // 标识上一次ajax 请求有没回来, 没有回来不再进行下一次
/**
 *  公共修改方法
 * @param form_id    提交form id
 * @param update_url 提交的修改地址
 * @param edit_url   继续编辑的地址
 * @param list_url   返回列表地址
 * @returns {boolean}
 */
function ajax_update_form(form_id,update_url,edit_url,list_url){

    if(update_request == 0)
        return false;
    $.ajax({
        type : "get",
        url  : update_url,
        data : $('#'+form_id).serialize(),// 你的formid
        dataType:"JSON",
        error: function(request) {
            layer.alert("亲,系统正在升级中,请稍后再试!");
        },
        success: function(result) {
            if(200==result.code){
                layer.confirm('保存成功！', {btn: ['继续编辑', '返回列表','留在本页']},
                    function () {
                        window.location.href = edit_url;
                    }, function () {
                        window.location.href =list_url;
                    },function (index) {
                        layer.close(index);
                    });
            }else{
                layer.alert("保存失败!");
            }
        }
    });
    before_request = 0; // 标识ajax 请求已经发出
}

/**
* 在ajax 返回提示错误时， 输入框改变时提示 将隐藏
*/
$(document).ready(function(){
	/*
   $("input").click(function(){	           
	    var input_name = $(this).attr("name");   
		//$("#err_"+input_name).hide();
   });
   $("textarea").click(function(){    
	    var input_name = $(this).attr("name");   
		//$("#err_"+input_name).hide();
   });
   */   
	
});


/**
 *  Ajax通用提交表单
 *  @var  form表单的id属性值  form_id
 *  @var  提交地址 subbmit_url
 */

function post_form(form_id,subbmit_url){
    if(form_id == ''){
        alert('缺少必要参数');
        return false;
    }
    if(!subbmit_url){
        //  默认取当前地址  加上ajax请求标示
        subbmit_url = location.href + '/is_ajax/1';
    }
    //  序列化表单值
    var data = $('#'+form_id).serialize();

    $.post(subbmit_url,data,function(result){
        var obj = $.parseJSON(result);
        if(obj.status == 0){
            //alert(obj.msg);
            return false;
        }
        if(obj.status == 1){
            //alert(obj.msg);
            if(obj.data.return_url){
                //  返回跳转链接
                location.href = obj.data.return_url;
            }else{
                //  刷新页面
                location.reload();
            }
            return;
        }
    })
}


/**
 *  伪静态HTML处理
 *  @var  网址  url
 */
function convert_url(url){
   if(url){
       url = url.replace('.html','');
   }
    return url;
}
 
		// 输入框失去焦点 ajax 保存
//		$('input[name^="field_"]').on('blur', function () {
	function ajaxUpdateField(obj){
			 var table = $(obj).data('table');
			 var id = $(obj).data('id');			 
			 var field = $(obj).attr('name').replace(/field_/ig,""); // 字段名字
			 var value = $(obj).val();				 
			 $.ajax({
				 type:'POST',
				 data:{table:table,id:id, field:field,value:value}, 
				 url:"/admin/Goods/updateField",
				 success:function(data){					 
						  layer.msg('修改成功', {icon: 1,time:1000});
				 }        
			 });			 
	}
	//	});	