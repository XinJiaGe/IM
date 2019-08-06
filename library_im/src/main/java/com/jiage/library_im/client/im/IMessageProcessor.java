package com.jiage.library_im.client.im;


import com.jiage.library_im.client.bean.AppMessage;
import com.jiage.library_im.client.bean.BaseMessage;
import com.jiage.library_im.client.bean.ContentMessage;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：消息处理器接口
 */
public interface IMessageProcessor {

    void receiveMsg(AppMessage message);
    void sendMsg(AppMessage message);
    void sendMsg(ContentMessage message);
    void sendMsg(BaseMessage message);
}
