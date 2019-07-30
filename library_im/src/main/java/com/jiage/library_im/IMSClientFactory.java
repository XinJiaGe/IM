package com.jiage.library_im;

import com.jiage.library_im.interf.IMSClientInterface;
import com.jiage.library_im.netty.NettyTcpClient;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：ims实例工厂方法
 */
public class IMSClientFactory {
    public static IMSClientInterface getIMSClient() {
        return NettyTcpClient.getInstance();
    }
}
