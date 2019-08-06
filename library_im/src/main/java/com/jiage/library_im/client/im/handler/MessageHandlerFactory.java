package com.jiage.library_im.client.im.handler;

import android.util.SparseArray;

import com.jiage.library_im.client.im.MessageType;


/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：消息处理handler工厂
 */
public class MessageHandlerFactory {

    private MessageHandlerFactory() {

    }

    private static final SparseArray<IMessageHandler> HANDLERS = new SparseArray<>();

    static {
        /** 单聊消息处理handler */
        HANDLERS.put(MessageType.SINGLE_CHAT.getMsgType(), new SingleChatMessageHandler());
        /** 群聊消息处理handler */
        HANDLERS.put(MessageType.GROUP_CHAT.getMsgType(), new GroupChatMessageHandler());
        /** 服务端返回的消息发送状态报告处理handler */
        HANDLERS.put(MessageType.SERVER_MSG_SENT_STATUS_REPORT.getMsgType(), new ServerReportMessageHandler());
    }

    /**
     * 根据消息类型获取对应的处理handler
     *
     * @param msgType
     * @return
     */
    public static IMessageHandler getHandlerByMsgType(int msgType) {
        return HANDLERS.get(msgType);
    }
}
