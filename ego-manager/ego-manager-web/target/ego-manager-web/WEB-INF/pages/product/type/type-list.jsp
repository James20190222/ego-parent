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
    <meta name="__hash__" content="cddf895e56eb257a5f0485d8651c22bb_3c330b50af4f7929feb53517849788a7"/>
</head>
<body style="background-color:#ecf0f5;">


<div class="wrapper">
    <div class="breadcrumbs" id="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>

            <li><a href="javascript:void();">商品管理</a></li>
            <li><a href="javascript:void();">商品类型</a></li>
        </ol>
    </div>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-list"></i> 商品模型列表</h3>
                </div>
                <div class="panel-body">
                    <div class="navbar navbar-default">
                        <div class="row navbar-form">
                            <div class="col-xs-10"><span class="text-warning">商品模型是用来规定某一类商品共有规格和属性的集合，其中规格会影响商品价格，同一个商品不同的规格价格会不同，而属性仅仅是商品的属性特质展示</span>
                            </div>
                            <div class="col-xs-2">
                                <button type="submit" onclick="location.href='${ctx}/product/type/add'"
                                        class="btn btn-primary pull-right"><i class="fa fa-plus"></i>新增商品模型
                                </button>
                            </div>
                        </div>
                    </div>

                    <div id="ajax_return">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th class="sorting text-center">ID</th>
                                    <th class="sorting text-center">模型名称</th>
                                    <th class="sorting text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${goodsTypeList}" var="goodsType">
                                    <tr>
                                        <td class="text-center">${goodsType.id}</td>
                                        <td class="text-center">${goodsType.name}</td>
                                        <td class="text-center">
                                            <a href="${ctx}/product/attribute/list/${goodsType.id}" data-toggle="tooltip" title="" class="btn btn-info"
                                               data-original-title="属性列表">属性列表</a>
                                            <a href="${ctx}/product/spec/list/${goodsType.id}" data-toggle="tooltip" title="" class="btn btn-info"
                                               data-original-title="属性列表">规格列表</a>
                                            <a href="${ctx}/product/type/edit/${goodsType.id}" data-toggle="tooltip"
                                               title="" class="btn btn-primary" data-original-title="编辑"><i
                                                    class="fa fa-pencil"></i></a>
                                            <a href="javascript:void(0)" onclick="del_fun(this,'${ctx}/product/type/delete/${goodsType.id}')"
                                               id="button-delete6" data-toggle="tooltip" title="" class="btn btn-danger"
                                               data-original-title="删除"><i class="fa fa-trash-o"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div class="row">
                            <div class="col-sm-6 text-left"></div>
                            <div class="col-sm-6 text-right">
                                <div class='dataTables_paginate paging_simple_numbers'>
                                    <ul class='pagination'></ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
</body>
</html>