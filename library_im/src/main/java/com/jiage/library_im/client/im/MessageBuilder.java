package com.jiage.library_im.client.im;


import com.jiage.library_im.client.bean.AppMessage;
import com.jiage.library_im.client.bean.BaseMessage;
import com.jiage.library_im.client.bean.ContentMessage;
import com.jiage.library_im.client.bean.Head;
import com.jiage.library_im.client.utils.StringUtil;
import com.jiage.library_im.MessageProtobuf;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：消息转换
 */
public class MessageBuilder {

    /**
     * 根据聊天消息，生成一条可以能够传输通讯的消息
     *
     * @param msgId
     * @param type
     * @param subType
     * @param fromId
     * @param toId
     * @param extend
     * @param content
     * @return
     */
    public static AppMessage buildAppMessage(String msgId, int type, int subType, String fromId,
                                             String toId, String extend, String content) {
        AppMessage message = new AppMessage();
        Head head = new Head();
        head.setMsgId(msgId);
        head.setMsgType(type);
        head.setMsgContentType(subType);
        head.setFromId(fromId);
        head.setToId(toId);
        head.setExtend(extend);
        message.setHead(head);
        message.setBody(content);

        return message;
    }

    /**
     * 根据聊天消息，生成一条可以能够传输通讯的消息
     *
     * @param msg
     * @return
     */
    public static AppMessage buildAppMessage(ContentMessage msg) {
        AppMessage message = new AppMessage();
        Head head = new Head();
        head.setMsgId(msg.getMsgId());
        head.setMsgType(msg.getMsgType());
        head.setMsgContentType(msg.getMsgContentType());
        head.setFromId(msg.getFromId());
        head.setToId(msg.getToId());
        head.setTimestamp(msg.getTimestamp());
        head.setExtend(msg.getExtend());
        message.setHead(head);
        message.setBody(msg.getContent());

        return message;
    }

    /**
     * 根据聊天消息，生成一条可以能够传输通讯的消息
     *
     * @param msg
     * @return
     */
    public static AppMessage buildAppMessage(BaseMessage msg) {
        AppMessage message = new AppMessage();
        Head head = new Head();
        head.setMsgId(msg.getMsgId());
        head.setMsgType(msg.getMsgType());
        head.setMsgContentType(msg.getMsgContentType());
        head.setFromId(msg.getFromId());
        head.setToId(msg.getToId());
        head.setExtend(msg.getExtend());
        head.setTimestamp(msg.getTimestamp());
        message.setHead(head);
        message.setBody(msg.getContent());

        return message;
    }

    /**
     * 根据业务消息对象获取protoBuf消息对应的builder
     *
     * @param message
     * @return
     */
    public static MessageProtobuf.Msg.Builder getProtoBufMessageBuilderByAppMessage(AppMessage message) {
        MessageProtobuf.Msg.Builder builder = MessageProtobuf.Msg.newBuilder();
        MessageProtobuf.Head.Builder headBuilder = MessageProtobuf.Head.newBuilder();
        headBuilder.setMsgType(message.getHead().getMsgType());
        headBuilder.setStatusReport(message.getHead().getStatusReport());
        headBuilder.setMsgContentType(message.getHead().getMsgContentType());
        if (!StringUtil.isEmpty(message.getHead().getMsgId()))
            headBuilder.setMsgId(message.getHead().getMsgId());
        if (!StringUtil.isEmpty(message.getHead().getFromId()))
            headBuilder.setFromId(message.getHead().getFromId());
        if (!StringUtil.isEmpty(message.getHead().getToId()))
            headBuilder.setToId(message.getHead().getToId());
        if (message.getHead().getTimestamp() != 0)
            headBuilder.setTimestamp(message.getHead().getTimestamp());
        if (!StringUtil.isEmpty(message.getHead().getExtend()))
            headBuilder.setExtend(message.getHead().getExtend());
        if (!StringUtil.isEmpty(message.getBody()))
            builder.setBody(message.getBody());
        builder.setHead(headBuilder);
        return builder;
    }

    /**
     * 通过protobuf消息对象获取业务消息对象
     *
     * @param protobufMessage
     * @return
     */
    public static AppMessage getMessageByProtobuf(
            MessageProtobuf.Msg protobufMessage) {
        AppMessage message = new AppMessage();
        Head head = new Head();
        MessageProtobuf.Head protoHead = protobufMessage.getHead();
        head.setMsgType(protoHead.getMsgType());
        head.setStatusReport(protoHead.getStatusReport());
        head.setMsgContentType(protoHead.getMsgContentType());
        head.setMsgId(protoHead.getMsgId());
        head.setFromId(protoHead.getFromId());
        head.setToId(protoHead.getToId());
        head.setTimestamp(protoHead.getTimestamp());
        head.setExtend(protoHead.getExtend());
        message.setHead(head);
        message.setBody(protobufMessage.getBody());
        return message;
    }
}
