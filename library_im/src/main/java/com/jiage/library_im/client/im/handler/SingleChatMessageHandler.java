package com.jiage.library_im.client.im.handler;

import android.util.Log;

import com.jiage.library_im.client.bean.AppMessage;
import com.jiage.library_im.client.bean.SingleMessage;
import com.jiage.library_im.client.event.CEventCenter;
import com.jiage.library_im.client.event.Events;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：类描述
 */
public class SingleChatMessageHandler extends AbstractMessageHandler {

    private static final String TAG = SingleChatMessageHandler.class.getSimpleName();

    @Override
    protected void action(AppMessage message) {
        Log.d(TAG, "收到消息，message=" + message);

        SingleMessage msg = new SingleMessage();
        msg.setMsgId(message.getHead().getMsgId());
        msg.setMsgType(message.getHead().getMsgType());
        msg.setMsgContentType(message.getHead().getMsgContentType());
        msg.setFromId(message.getHead().getFromId());
        msg.setToId(message.getHead().getToId());
        msg.setTimestamp(message.getHead().getTimestamp());
        msg.setExtend(message.getHead().getExtend());
        msg.setContent(message.getBody());


        CEventCenter.dispatchEvent(Events.CHAT_SINGLE_MESSAGE, 0, 0, msg);
    }
}
