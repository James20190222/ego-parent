<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
    <%--静态导入--%>
    <%@ include file="../../head.jsp" %>
    <script type="text/javascript">
        function delfunc(obj) {
            layer.confirm('确认删除？', {
                    btn: ['确定', '取消'] //按钮
                }, function () {
                    $.ajax({
                        type: 'post',
                        url: $(obj).attr('data-url'),
                        data: {act: 'del', del_id: $(obj).attr('data-id')},
                        dataType: 'json',
                        success: function (data) {
                            if (data == 1) {
                                layer.msg('操作成功', {icon: 1});
                                $(obj).parent().parent().remove();
                            } else {
                                layer.msg(data, {icon: 2, time: 2000});
                            }
                            layer.closeAll();
                        }
                    })
                }, function (index) {
                    layer.close(index);
                    return false;// 取消
                }
            );
        }

        //全选
        function selectAll(name, obj) {
            $('input[name*=' + name + ']').prop('checked', $(obj).checked);
        }

        function get_help(obj) {
            layer.open({
                type: 2,
                title: '帮助手册',
                shadeClose: true,
                shade: 0.3,
                area: ['90%', '90%'],
                content: $(obj).attr('data-url'),
            });
        }

        function delAll(obj, name) {
            var a = [];
            $('input[name*=' + name + ']').each(function (i, o) {
                if ($(o).is(':checked')) {
                    a.push($(o).val());
                }
            })
            if (a.length == 0) {
                layer.alert('请选择删除项', {icon: 2});
                return;
            }
            layer.confirm('确认删除？', {btn: ['确定', '取消']}, function () {
                    $.ajax({
                        type: 'get',
                        url: $(obj).attr('data-url'),
                        data: {act: 'del', del_id: a},
                        dataType: 'json',
                        success: function (data) {
                            if (data == 1) {
                                layer.msg('操作成功', {icon: 1});
                                $('input[name*=' + name + ']').each(function (i, o) {
                                    if ($(o).is(':checked')) {
                                        $(o).parent().parent().remove();
                                    }
                                })
                            } else {
                                layer.msg(data, {icon: 2, time: 2000});
                            }
                            layer.closeAll();
                        }
                    })
                }, function (index) {
                    layer.close(index);
                    return false;// 取消
                }
            );
        }
    </script>
    <meta name="__hash__" content="cf554f9a4e1610446043787a5ca8b989_c9e863c0aaa1bb40de4beaffc1d599a7"/>
</head>
<body style="background-color:#ecf0f5;">


<div class="wrapper">
    <div class="breadcrumbs" id="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>

            <li><a href="javascript:void();">商品管理</a></li>
            <li><a href="javascript:void();">编辑商品类型</a></li>
        </ol>
    </div>

    <section class="content">
        <!-- Main content -->
        <div class="container-fluid">
            <div class="pull-right">
                <a href="${ctx}/product/type/list" data-toggle="tooltip" title="" class="btn btn-default"
                   data-original-title="返回"><i class="fa fa-reply"></i></a>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-list"></i> 订单详情</h3>
                </div>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_tongyong" data-toggle="tab">商品类型</a></li>
                    </ul>
                    <!--表单数据-->
                    <form method="post" id="addEditGoodsTypeForm" onsubmit="return false">
                        <!--通用信息-->
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_tongyong">

                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>类型名称:</td>
                                        <td>
                                            <input type="text" value="" name="name"/>
                                            <span id="err_name" style="color:#F00; display:none;">商品类型名称不能为空!!</span>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="pull-right">
                            <input type="hidden" name="id" value="">
                            <button class="btn btn-primary" title="" data-toggle="tooltip" type="button"
                                    onclick="ajax_submit_form('addEditGoodsTypeForm','${ctx}/product/type/save','${ctx}/product/type/add','${ctx}/product/type/list')"
                                    data-original-title="保存"><i class="fa fa-save"></i></button>
                        </div>
                        <input type="hidden" name="__hash__"
                               value="cf554f9a4e1610446043787a5ca8b989_c9e863c0aaa1bb40de4beaffc1d599a7"/>
                    </form>
                    <!--表单数据-->
                </div>
            </div>
        </div>    <!-- /.content -->
    </section>
</div>
<script>

</script>

</body>
</html>