package com.jiage.library_im;

import com.jiage.library_im.listener.OnEventListener;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：消息转发器，负责将接收到的消息转发到应用层
 */
public class MsgDispatcher {
    private OnEventListener mOnEventListener;

    public MsgDispatcher() {

    }

    public void setOnEventListener(OnEventListener listener) {
        this.mOnEventListener = listener;
    }

    /**
     * 接收消息，并通过OnEventListener转发消息到应用层
     * @param msg
     */
    public void receivedMsg(MessageProtobuf.Msg msg) {
        if(mOnEventListener == null) {
            return;
        }

        mOnEventListener.dispatchMsg(msg);
    }
}
