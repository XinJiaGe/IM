package com.jiage.im.im;

import android.util.Log;

import com.jiage.im.bean.AppMessage;
import com.jiage.im.bean.BaseMessage;
import com.jiage.im.bean.ContentMessage;
import com.jiage.im.im.handler.IMessageHandler;
import com.jiage.im.im.handler.MessageHandlerFactory;
import com.jiage.im.utils.CThreadPoolExecutor;


/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：消息处理器
 */
public class MessageProcessor implements IMessageProcessor {

    private static final String TAG = MessageProcessor.class.getSimpleName();

    private MessageProcessor() {

    }

    private static class MessageProcessorInstance {
        private static final IMessageProcessor INSTANCE = new MessageProcessor();
    }

    public static IMessageProcessor getInstance() {
        return MessageProcessorInstance.INSTANCE;
    }

    /**
     * 接收消息
     * @param message
     */
    @Override
    public void receiveMsg(final AppMessage message) {
        CThreadPoolExecutor.runInBackground(new Runnable() {

            @Override
            public void run() {
                try {
                    IMessageHandler messageHandler = MessageHandlerFactory.getHandlerByMsgType(message.getHead().getMsgType());
                    if (messageHandler != null) {
                        messageHandler.execute(message);
                    } else {
                        Log.e(TAG, "未找到消息处理handler，msgType=" + message.getHead().getMsgType());
                    }
                } catch (Exception e) {
                    Log.e(TAG, "消息处理出错，reason=" + e.getMessage());
                }
            }
        });
    }

    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public void sendMsg(final AppMessage message) {
        CThreadPoolExecutor.runInBackground(new Runnable() {

            @Override
            public void run() {
                boolean isActive = IMSClientBootstrap.getInstance().isActive();
                if (isActive) {
                    IMSClientBootstrap.getInstance().sendMessage(MessageBuilder.getProtoBufMessageBuilderByAppMessage(message).build());
                } else {
                    Log.e(TAG, "发送消息失败");
                }
            }
        });
    }

    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public void sendMsg(ContentMessage message) {
        this.sendMsg(MessageBuilder.buildAppMessage(message));
    }

    /**
     * 发送消息
     *
     * @param message
     */
    @Override
    public void sendMsg(BaseMessage message) {
        this.sendMsg(MessageBuilder.buildAppMessage(message));
    }
}
