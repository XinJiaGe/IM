package com.jiage.im.im.handler;


import com.jiage.im.bean.AppMessage;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：类描述
 */
public interface IMessageHandler {

    void execute(AppMessage message);
}
