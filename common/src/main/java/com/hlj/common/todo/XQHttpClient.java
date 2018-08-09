package com.hlj.common.todo;

//import com.xiaomi.xiaoqiang.common.exception.XiaoQiangException;
//import com.xiaomi.xiaoqiang.common.utils.XQConstants;
//import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
//import org.apache.commons.httpclient.Header;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpMethod;
//import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
//import org.apache.commons.httpclient.cookie.CookiePolicy;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.RequestEntity;
//import org.apache.commons.httpclient.methods.StringRequestEntity;
//import org.apache.commons.httpclient.params.HttpClientParams;
//import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
//import org.apache.commons.httpclient.params.HttpConnectionParams;
//import org.apache.commons.httpclient.params.HttpMethodParams;
//import org.apache.commons.httpclient.protocol.Protocol;
//import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gongtianxiang(宫天翔) [gongtianxiang@xiaomi.com]
 * @author xielong(谢龙) [xielong@xiaomi.com]
 * @since 2013-12-3 下午02:37:43
 */
public class XQHttpClient {

    private static Logger logger = LoggerFactory.getLogger(XQHttpClient.class);

    private static final int CONNECT_TIMEOUT = 30 * 1000;
    private static final int SO_TIMEOUT = 30 * 1000;
    private static final int MAX_CON_PER_HOST = 100;

    private static final String DEFAULT_CHARSET = "UTF-8";

//    HttpClient client = null;
//
//    private MultiThreadedHttpConnectionManager connectionManager;
//
//    public XQHttpClient() {
//        this(MAX_CON_PER_HOST, CONNECT_TIMEOUT, SO_TIMEOUT);
//    }
//
//    public XQHttpClient(int maxConPerHost, int conTimeOutMs, int soTimeOutMs) {
//        connectionManager = new MultiThreadedHttpConnectionManager();
//        HttpConnectionManagerParams params = connectionManager.getParams();
//        params.setDefaultMaxConnectionsPerHost(maxConPerHost);
//        params.setConnectionTimeout(conTimeOutMs);
//        params.setSoTimeout(soTimeOutMs);
//
//        HttpClientParams clientParams = new HttpClientParams();
//        clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
//        client = new HttpClient(clientParams, connectionManager);
//        Protocol https = new Protocol("https", new XMSSLSocketFactory(), 443);
//        Protocol.registerProtocol("https", https);
//    }
//
//    public String get(String url) throws XiaoQiangException, URISyntaxException {
//        return get(url, new ArrayList<NameValuePair>(), new ArrayList<Header>());
//    }
//
//    public String get(String url,
//        List<NameValuePair> params) throws XiaoQiangException, URISyntaxException {
//        return get(url, params, new ArrayList<Header>());
//    }
//
//    public String get(String url,
//        List<NameValuePair> params,
//        List<Header> headers) throws XiaoQiangException {
//        URIBuilder uriBuilder;
//        try {
//            uriBuilder = new URIBuilder(url);
//            if (null != params && !params.isEmpty()) {
//                String qs = URLEncodedUtils.format(params, DEFAULT_CHARSET);
//                uriBuilder.setQuery(qs);
//            }
//        } catch (URISyntaxException e) {
//            logger.error(e.getMessage());
//            throw new XiaoQiangException(XQConstants.XQ_EXCEPTION.NET_ERROR.getCode(), XQConstants.XQ_EXCEPTION.NET_ERROR.getMessage());
//        }
//        GetMethod method = new GetMethod(uriBuilder.toString());
//        return httpRequest(method, headers);
//    }
//
//    public String post(String url) throws XiaoQiangException, URISyntaxException {
//        return post(url, new ArrayList<NameValuePair>(), new ArrayList<Header>(), null);
//    }
//
//    public String post(String url,
//        List<NameValuePair> params) throws XiaoQiangException, URISyntaxException {
//        return post(url, params, new ArrayList<Header>(), null);
//    }
//
//    public String post(String url,
//        List<NameValuePair> params,
//        List<Header> headers,
//        String postBody) throws XiaoQiangException {
//
//
//        URIBuilder uriBuilder;
//        try {
//            uriBuilder = new URIBuilder(url);
//            if (!params.isEmpty()) {
//                String qs = URLEncodedUtils.format(params, DEFAULT_CHARSET);
//                uriBuilder.setQuery(qs);
//            }
//        } catch (URISyntaxException e) {
//            logger.error(e.getMessage());
//            throw new XiaoQiangException(XQConstants.XQ_EXCEPTION.NET_ERROR.getCode(), XQConstants.XQ_EXCEPTION.NET_ERROR.getMessage());
//        }
//
//        PostMethod method = new PostMethod(uriBuilder.toString());
//
//        if (StringUtils.isNotBlank(postBody)){
//            RequestEntity requestEntity;
//            try {
//                requestEntity = new StringRequestEntity(postBody, "application/json", DEFAULT_CHARSET);
//                method.setRequestEntity(requestEntity);
//            } catch (UnsupportedEncodingException e) {
//                logger.error(e.getMessage());
//            }
//        }
//        return httpRequest(method, headers);
//    }
//
//    protected String httpRequest(HttpMethod method, List<Header> headers) throws XiaoQiangException {
//        int responseCode;
//        try {
//            if (null != headers && !headers.isEmpty()) {
//                client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
//            }
//            method.getParams().setContentCharset(DEFAULT_CHARSET);
//            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(2, false));
//            client.executeMethod(method);
//            responseCode = method.getStatusCode();
//            String response = method.getResponseBodyAsString();
//            // 301 => "HTTP/1.1 301 Moved Permanently",
//            // 302 => "HTTP/1.1 302 Found",
//            // 303 => "HTTP/1.1 303 See Other",
//            // 307 => "HTTP/1.1 307 Temporary Redirect",
//            if (responseCode != 200 && responseCode != 301
//                && responseCode != 302 && responseCode != 303 && responseCode != 307) {
//                throw new XiaoQiangException(XQConstants.XQ_EXCEPTION.NET_ERROR.getCode(), "Http Error Code:" + responseCode);
//            }
//            //替换头部的&&&START&&&
//            response = response.replace("&&&START&&&", "");
//            return response;
//        } catch (IOException e) {
//            logger.error("Failed to excute method", e);
//            throw new XiaoQiangException(XQConstants.XQ_EXCEPTION.NET_ERROR.getCode(), XQConstants.XQ_EXCEPTION.NET_ERROR.getMessage());
//        } finally {
//            method.releaseConnection();
//        }
//    }
//
//    private static class XMSSLSocketFactory implements ProtocolSocketFactory {
//        private SSLContext sslcontext = null;
//
//        private SSLContext createSSLContext() {
//            SSLContext sslcontext = null;
//            try {
//                sslcontext = SSLContext.getInstance("SSL");
//                sslcontext.init(null, new TrustManager[] {
//                    new TrustAnyTrustManager()
//                }, new java.security.SecureRandom());
//            } catch (NoSuchAlgorithmException e) {
//                logger.error(e.getMessage());
//            } catch (KeyManagementException e) {
//                logger.error(e.getMessage());
//            }
//            return sslcontext;
//        }
//
//        private SSLContext getSSLContext() {
//            if (this.sslcontext == null) {
//                this.sslcontext = createSSLContext();
//            }
//            return this.sslcontext;
//        }
//
//        public Socket createSocket(String host, int port) throws IOException {
//            return getSSLContext().getSocketFactory().createSocket(host, port);
//        }
//
//        public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException {
//            return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
//        }
//
//        public Socket createSocket(String host,
//            int port,
//            InetAddress localAddress,
//            int localPort,
//            HttpConnectionParams params) throws IOException {
//            if (params == null) {
//                throw new IllegalArgumentException("Parameters may not be null");
//            }
//            int timeout = params.getConnectionTimeout();
//            SocketFactory socketfactory = getSSLContext().getSocketFactory();
//            if (timeout == 0) {
//                return socketfactory.createSocket(host, port, localAddress, localPort);
//            } else {
//                Socket socket = socketfactory.createSocket();
//                socket.bind(new InetSocketAddress(localAddress, localPort));
//                socket.connect(new InetSocketAddress(host, port), timeout);
//                return socket;
//            }
//        }
//
//        private static class TrustAnyTrustManager implements X509TrustManager {
//            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//            }
//
//            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//            }
//
//            public X509Certificate[] getAcceptedIssuers() {
//                return new X509Certificate[] {};
//            }
//        }
//    }
}
