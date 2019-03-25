package lmn.com.lmnlibrary.http;

import java.io.IOException;
import java.net.URLDecoder;

import lmn.com.lmnlibrary.utils.LoggerUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class NetWorkInterceptor implements Interceptor
{
    public static String TAG = "NetWorkInterceptor";
    @Override
    public Response intercept(Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        long t1 = System.nanoTime();
        //请求发起的时间
        LoggerUtil.e(String.format("发送请求 %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应的时间
        // 这里不能直接使用response.body().string()的方式输出日志 //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一 //个新的response给应用层处理
         ResponseBody responseBody = response.peekBody(1024 * 1024);
         LoggerUtil.e(String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                 response.request().url(), responseBody.string(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }

    /**
     * 读取参数
     *
     * @param requestBody
     * @return
     */
    private String getParam(RequestBody requestBody) {
        Buffer buffer = new Buffer();
        String logparm;
        try {
            requestBody.writeTo(buffer);
            logparm = buffer.readUtf8();
            logparm = URLDecoder.decode(logparm, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return logparm;
    }
}
