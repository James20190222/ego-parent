<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<div id="s_cart">
    <ul>
        <li class="nums">
            <a href="${ctx}/cart/getCartList" id="s_cart_nums1">购物车： <span id="cartSpan">0</span> 件</a>
            <a href="" class="btn"id="s_cart_nums2"></a>
        </li>
        <li class="checkout">
            <a href="${ctx}/cart/getCartList">去结算>></a>
        </li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        getCartNum();
    })
    //获取用户购物车商品数量
    function getCartNum() {
        $.ajax({
            url: '${ctx}/cart/getCartNum',
            type: 'POST',
            success: function (result) {
                $("#cartSpan").text(result);
            },
            error: function (result) {
                console.log(result);
                layer.alert("亲,系统正在升级中,请稍后再试!");
            }
        })
    }
    
    //商品添加购物车
    function addToCart(goodsId,goodsName,originalImg,marketPrice) {
        $.ajax({
            url: '${ctx}/cart/addToCart',
            type: 'POST',
            data:{
                goodsId:goodsId,
                goodsName:goodsName,
                originalImg:originalImg,
                marketPrice:marketPrice,
                goodsNum:1
            },
            dataType:"JSON",
            success: function (result) {
                if(200==result.code){
                    layer.msg("添加购物车成功!");
                    var num=parseInt($("#cartSpan").text())+1;
                    console.log(num);
                    $("#cartSpan").text(num);
                }else {
                    layer.msg("添加购物车失败,请重试")
                }
            },
            error: function (result) {
                if(200==result.status && "OK"==result.statusText){
                    window.location.href="${ctx}/login";
                }else {
                    layer.alert("亲,系统正在升级中,请稍后再试!");
                }
            }
        })
    }
    
</script>