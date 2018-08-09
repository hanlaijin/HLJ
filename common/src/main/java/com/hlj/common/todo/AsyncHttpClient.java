package com.hlj.common.todo;

//import com.xiaomi.common.perfcounter.PerfCounter;
//import com.xiaomi.common.perfcounter.common.Tag;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.ConnectionPool;
//import okhttp3.Dispatcher;
//import okhttp3.HttpUrl;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//import org.apache.commons.collections.MapUtils;
//import org.apache.commons.httpclient.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xuyincheng@xiaomi.com
 */
public class AsyncHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(AsyncHttpClient.class);

    public static final int    DEFAULT_MAX_REQUESTS = 32;
    public static final int    DEFAULT_MAX_IDLE_CONNECTIONS = 32;
    public static final long   DEFAULT_TIMEOUT_IN_MS = 3000;
    public static final int    DEFAULT_KEEP_ALIVE_DURATION = 1; // in minutes
    public static final String DEFAULT_MEDIA_TYPE = "x-application/octet-stream";

    private static final long HTTP_CLIENT_TTL = 300000;

//    private OkHttpClient httpClient;
//
//    private static long lastCreationTime = 0;
//
//    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
//
//    private String host;
//    private long timeoutInMS;
//    private int maxIdleConnections;
//    private int maxRequests;
//
//    private boolean counterInit = false;
//    private String metricName2xx;
//    private String metricName3xx;
//    private String metricName4xx;
//    private String metricName5xx;
//    private String metricNameOther;
//    private String metricNameError;
//
//    public AsyncHttpClient(String host) {
//        this(host, DEFAULT_TIMEOUT_IN_MS);
//    }
//
//    public AsyncHttpClient(String host, long timeoutInMS) {
//        this(host, timeoutInMS, DEFAULT_MAX_REQUESTS);
//    }
//
//    public AsyncHttpClient(String host, long timeoutInMS, int maxRequests) {
//        this(host, timeoutInMS, maxRequests, DEFAULT_MAX_IDLE_CONNECTIONS);
//    }
//
//    public AsyncHttpClient(String host, long timeoutInMS, int maxRequests, int maxIdleConnections) {
//        if (!host.startsWith("http://") && !host.startsWith("https://")) {
//            host = "http://" + host;
//        }
//        this.host = host;
//        this.timeoutInMS = timeoutInMS;
//        this.maxIdleConnections = maxIdleConnections;
//        this.maxRequests = maxRequests;
//        createClient();
//    }
//
//    public String getHost() {
//        return host;
//    }
//
//    public OkHttpClient createClient() {
//        OkHttpClient localClient = httpClient;
//        if (System.currentTimeMillis() > lastCreationTime + HTTP_CLIENT_TTL) {
//            httpClient = null;
//        }
//        if (localClient != null) {
//            return localClient;
//        }
//        synchronized (this) {
//            if (httpClient != null) {
//                return httpClient;
//            }
//            try {
//                // Create a trust manager that does not validate certificate chains
//                final TrustManager[] trustAllCerts = new TrustManager[] {new TrustAllX509TrustManager()};
//                // Install the all-trusting trust manager
//                final SSLContext sslContext = SSLContext.getInstance("SSL");
//                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
//                // Create an ssl socket factory with our all-trusting manager
//                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
//                OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
//                Dispatcher dispatcher = new Dispatcher();
//                dispatcher.setMaxRequests(maxRequests);
//                dispatcher.setMaxRequestsPerHost(maxRequests);
//                httpClient = builder
//                    .connectTimeout(timeoutInMS, TimeUnit.MILLISECONDS)
//                    .readTimeout(timeoutInMS, TimeUnit.MILLISECONDS)
//                    .writeTimeout(timeoutInMS, TimeUnit.MILLISECONDS)
//                    .hostnameVerifier(new HostnameVerifier() {
//                        @Override
//                        public boolean verify(String s, SSLSession sslSession) {
//                            return true;
//                        }
//                    })
//                    .connectionPool(
//                        new ConnectionPool(maxIdleConnections, DEFAULT_KEEP_ALIVE_DURATION, TimeUnit.MINUTES)
//                    )
//                    .dispatcher(dispatcher)
//                    .build();
//                lastCreationTime = System.currentTimeMillis();
//                if (!counterInit) {
//                    metricName2xx = "async-http-client-2xx-" + host;
//                    metricName3xx = "async-http-client-3xx-" + host;
//                    metricName4xx = "async-http-client-4xx-" + host;
//                    metricName5xx = "async-http-client-5xx-" + host;
//                    metricNameOther = "async-http-client-other-" + host;
//                    metricNameError = "async-http-client-error-" + host;
//                    PerfCounter.setTag(metricName2xx, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "ok").build());
//                    PerfCounter.setTag(metricName3xx, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "other").build());
//                    PerfCounter.setTag(metricName4xx, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "other").build());
//                    PerfCounter.setTag(metricName5xx, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "other").build());
//                    PerfCounter.setTag(metricNameOther, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "other").build());
//                    PerfCounter.setTag(metricNameError, new Tag.TagBuilder().put("xq-screen", "async-http-client").put("status", "error").build());
//                    counterInit = true;
//                }
//                return httpClient;
//            } catch (Exception e) {
//                logger.error("Hit an error.", e);
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public void execute(Request request, final Callback callback) {
//        logger.debug("HTTP, request: {}", request);
//        executeWithRetry(request, callback, 1);
//    }
//
//    public void get(String uri,
//                    Map<String, String> params,
//                    List<NameValuePair> headers,
//                    Callback callback) {
//        get(uri, params, headers, callback, 1);
//    }
//
//    public void get(String uri,
//                    Map<String, String> params,
//                    List<NameValuePair> headers,
//                    Callback callback,
//                    int maxTry) {
//        Request.Builder requestBuilder = new Request.Builder();
//        requestBuilder.get();
//        HttpUrl httpUrl = HttpUrl.parse(host + uri);
//        HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();
//        if (params != null) {
//            for (Map.Entry<String, String> entry : params.entrySet()) {
//                httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
//            }
//        }
//        httpUrl = httpUrlBuilder.build();
//        requestBuilder.url(httpUrl);
//        if (headers != null) {
//            for (NameValuePair pair : headers) {
//                requestBuilder.addHeader(pair.getName(), pair.getValue());
//            }
//        }
//        executeWithRetry(requestBuilder.build(), callback, maxTry);
//    }
//
//    public void post(String uri,
//                     Map<String, String> params,
//                     List<NameValuePair> headers,
//                     Callback callback) {
//        post(uri, params, headers, callback, 1);
//    }
//
//    public void post(String uri,
//                     Map<String, String> params,
//                     List<NameValuePair> headers,
//                     Callback callback,
//                     int maxTry) {
//        String content;
//        try {
//            content = encodeParams(params);
//        } catch (Throwable t) {
//            callback.onFailure(null, new IOException("encode error"));
//            return;
//        }
//        post(uri, "application/x-www-form-urlencoded", content, headers, callback, maxTry);
//    }
//
//    public void post(String uri,
//                     String content,
//                     List<NameValuePair> headers,
//                     Callback callback) {
//        post(uri, content, headers, callback, 1);
//    }
//
//    public void post(String uri,
//                     String content,
//                     List<NameValuePair> headers,
//                     Callback callback,
//                     int maxTry) {
//        post(uri, "x-application/octet-stream", content, headers, callback, maxTry);
//    }
//
//    public void post(String uri,
//                     String mediaType,
//                     String content,
//                     List<NameValuePair> headers,
//                     Callback callback) {
//        post(uri, mediaType, content, headers, callback, 1);
//    }
//
//    public void post(String uri,
//                     String mediaType,
//                     String content,
//                     List<NameValuePair> headers,
//                     Callback callback,
//                     int maxTry) {
//        Request.Builder requestBuilder = new Request.Builder();
//        requestBuilder.get();
//        HttpUrl httpUrl = HttpUrl.parse(host + uri);
//        requestBuilder.url(httpUrl);
//        if (headers != null) {
//            for (NameValuePair pair : headers) {
//                requestBuilder.addHeader(pair.getName(), pair.getValue());
//            }
//        }
//        if (content == null) {
//            content = "";
//        }
//        RequestBody requestBody = RequestBody.create(
//            MediaType.parse(mediaType), content
//        );
//        requestBuilder.post(requestBody);
//        executeWithRetry(requestBuilder.build(), callback, maxTry);
//    }
//
//    public void postWithUrl(String url,
//                            String mediaType,
//                            String content,
//                            List<NameValuePair> headers,
//                            Callback callback,
//                            int maxTry) {
//        Request.Builder requestBuilder = new Request.Builder();
//        requestBuilder.get();
//        HttpUrl httpUrl = HttpUrl.parse(url);
//        requestBuilder.url(httpUrl);
//        if (headers != null) {
//            for (NameValuePair pair : headers) {
//                requestBuilder.addHeader(pair.getName(), pair.getValue());
//            }
//        }
//        if (content == null) {
//            content = "";
//        }
//        RequestBody requestBody = RequestBody.create(
//            MediaType.parse(mediaType), content
//        );
//        requestBuilder.post(requestBody);
//        executeWithRetry(requestBuilder.build(), callback, maxTry);
//    }
//
//    private String encodeParams(Map<String, String> params) throws UnsupportedEncodingException {
//        if (MapUtils.isEmpty(params)) {
//            return "";
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        boolean isFirst = true;
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            if (!isFirst) {
//                stringBuilder.append('&');
//            }
//            isFirst = false;
//            stringBuilder.append(entry.getKey())
//                .append('=')
//                .append(URLEncoder.encode(entry.getValue(), "UTF-8"));
//        }
//        return stringBuilder.toString();
//    }
//
//    public void executeWithRetry(final Request request, final Callback callback, final int maxTry) {
//        final long start = System.currentTimeMillis();
//        OkHttpClient localHttpClient = createClient();
//        final Call call = localHttpClient.newCall(request);
//        final AtomicBoolean finished = new AtomicBoolean(false);
//        scheduledThreadPool.schedule(
//            new Runnable() {
//                @Override
//                public void run() {
//                    if (finished.get()) {
//                        return;
//                    }
//                    finished.set(true);
//                    call.cancel();
//                    long elapse = System.currentTimeMillis() - start;
//                    PerfCounter.count(metricNameError, 1, elapse);
//                    callback.onFailure(call, new IOException("request timeout"));
//                }
//            },
//            timeoutInMS,
//            TimeUnit.MILLISECONDS
//        );
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                if (finished.get()) {
//                    return;
//                }
//                finished.set(true);
//                if (maxTry - 1 > 0) {
//                    executeWithRetry(request, callback, maxTry - 1);
//                } else {
//                    if (counterInit) {
//                        long elapse = System.currentTimeMillis() - start;
//                        PerfCounter.count(metricNameError, 1, elapse);
//                    }
//                    callback.onFailure(call, e);
//                }
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (finished.get()) {
//                    return;
//                }
//                finished.set(true);
//                if (counterInit) {
//                    long elapse = System.currentTimeMillis() - start;
//                    int code = response.code();
//                    String metricName = metricNameOther;
//                    if (code >= 200) {
//                        if (code < 300) {
//                            metricName = metricName2xx;
//                        } else if (code < 400) {
//                            metricName = metricName3xx;
//                        } else if (code < 500) {
//                            metricName = metricName4xx;
//                        } else if (code < 600) {
//                            metricName = metricName5xx;
//                        }
//                    }
//                    PerfCounter.count(metricName, 1, elapse);
//                }
//                callback.onResponse(call, response);
//            }
//        });
//    }

    static class TrustAllX509TrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
            throws CertificateException {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
            throws CertificateException {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[]{};
        }
    }
}
