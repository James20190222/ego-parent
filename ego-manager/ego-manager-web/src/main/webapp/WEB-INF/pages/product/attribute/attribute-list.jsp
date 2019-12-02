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
    <meta name="__hash__" content="fd6059588f758033044de1141d249844_02bad2de3b662123d3092c856167c3f1">
</head>
<body style="background-color:#ecf0f5;">


<div class="wrapper">
    <div class="breadcrumbs" id="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>

            <li><a href="javascript:void();">商品管理</a></li>
            <li><a href="javascript:void();">商品属性</a></li>
        </ol>
    </div>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-list"></i> 商品属性</h3>
                </div>
                <div class="panel-body">
                    <div class="navbar navbar-default">
                        <form action="" id="search-form2" class="navbar-form form-inline" method="post"
                              onsubmit="return false">
                            <div class="form-group">
                                <select name="type_id" id="type_id" class="form-control">
                                    <option value="0">所有模型</option>
                                    <c:forEach items="${goodsTypeList}" var="goodsType">
                                    <option <c:if test="${goodsType.id==typeId}">selected</c:if> value="${goodsType.id}">${goodsType.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" onclick="ajax_get_table('search-form2',1)" id="button-filter"
                                        class="btn btn-primary pull-right">
                                    <i class="fa fa-search"></i> 筛选
                                </button>
                            </div>
                            <button type="button" onclick="location.href='${ctx}/product/attribute/add/${typeId}'"
                                    class="btn btn-primary pull-right">
                                <i class="fa fa-plus"></i> 添加属性
                            </button>
                            <input name="__hash__"
                                   value="fd6059588f758033044de1141d249844_02bad2de3b662123d3092c856167c3f1"
                                   type="hidden">
                        </form>
                    </div>
                    <div id="ajax_return">
                        <form method="post" enctype="multipart/form-data" target="_blank" id="form-goodsType">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="width: 1px;" class="text-center"><input
                                                onclick="$('input[name*=\'selected\']').prop('checked', this.checked);"
                                                type="checkbox"></th>
                                        <th class="sorting text-left">ID</th>
                                        <th class="sorting text-left">属性名称</th>
                                        <th class="sorting text-left">所属模型</th>
                                        <th class="sorting text-left">属性值的输入方式</th>
                                        <th class="sorting text-left">可选值列表</th>
                                        <th class="sorting text-center">筛选</th>
                                        <th class="sorting text-left">排序</th>
                                        <th class="sorting text-right">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${goodsAttributeList}" var="goodsAttribute">
                                        <tr>
                                            <td class="text-center">
                                                <input name="selected[]" value="6" type="checkbox">
                                            </td>
                                            <td class="text-right">${goodsAttribute.attrId}</td>
                                            <td class="text-left">${goodsAttribute.attrName}</td>
                                            <td class="text-left">${goodsAttribute.typeName}</td>
                                            <td class="text-left">${goodsAttribute.attrInputType}</td>
                                            <td class="text-left"></td>
                                            <td class="text-center">
                                                <img src="${ctx}/Public/images/yes.png"
                                                     onclick="changeTableVal('goods_attribute','attr_id','329','attr_index',this)"
                                                     width="20" height="20">
                                            </td>
                                            <td class="text-left">
                                                <input onchange="updateSort('goods_attribute','attr_id','329','order',this)"
                                                       onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
                                                       onpaste="this.value=this.value.replace(/[^\d]/g,'')" size="4"
                                                       value="50" type="text">
                                            </td>
                                            <td class="text-right">
                                                <a href="${ctx}/product/attribute/edit/${goodsAttribute.attrId}" data-toggle="tooltip" title=""
                                                   class="btn btn-primary" data-original-title="编辑"><i
                                                        class="fa fa-pencil"></i></a>
                                                <a href="javascript:void(0)"
                                                   onclick="del_fun(this,'${ctx}/product/attribute/delete/${goodsAttribute.attrId}')"
                                                   id="button-delete6" data-toggle="tooltip" title="" class="btn btn-danger"
                                                   data-original-title="删除"><i class="fa fa-trash-o"></i></a></td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <input name="__hash__"
                                   value="9dfb4325c77ab60718bef22df39852ac_8ac79714c92a6310791e7291bbb4c681"
                                   type="hidden"></form>
                        <div class="row">
                            <div class="col-sm-6 text-left"></div>
                            <div class="col-sm-6 text-right">
                                <div class="dataTables_paginate paging_simple_numbers">
                                    <ul class="pagination"></ul>
                                </div>
                            </div>
                        </div>
                        <script>
                            // 点击分页触发的事件
                            $(".pagination  a").click(function () {
                                cur_page = $(this).data('p');
                                ajax_get_table('search-form2', cur_page);
                            });

                        </script>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script>
    // ajax 抓取页面 form 为表单id  page 为当前第几页
    function ajax_get_table(form, page) {
        cur_page = page; //当前页面 保存为全局变量
        $.ajax({
            type: "POST",
            url: "/index?m=Admin&c=goods&a=ajaxGoodsAttributeList&p=" + page,//+tab,
            data: $('#' + form).serialize(),// 你的formid
            success: function (data) {
                $("#ajax_return").html('');
                $("#ajax_return").append(data);
            }
        });
    }

</script>

</body>
</html>