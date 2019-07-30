package com.jiage.im.im.handler;

import android.util.Log;

import com.jiage.im.bean.AppMessage;


/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：类描述
 */
public class GroupChatMessageHandler extends AbstractMessageHandler {

    private static final String TAG = GroupChatMessageHandler.class.getSimpleName();

    @Override
    protected void action(AppMessage message) {
        Log.d(TAG, "收到群聊消息，message=" + message);
    }
}
