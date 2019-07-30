package com.jiage.library_im.listener;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：IMS连接状态回调
 */
public interface IMSConnectStatusCallback {
    /**
     * ims连接中
     */
    void onConnecting();

    /**
     * ims连接成功
     */
    void onConnected();

    /**
     * ims连接失败
     */
    void onConnectFailed();
}
