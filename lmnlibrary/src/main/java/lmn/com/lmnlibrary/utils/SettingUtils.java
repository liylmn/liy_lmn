package lmn.com.lmnlibrary.utils;

import android.app.Activity;
import android.net.Uri;
import android.provider.Settings;

/**
 * 作者：liy_lmn
 * 时间：2019/1/17:11:04
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */
public class SettingUtils {
    /**
     * 设置系统亮度
     * 数值为0-255
     *
     * @param activity
     * @param brightness
     */
    public static void saveBrightness(Activity activity, int brightness) {
        Uri uri = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS);
        Settings.System.putInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
        activity.getContentResolver().notifyChange(uri, null);
    }
}
