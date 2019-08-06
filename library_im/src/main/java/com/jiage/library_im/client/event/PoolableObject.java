package com.jiage.library_im.client.event;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：对象池中的对象要求实现PoolableObject接口
 */
public interface PoolableObject {

    /**
     * 恢复到默认状态
     */
    void reset();
}
