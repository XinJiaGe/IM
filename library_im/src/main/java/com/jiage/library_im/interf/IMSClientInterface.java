package com.jiage.library_im.interf;


import com.jiage.library_im.MessageProtobuf;
import com.jiage.library_im.MsgDispatcher;
import com.jiage.library_im.MsgTimeoutTimerManager;
import com.jiage.library_im.listener.IMSConnectStatusCallback;
import com.jiage.library_im.listener.OnEventListener;

import java.util.Vector;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：ims抽象接口，需要切换到其他方式实现IM功能实现此接口即可
 */
public interface IMSClientInterface {
    /**
     * 初始化
     *
     * @param serverUrlList 服务器地址列表
     * @param listener      与应用层交互的listener
     * @param callback      ims连接状态回调
     */
    void init(Vector<String> serverUrlList, OnEventListener listener, IMSConnectStatusCallback callback);

    /**
     * 重置连接，也就是重连
     * 首次连接也可认为是重连
     */
    void resetConnect();

    /**
     * 重置连接，也就是重连
     * 首次连接也可认为是重连
     * 重载
     *
     * @param isFirst 是否首次连接
     */
    void resetConnect(boolean isFirst);

    /**
     * 关闭连接，同时释放资源
     */
    void close();

    /**
     * 标识ims是否已关闭
     *
     * @return
     */
    boolean isClosed();

    /**
     * 发送消息
     *
     * @param msg
     */
    void sendMsg(MessageProtobuf.Msg msg);

    /**
     * 发送消息
     * 重载
     *
     * @param msg
     * @param isJoinTimeoutManager 是否加入发送超时管理器
     */
    void sendMsg(MessageProtobuf.Msg msg, boolean isJoinTimeoutManager);

    /**
     * 获取重连间隔时长
     *
     * @return
     */
    int getReconnectInterval();

    /**
     * 获取连接超时时长
     *
     * @return
     */
    int getConnectTimeout();

    /**
     * 获取应用在前台时心跳间隔时间
     *
     * @return
     */
    int getForegroundHeartbeatInterval();

    /**
     * 获取应用在后台时心跳间隔时间
     *
     * @return
     */
    int getBackgroundHeartbeatInterval();

    /**
     * 设置app前后台状态
     *
     * @param appStatus
     */
    void setAppStatus(int appStatus);

    /**
     * 获取由应用层构造的握手消息
     *
     * @return
     */
    MessageProtobuf.Msg getHandshakeMsg();

    /**
     * 获取由应用层构造的心跳消息
     *
     * @return
     */
    MessageProtobuf.Msg getHeartbeatMsg();

    /**
     * 获取应用层消息发送状态报告消息类型
     *
     * @return
     */
    int getServerSentReportMsgType();

    /**
     * 获取应用层消息接收状态报告消息类型
     *
     * @return
     */
    int getClientReceivedReportMsgType();

    /**
     * 获取应用层消息发送超时重发次数
     *
     * @return
     */
    int getResendCount();

    /**
     * 获取应用层消息发送超时重发间隔
     *
     * @return
     */
    int getResendInterval();

    /**
     * 获取消息转发器
     *
     * @return
     */
    MsgDispatcher getMsgDispatcher();

    /**
     * 获取消息发送超时定时器
     *
     * @return
     */
    MsgTimeoutTimerManager getMsgTimeoutTimerManager();
}