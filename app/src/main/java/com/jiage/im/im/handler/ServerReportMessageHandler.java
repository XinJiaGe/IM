package com.jiage.im.im.handler;

import android.util.Log;

import com.jiage.im.bean.AppMessage;


/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：服务端返回的消息发送状态报告
 */
public class ServerReportMessageHandler extends AbstractMessageHandler {

    private static final String TAG = ServerReportMessageHandler.class.getSimpleName();

    @Override
    protected void action(AppMessage message) {
        Log.d(TAG, "收到消息状态报告，message=" + message);
    }
}
