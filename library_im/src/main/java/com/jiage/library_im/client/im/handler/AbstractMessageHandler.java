package com.jiage.library_im.client.im.handler;


import com.jiage.library_im.client.bean.AppMessage;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：抽象的MessageHandler
 */
public abstract class AbstractMessageHandler implements IMessageHandler {

    @Override
    public void execute(AppMessage message) {
        action(message);
    }

    protected abstract void action(AppMessage message);
}
