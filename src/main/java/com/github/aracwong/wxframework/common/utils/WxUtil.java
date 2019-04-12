package com.github.aracwong.wxframework.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.aracwong.wxframework.mp.exception.WxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 微信请求工具类
 *
 * @author zpwang
 * @version 1.0.0
 */
public class WxUtil {

    /**
     * GET 请求
     *
     * @param url
     *      请求地址
     * @return 响应 json对象
     */
    public static JSONObject get(String url) throws WxException {
        // 1.建立HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 2.建立Get请求
        HttpGet get = new HttpGet(url);
        // 3.发送Get请求
        try {
            CloseableHttpResponse res = client.execute(get);
            // 4.处理请求结果
            return handleHttpResponse(res);
        } catch (IOException e) {
            throw new WxException(e);
        }
    }

    /**
     * POST 请求
     *
     * @param url
     *       请求地址
     * @param data
     *       请求数据
     * @return 响应 json对象
     */
    public static JSONObject post(String url, String data) throws WxException {
        // 1.建立HttpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        // 2.建立Get请求
        HttpPost post = new HttpPost(url);

        StringEntity stringEntity = new StringEntity(data, Charset.forName("UTF-8"));
        stringEntity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        stringEntity.setContentType("application/json");
        post.setEntity(stringEntity);
        // 3.发送POST请求
        try {
            CloseableHttpResponse res = client.execute(post);
            // 4.处理请求结果
            return  handleHttpResponse(res);
        } catch (IOException e) {
            throw new WxException(e);
        }
    }

    /**
     * 处理微信响应
     * @param res
     *        响应
     * @return
     *        Json对象
     * @throws IOException IOException
     */
    private static JSONObject handleHttpResponse(CloseableHttpResponse res) throws IOException {
        JSONObject rs = null;
        if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = res.getEntity();
            ContentType contentType = ContentType.getOrDefault(entity);
            Charset charset = contentType.getCharset();
            // 获取字节数组
            byte[] content = EntityUtils.toByteArray(entity);
            if (charset == null) {
                // 默认编码转成字符串
                String temp = new String(content);
                String regEx = "(?=<meta).*?(?<=charset=[\\'|\\\"]?)([[a-z]|[A-Z]|[0-9]|-]*)";
                Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(temp);
                if (m.find() && m.groupCount() == 1) {
                    charset = Charset.forName(m.group(1));
                } else {
                    charset = Charset.forName("UTF-8");
                }
            }
            rs = JSONObject.parseObject(new String(content, charset));
        }
        return rs;
    }

    /**
     *
     * @param data
     *        xml 字符串
     * @return
     *        map对象
     * @throws Exception
     *        Exception
     */
    public static Map<String, String> parseToMap(String data) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<>(1);

        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(data));
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }

        return map;
    }


    public static void main(String[] args) throws WxException {
        String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        String appid = "wxd23854d784085be10";
        String appsecret = "d4624c36b6795d1d99dcf0547af5443f";
        String requestUrl = WX_ACCESS_TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject rs = WxUtil.get(requestUrl);
        System.out.println(rs.toJSONString());
    }

}
