package lmn.com.lmnlibrary.utils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class LoggerUtil {
    private static LoggerUtil loggerUtil;

    private LoggerUtil(){
        Logger.addLogAdapter(new AndroidLogAdapter());

        //在初始化过程中可以使用默认值配置初始化也可以自定义
//        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(true)  //（可选）是否显示线程信息，默认为true
//                .methodCount(2)         //（可选）要显示的方法行数，默认2行
//                .methodOffset(5)        //（可选）隐藏内部方法调用到偏移量，默认5
//                .tag("LIY_LMN")   //（可选）每个日志的全局标记，默认PRETTY_LOGGER
//                .build();
//        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));///根据上面的格式设置logger相应的适配器

    }

    public static LoggerUtil getLoggerUtil(){
        if(loggerUtil == null){
            loggerUtil = new LoggerUtil();
        }
        return loggerUtil;
    }


    /**
     * 是否开启debug(为了安全性考虑要加final，设置为false混淆之后相关代码会被过滤掉)
     */
    private static final boolean isDebug = true;

    /**
     *Verbose就是冗长啰嗦的：通常表达开发调试过程中的一些详细信息，不过滤地输出所有调试信息。
     */
    public static void v(String msg){
        if(isDebug){
            Logger.v(msg+"");
        }
    }

    /**
     * Debug来表达调试信息：用Log.d()能输出Debug、Info、Warning、Error级别的Log信息。
     */

    public static void d(String msg){
        if(isDebug){
            Logger.d( msg+"");
        }
    }

    public static void d( Object... args) {
        if(isDebug){
            Logger.d(args);
        }
    }

    public static void d(Object object) {
        if(isDebug){
            Logger.d(object);
        }
    }

    /**
     * Info来表达一些信息：用Log.i()能输出Info、Warning、Error级别的Log信息。
     */
    public static void i(String msg){
        if(isDebug){
            Logger.i( msg+"");
        }
    }

    /**
     * Warning表示警告：但不一定会马上出现错误，开发时有时用来表示特别注意的地方。用Log.w()能输出Warning、Error级别的Log信息。
     */
    public static void w(String msg){
        if(isDebug){
            Logger.w(msg+"");
        }
    }

    /**
     * Error表示出现错误：是最需要关注解决的。用Log.e()输出，能输出Error级别的Log信息。
     */
    public static void e(String msg){
        if(isDebug){
            Logger.e(msg+"");
        }
    }

    public static void json(String msg){
        if(isDebug){
            Logger.json(msg+"");
        }
    }

    public static void xml(String msg){
        if(isDebug){
            Logger.xml(msg+"");
        }
    }

}
