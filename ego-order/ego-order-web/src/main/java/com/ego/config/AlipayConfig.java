package com.ego.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 * 类名： AlipayConfig
 * 功能：基础配置类

 * 详细：设置帐户有关信息及返回路径

 * 修改日期： 2017-04-05
 * 说明：

 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写 , 并非一定要使用该代码。

 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓ 请在这里配置您的基本信息 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 

    // 应用 ID, 您的 APPID ，收款账号既是您的 APPID对应支付宝账号
    public static String app_id = "2016093000632263";

    // 商户私钥，您的 PKCS8格式 RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCqeLN2l4cSEF759LPyjXjb53I+cA8gchigSSw8wlJCTRhGNwt5eIkWJ1/jXSvWzWYOajmDkmalP/o0Sm66wSxphh9Y36ywS9q+Ae7ns+k+b8AF6TOAxknuN9N13R9rxyOiRaYKf4AHcbH82lBZ4k/R8ISCnKQXjJMXaWyxNaLerbQTaVXmfZX49DP09efNiC1B6cfHRi/KtlkAfcmEdYnVE/qkivwG4ptBt+Lx48wnHpP9tuyD3Hf7J4zCH7ZXJCCxn0lRY5jJ6YLPSnbSTufVfj1IpjaNp175ptYkP/FmsFLSgEmoLl9Zncxr5RrqDgFnNZTyix1zw4oOI6QZkAMvAgMBAAECggEALHV2OIOkUm26l23eUG/dCVz/SpFnIIshKQxsYRw839XDcuyALZnmBsUWGPH/sPG4oCHMBih0ZLyewGx5HHOs5Yh5PHB5VTEzR0Kxz/P37LSwW9pJ+Fe+iEY+/ApDW5SAEp4fg7Vk6owYY118fzSqpJIZvQalNQ8QfZadJkpaw8AUkgMrjgtsitfxH+Xh7eziKRIrAZLUii4oq2TaicTam4PFk5Rh1EFWlJX/qu68p/At9vZkYycrbMq0AIWJjbWF/xVLZIt7mCJwTXuZ/qC8GAOMFSY7bax0kaX8XF2/BtwYA3xi3KUVVQ8NMCHD444/3Mx3eqAhKJYGB1LoFUn2QQKBgQDbaoPAAOjwXTqkT7fgmqazd8nxzVknojTyphFogJCX8DbhUY4dSi+mbbHyTjQkyGLu6F4W5H9w4dJfnHO5hWf2xWe7hWWA2ItA+HqhiQGnIZim9+zvI592Q/8JxGJBhxKAe5syyeXqYe6xhDZWq8NeSDPfkn9BBA8p6Yh/TH4nhwKBgQDG5Q0pzI2ZO49xsT1IJS3NGLkG/MYthxCLajeRgP9rggjgqHOXu6IUMVshNpyrC2JZTwk47pKMs4MObKS1Dp5VHAlioiGtueuFXCziA5WVpTlXZfUfGG8K08/39FqcVVrboccZP9Gu/T//DwABc+FDKGhkVD/tUg+UuYfr0pxhGQKBgQCU8PXkNPnqh+6RsQeJsJEuTEdKG3HEpKg6ep5giL0eVlJ6msjUexJjcB0V9R4SRfBaamPMOGmF79TFUEeCDNvouFHVChU/5D6K6OEdnAoCMJ0V4j/0iQLq3fdW4vcrsgvOKZnNXR3z/2xvFedo6Amji3Gi9yfos1+zvLIKb5tHKwKBgDHt5jQMCa/h58yetcearbjC8A/0/LsJIPoem/yG6ZfPePMM1pfMno97JGleEE5P+Ux6LtJ/8YIovkmstFxPYyfyddiw4st91MYRsaK7S53ZcF+kVLiNpbKOIbMZQHXmZ3yjTBvmjXjkUmBxH4s9z9rQFgS5saKd6xNmz9w/bsphAoGATCHTWysCpg/0esXImSY610zEjeDeRlvzbNO5CgDhQYvQeSZvnDCEP83EXZQvfc4+8CgsMG+eeXDqbDXweUiQT6HDK213tCSoOneaIee9rhav+Nyh27hQiBKZGUpFYI43gPk8JpJ9cLhcTPezlG7EUrCwpeTDalNuMnRyeG+snj0=";

    // 支付宝公钥 , 查看地址： https://openhome.alipay.com/platform/keyManage.htm 对应 APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqnizdpeHEhBe+fSz8o142+dyPnAPIHIYoEksPMJSQk0YRjcLeXiJFidf410r1s1mDmo5g5JmpT/6NEpuusEsaYYfWN+ssEvavgHu57PpPm/ABekzgMZJ7jfTdd0fa8cjokWmCn+AB3Gx/NpQWeJP0fCEgpykF4yTF2lssTWi3q20E2lV5n2V+PQz9PXnzYgtQenHx0YvyrZZAH3JhHWJ1RP6pIr8BuKbQbfi8ePMJx6T/bbsg9x3+yeMwh+2VyQgsZ9JUWOYyemCz0p20k7n1X49SKY2jade+abWJD/xZrBS0oBJqC5fWZ3Ma+Ua6g4BZzWU8osdc8OKDiOkGZADLwIDAQAB";

    // 服务器异步通知页面路径  需 http:// 格式的完整路径，不能加 ?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://gx86jh.natappfree.cc/ego-portal-web/order/callBack";

    // 页面跳转同步通知页面路径 需 http:// 格式的完整路径，不能加 ?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9091/ego-portal-web/";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志路径
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑ 请在这里配置您的基本信息 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ 

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）      *
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 