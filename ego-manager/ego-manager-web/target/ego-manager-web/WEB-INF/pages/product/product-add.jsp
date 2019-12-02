<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../head.jsp" %>
    <link rel="stylesheet" href="${ctx }/Public/css/fileinput.min.css"></link>
    <script type="text/javascript" src="${ctx }/Public/js/fileinput.js"></script>
    <!-- 对中文的支持 -->
    <script type="text/javascript" src="${ctx }/Public/js/fileinput_locale_zh.js"></script>
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
    <meta name="__hash__" content="4215372d5f63004790e1b9f4ed8df8b8_e74f2c0a9d3eff6e5b0e2ac8545e8177"/>
</head>
<body style="background-color:#ecf0f5;">


<!--物流配置 css -start-->
<style>
    ul.group-list {
        width: 96%;
        min-width: 1000px;
        margin: auto 5px;
        list-style: disc outside none;
    }

    ul.group-list li {
        white-space: nowrap;
        float: left;
        width: 150px;
        height: 25px;
        padding: 3px 5px;
        list-style-type: none;
        list-style-position: outside;
        border: 0px;
        margin: 0px;
    }
</style>
<!--物流配置 css -end-->

<!--以下是在线编辑器 代码 -->
<script type="text/javascript" charset="utf-8" src="${ctx}/Public/plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/Public/plugins/ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/Public/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
    var editor;
    $(function () {
        //具体参数配置在 editor_config.js 中
        var options = {
            // 表示层级
            zIndex: 999,
            //初化宽度
            initialFrameWidth: "95%",
            //初化高度
            initialFrameHeight: 400,
            //初始化时，是否让编辑器获得焦点 true 或 false
            focus: false,
            // 允许的最大字符数 'fullscreen'
            maximumWords: 99999,
            removeFormatAttributes: 'class,style,lang,width,height,align,hspace,valign',
            // 是否默认为纯文本粘贴。false 为不使用纯文本粘贴，true 为使用纯文本粘贴
            pasteplain: false,
            autoHeightEnabled: true,
            // 自动排版设置
            /* autotypeset: {
             mergeEmptyline: true, //合并空行
             removeClass: true, //去掉冗余的 class
             removeEmptyline: false, //去掉空行
             textAlign: "left", //段落的排版方式，可以是 left,right,center,justify 去掉这
             个属性表示不执行排版
             imageBlockLine: 'center', //图片的浮动方式，独占一行剧中,左右浮动，默认:
             center,left,right,none 去掉这个属性表示不执行排版
             pasteFilter: false, //根据规则过滤没事粘贴进来的内容
             clearFontSize: false, //去掉所有的内嵌字号，使用编辑器默认的字号
             clearFontFamily: false, //去掉所有的内嵌字体，使用编辑器默认的字体
             removeEmptyNode: false, //去掉空节点
             //可以去掉的标签
             removeTagNames: {"font": 1},
             indent: false, // 行首缩进
             indentValue: '0em' //行首缩进的大小
             }*/
            toolbars: [
                ['fullscreen', 'source', '|', 'undo', 'redo', '|', 'bold', 'italic', 'underline',
                    'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch',
                    'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist',
                    'insertunorderedlist', 'selectall', 'cleardoc', '|', 'rowspacingtop', 'rowspacingbottom',
                    'lineheight', '|', 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|', 'directionalityltr',
                    'directionalityrtl', 'indent', '|', 'justifyleft', 'justifycenter', 'justifyright',
                    'justifyjustify', '|', 'touppercase', 'tolowercase', '|', 'link', 'unlink', 'anchor', '|',
                    'imagenone', 'imageleft', 'imageright', 'imagecenter', '|', 'insertimage', 'emotion',
                    'insertvideo', 'attachment', 'map', 'gmap', 'insertframe', 'insertcode', 'webapp', 'pagebreak',
                    'template', 'background', '|', 'horizontal', 'date', 'time', 'spechars', 'wordimage', '|',
                    'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol',
                    'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows',
                    'splittocols', '|', 'print', 'preview', 'searchreplace']
            ]
        };
        editor = new UE.ui.Editor(options);//初始化
        //渲染textarea
        editor.render("goods_content"); // 指定 textarea 的 id 为 goods_content
    });

</script>

<!--以上是在线编辑器 代码  end-->
<div class="wrapper">
    <div class="breadcrumbs" id="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="javascript:void();"><i class="fa fa-home"></i>&nbsp;&nbsp;后台首页</a></li>

            <li><a href="javascript:void();">商品管理</a></li>
            <li><a href="javascript:void();">添加修改商品</a></li>
        </ol>
    </div>

    <section class="content">
        <!-- Main content -->
        <div class="container-fluid">
            <div class="pull-right">
                <a href="${ctx}/product/list" data-toggle="tooltip" title="" class="btn btn-default"
                   data-original-title="返回"><i class="fa fa-reply"></i></a>
                <a href="javascript:;" class="btn btn-default"
                   data-url="http://www.ego.cn/Doc/Index/article/id/1007/developer/user.html"
                   onclick="get_help(this)"><i class="fa fa-question-circle"></i> 帮助</a>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-list"></i>商品详情</h3>
                </div>
                <div class="panel-body">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_tongyong" data-toggle="tab">通用信息</a></li>
                        <!-- <li><a href="#tab_goods_desc" data-toggle="tab">描述信息</a></li>-->
                        <li><a href="#tab_goods_images" onclick="checkGoods()" data-toggle="tab">商品相册</a></li>
                        <li><a href="#tab_goods_spec" data-toggle="tab">商品模型</a></li>
                        <li><a href="#tab_goods_shipping" data-toggle="tab">商品物流</a></li>
                    </ul>
                    <!--表单数据-->
                    <form method="post" id="addEditGoodsForm">

                        <!--通用信息-->
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_tongyong">

                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>商品名称:</td>
                                        <td>
                                            <input type="text" value="" name="goodsName" class="form-control"
                                                   style="width:550px;"/>
                                            <span id="err_goods_name" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>商品简介:</td>
                                        <td>
                                            <textarea rows="3" cols="80" name="goodsRemark"></textarea>
                                            <span id="err_goods_remark" style="color:#F00; display:none;"></span>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>商品货号</td>
                                        <td>
                                            <input type="text" value="" name="goodsSn" class="form-control"
                                                   style="width:350px;"/>
                                            <span id="err_goods_sn" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>SPU</td>
                                        <td>
                                            <input type="text" value="" name="spu" class="form-control"
                                                   style="width:350px;"/>
                                            <span id="err_goods_spu" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>SKU</td>
                                        <td>
                                            <input type="text" value="" name="sku" class="form-control"
                                                   style="width:350px;"/>
                                            <span id="err_goods_sku" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <input type="text" id="catId" name="catId" value="0"/>
                                        <td>商品分类:</td>
                                        <td>
                                            <div class="col-xs-3">
                                                <select name="cat_id" id="cat_id_1"
                                                        onchange="get_category(this.value,'cat_id_2','catId');"
                                                        class="form-control" style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                    <c:forEach var="gc" items="${gcList}">
                                                        <option value="${gc.id}">${gc.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-xs-3">
                                                <select name="cat_id_2" id="cat_id_2"
                                                        onchange="get_category(this.value,'cat_id_3','catId');"
                                                        class="form-control" style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                </select>
                                            </div>
                                            <div class="col-xs-3">
                                                <select name="cat_id_3" id="cat_id_3" class="form-control"
                                                        onchange="setHidden(this.value,'cat_id_2','catId')"
                                                        style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                </select>
                                            </div>
                                            <span id="err_cat_id" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <input type="text" id="extendCatId" name="extendCatId" value="0"/>
                                        <td>扩展分类:</td>
                                        <td>
                                            <div class="col-xs-3">
                                                <select name="extend_cat_id" id="extendCat_id_1"
                                                        onchange="get_category(this.value,'extendCat_id_2','extendCatId');"
                                                        class="form-control" style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                    <c:forEach var="gc" items="${gcList}">
                                                        <option value="${gc.id}">${gc.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="col-xs-3">
                                                <select name="extend_cat_id_2" id="extendCat_id_2"
                                                        onchange="get_category(this.value,'extendCat_id_3','extendCatId');"
                                                        class="form-control" style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                </select>
                                            </div>
                                            <div class="col-xs-3">
                                                <select name="extend_cat_id_3" id="extendCat_id_3" class="form-control"
                                                        onchange="setHidden(this.value,'extendCat_id_2','extendCatId')"
                                                        style="width:250px;margin-left:-15px;">
                                                    <option value="0">请选择商品分类</option>
                                                </select>
                                            </div>
                                            <span id="err_cat_id" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>

                                    <!--
                                                                    <tr>
                                                                        <td>商品分类:</td>
                                                                        <td>
                                                                          <select name="cat_id" id="cat_id" class="form-control" style="width:250px;">
                                                                            <option value="">所有分类</option>
                                                                                 <option value="1"  >
                                                                                           ----- 手机 、 数码 、 通信                                               </option><option value="2"  >
                                                                                           ----- 家用电器                                               </option><option value="3"  >
                                                                                           ----- 电脑、办公                                               </option><option value="4"  >
                                                                                           ----- 家居、家具、家装、厨具                                               </option><option value="5"  >
                                                                                           ----- 男装、女装、童装、内衣                                               </option><option value="6"  >
                                                                                           ----- 个人化妆                                               </option><option value="7"  >
                                                                                           ----- 鞋、箱包、珠宝、手表                                               </option><option value="8"  >
                                                                                           ----- 运动户外                                               </option><option value="9"  >
                                                                                           ----- 汽车用品                                               </option><option value="10"  >
                                                                                           ----- 母婴用品、儿童玩具                                               </option><option value="11"  >
                                                                                           ----- 图书、音像、电子书                                               </option>                                      </select>
                                                                        </td>
                                                                    </tr>
                                    -->
                                    <tr>
                                        <td>商品品牌:</td>
                                        <td>
                                            <select name="brandId" id="brand_id" class="form-control"
                                                    style="width:250px;">
                                                <option value="">所有品牌</option>
                                                <c:forEach var="brand" items="${brandList}">
                                                    <option value="${brand.id}">${brand.name}</option>
                                                </c:forEach>

                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>供应商:</td>
                                        <td>
                                            <select name="suppliersId" id="suppliers_id" class="form-control"
                                                    style="width:250px;">
                                                <option value="0">不指定供应商属于本店商品</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>本店售价:</td>
                                        <td>
                                            <input type="text" value="" name="shopPrice" class="form-control"
                                                   style="width:150px;"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_shop_price" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>市场价:</td>
                                        <td>
                                            <input type="text" value="" name="marketPrice" class="form-control"
                                                   style="width:150px;"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_market_price" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>成本价:</td>
                                        <td>
                                            <input type="text" value="" name="costPrice" class="form-control"
                                                   style="width:150px;"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_cost_price" style="color:#F00; display:none"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>佣金:</td>
                                        <td>
                                            <input type="text" value="" name="commission" class="form-control"
                                                   style="width:150px;"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            用于分销的分成金额
                                        </td>
                                    </tr>
                                    <tr>
                                        <input type="text" name="originalImg" id="originalImg"/>
                                        <td>上传商品图片:</td>
                                        <td>
                                            <form enctype="multipart/form-data">
                                                <input id="file-product" class="file" name="file" type="file" multiple
                                                       data-min-file-count="1">
                                            </form>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>商品重量:</td>
                                        <td>
                                            <input type="text" class="form-control" style="width:150px;" value=""
                                                   name="weight" onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            &nbsp;克 (以克为单位)
                                            <span id="err_weight" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>是否包邮:</td>
                                        <td>
                                            是:<input type="radio" value="1" name="isFreeShipping"/>
                                            否:<input type="radio" checked="checked" value="0" name="is_free_shipping"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>库存数量:</td>
                                        <td>
                                            <input type="text" value="1" class="form-control" style="width:150px;"
                                                   name="storeCount"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_store_count" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>赠送积分:</td>
                                        <td>
                                            <input type="text" class="form-control" style="width:150px;" value=""
                                                   name="giveIntegral"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_give_integral" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>兑换积分:</td>
                                        <td>
                                            <input type="text" class="form-control" style="width:150px;" value=""
                                                   name="exchangeIntegral"
                                                   onkeyup="this.value=this.value.replace(/[^\d.]/g,'')"
                                                   onpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
                                            <span id="err_exchange_integral" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <!--
                                    <tr>
                                        <td>设置:</td>
                                        <td>
                                            <input type="checkbox" checked="checked" value="" name="is_on_sale"/> 上架&nbsp;&nbsp;
                                        <input type="checkbox" checked="checked" value="" name="is_free_shipping"/> 包邮&nbsp;&nbsp;
                                            <input type="checkbox" checked="checked" value="" name="is_recommend"/>推荐&nbsp;&nbsp;
                                            <input type="checkbox" checked="checked" value="" name="is_new"/>新品&nbsp;&nbsp;
                                        </td>
                                    </tr>
                                    -->
                                    <tr>
                                        <td>商品关键词:</td>
                                        <td>
                                            <input type="text" class="form-control" style="width:550px;" value=""
                                                   name="keywords"/>用空格分隔
                                            <span id="err_keywords" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>商品详情描述:</td>
                                        <td width="85%">
                                            <textarea rows="6" cols="80" class="span12 ckeditor" id="goods_content"
                                                      name="goodsContent" title=""></textarea>
                                            <span id="err_goods_content" style="color:#F00; display:none;"></span>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--其他信息-->

                            <!-- 商品相册-->
                            <div class="tab-pane" id="tab_goods_images">
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <form enctype="multipart/form-data">
                                                <input id="file-goods-images" class="file" name="file" type="file"
                                                       multiple
                                                       data-min-file-count="1">
                                            </form>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <!--商品相册-->

                            <!-- 商品模型-->
                            <div class="tab-pane" id="tab_goods_spec">
                                <input type="text" id="goodsAttrId"/>
                                <table class="table table-bordered" id="goods_spec_table">
                                    <tr>
                                        <td>商品模型:</td>
                                        <td>
                                            <select name="goods_type" id="spec_type" class="form-control"
                                                    style="width:250px;"
                                                    onchange="getSpecListAndAttributeList(this.value)">
                                                <option value="0">选择商品模型</option>
                                                <c:forEach items="${goodsTypeList}" var="goodsType">
                                                    <option value="${goodsType.id}">${goodsType.name}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </table>
                                <!-- ajax 返回属性-->
                                <div id="" class="col-xs-6" style="border:1px solid #ddd;"><br/>
                                    <table class="table table-bordered" id="goods_attr_table">
                                        <tr>
                                            <td>商品属性:</td>
                                            <td>
                                                <select id="attributeId" name="" class="form-control"
                                                        style="width:250px;"
                                                        onchange="getSpecValueOrAttributeValue(this.value,'attribute')">
                                                    <option value="0">选择商品属性</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="" class="col-xs-6" style="border:1px solid #ddd;height: 94px;"><br/>
                                    <table class="table table-bordered" id="goods_attr_table">
                                        <tr>
                                            <td>商品属性值:</td>
                                            <td>
                                                <select id="attributeValue" name="" class="form-control"
                                                        style="width:250px;" onchange="saveGoodsAttr('attribute')">
                                                    <option value="0">选择商品属性值</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <!-- ajax 返回规格-->
                                <div id="" class="col-xs-6" style="border:1px solid #ddd;"><br/>
                                    <table class="table table-bordered" id="goods_attr_table">
                                        <tr>
                                            <td>商品规格:</td>
                                            <td>
                                                <select id="specId" name="" class="form-control" style="width:250px;"
                                                        onchange="getSpecValueOrAttributeValue(this.value,'spec')">
                                                    <option value="0">选择商品规格</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="" class="col-xs-6" style="border:1px solid #ddd;height: 94px;"><br/>
                                    <table class="table table-bordered" id="goods_attr_table">
                                        <tr>
                                            <td>商品规格值:</td>
                                            <td>
                                                <select id="specValue" name="" class="form-control"
                                                        style="width:250px;" onchange="saveGoodsAttr('spec')">
                                                    <option value="0">选择商品规格值</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!-- 商品模型-->

                            <!-- 商品属性-->

                            <!-- 商品属性-->

                            <!-- 商品物流-->
                            <div class="tab-pane" id="tab_goods_shipping">
                                <h4><b>物流配送：</b><input type="checkbox" onclick="choosebox(this)">全选</h4>
                                <table class="table table-bordered table-striped dataTable" id="goods_shipping_table">
                                    <tr>
                                        <td class="title left" style="padding-right:50px;">
                                            <b>申通物流：</b>
                                            <label class="right"><input type="checkbox" value="1" cka="mod-0">全选</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="group-list">
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="24"
                                                                  ck="mod-0">全国其他地区</label></li>
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="37"
                                                                  ck="mod-0">珠三角地区</label></li>
                                                <div class="clear-both"></div>
                                            </ul>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="title left" style="padding-right:50px;">
                                            <b>顺丰物流：</b>
                                            <label class="right"><input type="checkbox" value="1" cka="mod-1">全选</label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <ul class="group-list">
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="25"
                                                                  ck="mod-1">全国其他地区</label></li>
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="35"
                                                                  ck="mod-1">珠三角地区</label></li>
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="36"
                                                                  ck="mod-1">长三角</label></li>
                                                <li><label><input type="checkbox" name="shipping_area_ids[]" value="38"
                                                                  ck="mod-1">全国一线城市</label></li>
                                                <div class="clear-both"></div>
                                            </ul>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <!-- 商品物流-->
                        </div>
                        <div class="pull-right">
                            <input type="text" id="goodsId" name="goodsId" value="">
                            <button class="btn btn-primary"
                                    onclick="ajax_submit_form('addEditGoodsForm','${ctx}/product/save','${ctx}/product/add','${ctx}/product/list');"
                                    title="" data-toggle="tooltip" type="button" data-original-title="保存">保存
                            </button>
                        </div>
                        <input type="hidden" name="__hash__"
                               value="4215372d5f63004790e1b9f4ed8df8b8_e74f2c0a9d3eff6e5b0e2ac8545e8177"/></form>
                    <!--表单数据-->
                </div>
            </div>
        </div>    <!-- /.content -->
    </section>
</div>
<script>
    $(document).ready(function () {
        $(":checkbox[cka]").click(function () {
            var $cks = $(":checkbox[ck='" + $(this).attr("cka") + "']");
            if ($(this).is(':checked')) {
                $cks.each(function () {
                    $(this).prop("checked", true);
                });
            } else {
                $cks.each(function () {
                    $(this).removeAttr('checked');
                });
            }
        });
    });

    function choosebox(o) {
        var vt = $(o).is(':checked');
        if (vt) {
            $('input[type=checkbox]').prop('checked', vt);
        } else {
            $('input[type=checkbox]').removeAttr('checked');
        }
    }
    /*
     * 以下是图片上传方法
     */
    // 上传商品图片成功回调函数
    function call_back(fileurl_tmp) {
        $("#original_img").val(fileurl_tmp);
        $("#original_img2").attr('href', fileurl_tmp);
    }

    // 上传商品相册回调函数
    function call_back2(paths) {

        var last_div = $(".goods_xc:last").prop("outerHTML");
        for (i = 0; i < paths.length; i++) {
            $(".goods_xc:eq(0)").before(last_div);	// 插入一个 新图片
            $(".goods_xc:eq(0)").find('a:eq(0)').attr('href', paths[i]).attr('onclick', '').attr('target', "_blank");// 修改他的链接地址
            $(".goods_xc:eq(0)").find('img').attr('src', paths[i]);// 修改他的图片路径
            $(".goods_xc:eq(0)").find('a:eq(1)').attr('onclick', "ClearPicArr2(this,'" + paths[i] + "')").text('删除');
            $(".goods_xc:eq(0)").find('input').val(paths[i]); // 设置隐藏域 要提交的值
        }
    }
    /*
     * 上传之后删除组图input     
     * @access   public
     * @val      string  删除的图片input
     */
    function ClearPicArr2(obj, path) {
        $.ajax({
            type: 'GET',
            url: "/index/Admin/Uploadify/delupload",
            data: {action: "del", filename: path},
            success: function () {
                $(obj).parent().remove(); // 删除完服务器的, 再删除 html上的图片
            }
        });
        // 删除数据库记录
        $.ajax({
            type: 'GET',
            url: "/index/Admin/Goods/del_goods_images",
            data: {filename: path},
            success: function () {
                //
            }
        });
    }


    /** 以下 商品属性相关 js*/

// 属性输入框的加减事件
    function addAttr(a) {
        var attr = $(a).parent().parent().prop("outerHTML");
        attr = attr.replace('addAttr', 'delAttr').replace('+', '-');
        $(a).parent().parent().after(attr);
    }
    // 属性输入框的加减事件
    function delAttr(a) {
        $(a).parent().parent().remove();
    }


    /*/!** 以下 商品规格相关 js*!/
     $(document).ready(function () {
     // 商品模型切换时 ajax 调用  返回不同的属性输入框
     $("#spec_type").change(function () {
     var goods_id = '';
     var spec_type = $(this).val();
     $.ajax({
     type: 'GET',
     data: {goods_id: goods_id, spec_type: spec_type},
     url: "/index/admin/Goods/ajaxGetSpecSelect",
     success: function (data) {
     $("#ajax_spec_data").html('')
     $("#ajax_spec_data").append(data);
     ajaxGetSpecInput();	// 触发完  马上触发 规格输入框
     }
     });
     //商品类型切换时 ajax 调用  返回不同的属性输入框
     $.ajax({
     type: 'GET',
     data: {goods_id: goods_id, type_id: spec_type},
     url: "/index/admin/Goods/ajaxGetAttrInput",
     success: function (data) {
     $("#goods_attr_table tr:gt(0)").remove()
     $("#goods_attr_table").append(data);
     }
     });
     });
     // 触发商品规格
     $("#spec_type").trigger('change');

     $("input[name='exchange_integral']").blur(function () {
     var shop_price = parseInt($("input[name='shop_price']").val());
     var exchange_integral = parseInt($(this).val());
     if (shop_price * 100 < exchange_integral) {

     }
     });
     });*/

    /* /!** 以下是编辑时默认选中某个商品分类*!/
     $(document).ready(function () {


     //  扩展分类

     });*/

</script>
<script type="text/javascript">
    /*商品图片上传--------begin--------*/
    /**
     * 初始设置
     * language指定语言
     * uploadUrl指定文件上传的后台地址
     * allowedPreviewTypes允许上传文件的类型
     */
    $('#file-product').fileinput({
        language: 'zh',
        uploadUrl: '${ctx}/fileUpload/save',
        allowedPreviewTypes: ['image', 'html', 'text', 'video', 'audio', 'flash']
    });
    /**
     * 上传文件失败后 调用方法（回调函数）
     */
    $('#file-product').on('fileuploaderror', function (event, data,
                                                       previewId, index) {
        var form = data.form,
            files = data.files,
            extra = data.extra,
            response = data.response,
            reader = data.reader;

        console.log(data);
        console.log('File upload error');
    });
    /**
     * 文件错误 比如文件类型错误 调用方法（回调函数）
     */
    $('#file-product').on('fileerror', function (event, data) {
        console.log(data.id);
        console.log(data.index);
        console.log(data.file);
        console.log(data.reader);
        console.log(data.files);
    });
    /**
     * 文件上传成功后 调用方法（回调函数）
     */
    $('#file-product').on('fileuploaded', function (event, data, previewId,
                                                    index) {
        var form = data.form,
            files = data.files,
            extra = data.extra,
            response = data.response,
            reader = data.reader;
        // 服务器文件地址
        console.log(data.response.fileUrl);
        $("#originalImg").val(data.response.fileUrl);
        console.log()
        console.log('File uploaded triggered');
    });
    /*商品图片上传--------end--------*/

    /*商品相册上传--------begin--------*/
    /**
     * 初始设置
     * language指定语言
     * uploadUrl指定文件上传的后台地址
     * allowedPreviewTypes允许上传文件的类型
     */
    $('#file-goods-images').fileinput({
        language: 'zh',
        uploadUrl: '${ctx}/product/goodsImages/save',
        allowedPreviewTypes: ['image', 'html', 'text', 'video', 'audio', 'flash'],
        // 文件上传插件提交额外参数
        uploadExtraData: function () {
            var goodsId = {"goodsId": $("#goodsId").val()};
            return goodsId;
        }
    });
    /**
     * 上传文件失败后 调用方法（回调函数）
     */
    $('#file-goods-images').on('fileuploaderror', function (event, data,
                                                            previewId, index) {
        var form = data.form,
            files = data.files,
            extra = data.extra,
            response = data.response,
            reader = data.reader;

        console.log(data);
        console.log('File upload error');
    });
    /**
     * 文件错误 比如文件类型错误 调用方法（回调函数）
     */
    $('#file-goods-images').on('fileerror', function (event, data) {
        console.log(data.id);
        console.log(data.index);
        console.log(data.file);
        console.log(data.reader);
        console.log(data.files);
    });
    /**
     * 文件上传成功后 调用方法（回调函数）
     */
    $('#file-goods-images').on('fileuploaded', function (event, data, previewId,
                                                         index) {
        var form = data.form,
            files = data.files,
            extra = data.extra,
            response = data.response,
            reader = data.reader;
        // 服务器文件地址
        console.log(data.response.fileUrl);
        // $("#originalImg").val(data.response.fileUrl);
        console.log()
        console.log('File uploaded triggered');
    });
    /*商品相册上传--------end--------*/
    /*检查商品id*/
    function checkGoods() {
        if (!$("#goodsId").val()) {
            layer.msg("请先保存商品信息!");
            $("#file-goods-images").attr("disabled", "true");
        } else {
            $("#file-goods-images").removeAttr("disabled");
        }
    }


    //根据选择的商品模型,获取相应的属性列表和规格列表
    function getSpecListAndAttributeList(typeId) {
        $("#goodsAttrId").val();
        $("#attributeValue").html("<option value='0'> 请选择商品属性值 </option> ");
        $("#specValue").html("<option value='0'> 请选择商品规格值 </option> ");
        //根据typeId查询属性列表
        $.ajax({
            url: "${ctx}/product/attributeListByTypeId",
            type: "GET",
            data:{
                typeId:typeId
            },
            dataType:"JSON",
            success: function (result) {
                var html = "<option value='0'>请选择商品属性</option> ";
                if (result) {
                    for (var i = 0; i < result.length; i++) {
                        html += "<option value=" + result[i].attrId + ">" + result[i].attrName + "</option> "
                    }
                    $("#attributeId").html(html);
                }
            },
            error: function (result) {
                layer.alert("亲,系统正在升级中,请稍后再试!")
            }

        });
        //根据typeId查询规格列表
        $.ajax({
            url: "${ctx}/product/specListByTypeId",
            type: "GET",
            data:{
                typeId:typeId
            },
            dataType:"JSON",
            success: function (result) {
                var html = "<option value='0'>请选择商品规格</option> ";
                if (result) {
                    for (var i = 0; i < result.length; i++) {
                        html += "<option value=" + result[i].specId + ">" + result[i].specName + "</option> "
                    }
                    $("#specId").html(html);
                }
            },
            error: function (result) {
                layer.alert("亲,系统正在升级中,请稍后再试!")
            }

        });
    }



    //根据属性id或属性id获取相应的属性值
    function getSpecValueOrAttributeValue(id, flag) {

        var url = "";
        var tip = "请选择商品";
        var msg = ["规格值", "属性值"];
        if ("spec" == flag) {
            url = "${ctx}/product/goodsSpecById";
            tip += msg[0];
            $("#"+flag+"Value").html("<option value='0'>" +tip+ "</option> ");
        } else if ("attribute" == flag) {
            url = "${ctx}/product/goodsAttributeById";
            tip += msg[1];
            $("#"+flag+"Value").html("<option value='0'>" +tip+ "</option> ");
        }

        if(id==0){
            return;
        }

        $.ajax({
            url: url,
            type: "GET",
            data: {id: id},
            dataType: "JSON",
            success: function (result) {

                var html = "<option value='0'>" + tip + "</option> ";
                if (result.value.length) {
                    for (var i = 0; i < result.value.length; i++) {
                        html += "<option value=" + result.id + ">" + result.value[i] + "</option> "
                    }
                    $("#"+flag+"Value").html(html);
                }
            },
            error: function (result) {
                layer.alert("获取商品规格值或属性值失败!")
            }

        });
    }
</script>
<script type="text/javascript">
    //保存属性值或规格值
    function saveGoodsAttr(flag) {
        if(!$("#goodsId").val()){
            layer.alert("请先保存商品通用信息!");
        }
        $.ajax({
            url: "${ctx}/product/attr/saveOrUpdate",
            type: "GET",
            data: {
                goodsAttrId: $("#goodsAttrId").val(),
                goodsId:$("#goodsId").val(),
                attrId:$("#attributeValue").val(),
                specId:$("#specValue").val(),
                value:$("#"+flag+"Value").find("option:selected").text(),
                flag:flag

            },
            dataType: "JSON",
            success: function (result) {
                if(200==result.code){
                    layer.alert("操作成功!");
                    $("#goodsAttrId").val(result.message)
                }else {
                    layer.alert("操作失败!");
                }

            },
            error: function (result) {
                layer.alert("亲,系统正在升级中,请稍后再试!");
            }

        });
    }
</script>
</body>
</html>