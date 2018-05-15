package com.github.kotall.weixin.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : aracwong
 * @version : 1.0.0
 * @date : 2018/4/26 0026 下午 9:03
 */
public class HttpClientUtil {

    private static HttpClient httpClient;

    private HttpClientUtil() {
    }


    public static synchronized HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClients.createDefault();
        }
        return httpClient;
    }


    /**
     * Post 请求
     *
     * @param url
     * @param postEntity
     * @return
     */
    public static String post(String url, String postEntity) {
        try {
            // 创建POST请求
            HttpPost httpPost = new HttpPost(url);
            if (postEntity != null) {
                StringEntity entity = new StringEntity(postEntity, Charset.forName("UTF-8"));
                httpPost.setEntity(entity);
            }

            // 发送请求
            HttpClient client = getHttpClient();
            HttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("请求失败");
            }

            HttpEntity resEntity = response.getEntity();
            ContentType contentType = ContentType.getOrDefault(resEntity);
            Charset charset = contentType.getCharset();
            return (resEntity == null) ? null : EntityUtils.toString(resEntity, charset);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (ClientProtocolException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException("连接失败", e);
        }

    }

    /**
     * Get 请求
     *
     * @param url
     * @param queryParam
     * @return
     */
    public static String get(String url, String queryParam) {
        String question_mark = "?";
        HttpClient httpclient = getHttpClient();
        try {
            if (queryParam != null) {
                if (url.indexOf(question_mark) == -1) {
                    url += question_mark;
                }
                url += url.endsWith(question_mark) ? queryParam : '&' + queryParam;
            }
            // 设置请求和传输超时时间

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000).setSocketTimeout(5000).build();
            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(requestConfig);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity httpEntity = response.getEntity();
            ContentType contentType = ContentType.getOrDefault(httpEntity);
            Charset charset = contentType.getCharset();
            if (httpEntity != null) {
                return EntityUtils.toString(httpEntity, charset);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("请求失败", e);
        }
    }

    /**
     * 上传文件
     * @param url
     * @param filePath
     * @param fileFieldName
     * @param parameters
     * @return
     */
    public String upload(String url, String filePath, String fileFieldName, Map<String, Object> parameters) {
        File file = new File(filePath);
        HttpPost httpPost = new HttpPost(url);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        if (null != parameters) {
            parameters.forEach((name, value) -> {
                builder.addPart(name, new StringBody(value.toString(), ContentType.create("text/plain", Consts.UTF_8)));
            });
        }

        builder.addPart(fileFieldName, new FileBody(file));
        HttpEntity reqEntity = builder.build();
        httpPost.setEntity(reqEntity);

        String rs = "";
        try {
            HttpResponse response = getHttpClient().execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (null != httpEntity) {
                rs = EntityUtils.toString(httpEntity, Consts.UTF_8);
                EntityUtils.consume(httpEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    /**
     * 下载文件
     * @param url
     * @param fileStorePath
     * @param parameters
     * @return
     */
    public String download(String url, String fileStorePath, Map<String, String> parameters) {
        HttpGet httpGet = new HttpGet(url);

        if (null != parameters) {
            parameters.forEach((name, value) -> httpGet.addHeader(name, value));
        }

        try {
            HttpResponse httpResponse = getHttpClient().execute(httpGet);

            HttpEntity httpEntity = httpResponse.getEntity();
            long length = httpEntity.getContentLength();
            if (length <= 0) {
                return "";
            }

            InputStream is;
            OutputStream os;

            is = httpEntity.getContent();

            File localFile = new File(fileStorePath);
            if (!localFile.exists()) {
                localFile.createNewFile();
            }

            os = new FileOutputStream(localFile);
            byte[] buffer = new byte[4096];
            int readLength;
            while ((readLength = is.read(buffer)) > 0) {
                byte[] bytes = new byte[readLength];
                System.arraycopy(buffer, 0, bytes, 0, readLength);
                os.write(bytes);
            }

            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ok";
    }

}
