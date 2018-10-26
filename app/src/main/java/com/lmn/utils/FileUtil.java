package com.lmn.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import com.lmn.BuildConfig;

import java.io.File;


/**
 * 作者：liy_lmn
 * 时间：2018/10/26:11:52
 * 邮箱：749960061@qq.com
 * 说明：日常工作或学习
 */

public class FileUtil {
    //android获取一个用于打开图片文件的intent
    public static Intent getImageFileIntent(Context context, String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//判断是否为Android N版本
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            uri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", new File(param));
        } else {
            uri = Uri.fromFile(new File(param));
        }
        intent.setDataAndType(uri, "*/*");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }
}
