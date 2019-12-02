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
    <meta name="__hash__" content="303e9ba3b269fda816533220925dd6dc_cc0fa5127433686a525e2daa646733c2">
</head>
<body style="background-color:#ecf0f5;">


<div class="wrapper">
    <div class="breadcrumbs" id="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>

            <li><a href="javascript:void();">商品管理</a></li>
            <li><a href="javascript:void();">商品规格</a></li>
        </ol>
    </div>

    <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-list"></i> 商品规格</h3>
                </div>
                <div class="panel-body">
                    <div class="navbar navbar-default">
                        <form action="" id="search-form2" class="navbar-form form-inline" method="get"
                              onsubmit="return false">
                            <div class="form-group">

                                <select name="type_id" id="type_id" class="form-control" onchange="selectSpecByTypeId()">
                                    <option value="0">所有模型</option>
                                    <c:forEach items="${goodsTypeList}" var="goodsType">
                                    <option <c:if test="${goodsType.id==typeId}">selected</c:if> value="${goodsType.id}">${goodsType.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" onclick="selectSpecByTypeId()" id="button-filter"
                                        class="btn btn-primary pull-right">
                                    <i class="fa fa-search"></i> 筛选
                                </button>
                            </div>
                            <button type="submit" onclick="location.href='${ctx}/product/spec/add/${typeId}'" id="button-filter2"
                                    class="btn btn-primary pull-right">
                                <i class="fa fa-plus"></i> 添加规格
                            </button>
                            <input name="__hash__"
                                   value="303e9ba3b269fda816533220925dd6dc_cc0fa5127433686a525e2daa646733c2"
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
                                        <th class="sorting text-left">规格名称</th>
                                        <th class="sorting text-left">所属模型</th>
                                        <th class="sorting text-left">规格项</th>
                                        <th class="sorting text-center">筛选</th>
                                        <th class="sorting text-left">排序</th>
                                        <th class="sorting text-left">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <c:forEach  items="${goodsSpecList}" var="goodsSpec">
                                        <td class="text-center">
                                            <input name="selected[]" value="6" type="checkbox">
                                        </td>
                                        <td class="text-right">${goodsSpec.specId}</td>
                                        <td class="text-left">${goodsSpec.specName}</td>
                                        <td class="text-left">${goodsSpec.typeName}</td>
                                        <td class="text-left">${goodsSpec.specValue}</td>
                                        <td class="text-center">
                                            <img src="${ctx}/Public/images/yes.png"
                                                 onclick="changeTableVal('spec','id','25','search_index',this)"
                                                 width="20" height="20">
                                        </td>
                                        <td class="text-right">
                                            <input class="form-control input-sm"
                                                   onchange="updateSort('spec','id','25','order',this)"
                                                   onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d]/g,'')" size="4"
                                                   value="${goodsSpec.specOrder}" type="text">
                                        </td>
                                        <td class="text-right">
                                            <a href="${ctx}/product/spec/edit/${goodsSpec.specId}" data-toggle="tooltip" title=""
                                               class="btn btn-primary" data-original-title="编辑"><i
                                                    class="fa fa-pencil"></i></a>
                                            <a href="javascript:void(0)"
                                               onclick="del_fun(this,'${ctx}/product/spec/delete/${goodsSpec.specId}')"
                                               id="button-delete6" data-toggle="tooltip" title="" class="btn btn-danger"
                                               data-original-title="删除"><i class="fa fa-trash-o"></i></a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <input name="__hash__"
                                   value="f04c697bdb6142ad9336389a10b832fe_5d56e7c3b7f5f437214cac938c1917a3"
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
            url: "/index?m=Admin&c=goods&a=ajaxSpecList&p=" + page,//+tab,
            data: $('#' + form).serialize(),// 你的formid
            success: function (data) {
                $("#ajax_return").html('');
                $("#ajax_return").append(data);
            }
        });
    }
//根据模型id查询规格
    function selectSpecByTypeId(){
        var typeId=$("#type_id").val();
        $("#search-form2").attr("action","${ctx}/product/spec/list/"+typeId).attr("onsubmit","return true").submit();
    }

</script>

</body>
</html>