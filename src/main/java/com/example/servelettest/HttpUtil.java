
package com.example.servelettest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 陈金虎 2017年1月16日 下午11:41:47
 * @类描述：http请求工具
 * @注意：本内容仅限于杭州霖梓网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@SuppressWarnings("deprecation")

public class HttpUtil {


    public static final int cache = 10 * 1024;
    public static final int DEFULT_TIMEOUT = 10 * 1000;
    public static final int DEFULT_READ_TIMEOUT = 20 * 1000;

    private static URLConnection getConn(URL realUrl, int timeout) {
        try {
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(DEFULT_READ_TIMEOUT);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            return conn;
        } catch (Exception e) {
            System.out.println("创建连接失败 url " + realUrl.getPath());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行GET请求
     *
     * @param url     url
     * @param timeout 毫秒
     * @return
     */
    public static String doGet(String url, int timeout) {
        System.out.println("doGet url = {}" + url);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl, timeout);
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送失败 url " + url);
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("doGet result = {}" + result);
        return result;
    }

    /**
     * 执行GET请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String doPost(String url, String param) {
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl, DEFULT_TIMEOUT);
            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送失败 url " + url);
            e.printStackTrace();
            return "";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 发送POST请求，将参数放置到BODY里边
     *
     * @param url
     * @param param
     * @return
     */
    public static String doHttpPost(String url, String param) {
        System.out.println("oHttpPost begin url =  " + url + ",param = " + param);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl, DEFULT_TIMEOUT);
            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送失败 url " + url);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("doHttpPost result = " + result);
        return result;
    }

    /**
     * 发送POST请求，将参数放置到BODY里边
     *
     * @param url
     * @param param
     * @return
     */
    public static String doHttpPost2(String url, String param) {
        System.out.println("doHttpPost begin url = " + url + " param = " + param);
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(DEFULT_READ_TIMEOUT);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送失败 url " + url);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("doHttpPost result = " + result);
        return result;
    }

    /**
     * <b>功能描述:</b>
     *
     * @param reqUrl
     * @param parameters
     * @param recvEncoding
     * @return java.lang.String
     * <b>修改历史:</b>(修改人,修改时间,修改原因/内容)
     * @author : chenruhui
     * <b>创建日期 :</b>
     * @date 2018/10/30 10:42
     */
    public static String doHttpPost(String reqUrl, Map parameters, String recvEncoding) {
        HttpURLConnection urlCon = null;
        String responseContent = null;
        try {
            StringBuffer params = new StringBuffer();
            Iterator iter = parameters.entrySet().iterator();
            while (iter
                    .hasNext()) {
                Map.Entry element = (Map.Entry) iter.next();
                params.append(element.getKey().toString());
                params.append("=");
                params.append(URLEncoder.encode(element.getValue().toString(),
                        "UTF-8"));
                params.append("&");
            }
            if (params.length() > 0) {
                params = params.deleteCharAt(params.length() - 1);
            }
            URL url = new URL(reqUrl);
            urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setRequestMethod("POST");
            System.setProperty("sun.net.client.defaultConnectTimeout",
                    String.valueOf(5000));
            System.setProperty("sun.net.client.defaultReadTimeout",
                    String.valueOf(10000));

            urlCon.setDoOutput(true);
            byte[] b = params.toString().getBytes();
            urlCon.getOutputStream().write(b, 0, b.length);
            urlCon.getOutputStream().flush();
            urlCon.getOutputStream().close();

            InputStream in = urlCon.getInputStream();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(in,
                            recvEncoding));
            String tempLine = rd.readLine();
            StringBuilder tempStr = new StringBuilder();
            String crlf = System.getProperty("line.separator");
            while (tempLine != null) {
                tempStr.append(tempLine);
                tempStr.append(crlf);
                tempLine = rd.readLine();
            }
            responseContent = tempStr.toString();
            rd.close();
            in.close();
        } catch (IOException e) {
            System.out.println("发送失败 url  = " + reqUrl);
            e.printStackTrace();
        } finally {
            if (urlCon != null) {
                urlCon.disconnect();
            }
        }
        return responseContent;
    }

    /**
     * 发送POST请求，将参数放置到BODY里边
     *
     * @param url
     * @param param
     * @return
     */
    public static String doHttpPostJsonParam(String url, String param) {
        BufferedReader in = null;
        OutputStreamWriter out = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConn(realUrl, DEFULT_TIMEOUT);
            conn.setRequestProperty("content-type", "application/json");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");

            out = new OutputStreamWriter(conn.getOutputStream());
            // 把数据写入请求的Body
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送失败 url " + url);
            e.printStackTrace();
        } finally {
            System.out.println(" url = " + url + " ,param = " + param + ",响应结果 result =   ");
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


}

