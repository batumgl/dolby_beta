package com.raincat.dolby_beta.helper;

import android.content.Context;
import android.content.Intent;

import com.raincat.dolby_beta.Hook;

/**
 * <pre>
 *     author : RainCat
 *     e-mail : nining377@gmail.com
 *     time   : 2021/10/25
 *     desc   : 通知帮助类
 *     version: 1.0
 * </pre>
 */

public class MessageHelper {
    public static void sendNotification(Context context, int code) {
        if (!SettingHelper.getInstance().getSetting(SettingHelper.warn_key))
            return;
        Intent intent = new Intent(Hook.msg_send_notification);
        intent.putExtra("code", cookieClassNotFoundCode);
        switch (code) {
            case cookieClassNotFoundCode:
                intent.putExtra("title", "错误");
                intent.putExtra("message", cookieClassNotFoundMessage);
                break;
            case transferClassNotFoundCode:
                intent.putExtra("title", "错误");
                intent.putExtra("message", transferClassNotFoundMessage);
                break;
            case coreClassNotFoundCode:
                intent.putExtra("title", "错误");
                intent.putExtra("message", coreClassNotFoundMessage);
                break;
            case tabClassNotFoundCode:
                intent.putExtra("title", "错误");
                intent.putExtra("message", tabClassNotFoundMessage);
                break;
            case sidebarClassNotFoundCode:
                intent.putExtra("title", "错误");
                intent.putExtra("message", sidebarClassNotFoundMessage);
                break;
        }
        context.sendBroadcast(intent);
    }

    private final static String normalMessage = "请确保已使用官方版网易云。";

    public final static int cookieClassNotFoundCode = 1000;
    private final static String cookieClassNotFoundMessage = "找不到Cookie类，这将导致签到、打卡、收藏等功能失效，" + normalMessage;

    public final static int transferClassNotFoundCode = 1001;
    private final static String transferClassNotFoundMessage = "找不到DownloadTransfer类，这将导致下载校验功能失效，" + normalMessage;

    public final static int coreClassNotFoundCode = 1002;
    private final static String coreClassNotFoundMessage = "找不到核心类，这将导致音源代理功能失效，" + normalMessage;

    public final static int tabClassNotFoundCode = 1003;
    private final static String tabClassNotFoundMessage = "找不到Tab类，这将导致Tab精简功能失效，" + normalMessage;

    public final static int sidebarClassNotFoundCode = 1004;
    private final static String sidebarClassNotFoundMessage = "找不到Sidebar类，这将导致侧边栏精简功能失效，" + normalMessage;
}
