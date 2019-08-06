package com.jiage.library_im.client.im.handler;


import com.jiage.library_im.client.bean.AppMessage;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：类描述
 */
public interface IMessageHandler {

    void execute(AppMessage message);
}
