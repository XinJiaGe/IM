package com.jiage.im.im;


import com.jiage.im.bean.AppMessage;
import com.jiage.im.bean.BaseMessage;
import com.jiage.im.bean.ContentMessage;

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
