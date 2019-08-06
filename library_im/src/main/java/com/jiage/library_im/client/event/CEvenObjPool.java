package com.jiage.library_im.client.event;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：事件对象池
 */
public class CEvenObjPool extends ObjectPool<CEvent> {

    public CEvenObjPool(int capacity) {
        super(capacity);
    }

    @Override
    protected CEvent[] createObjPool(int capacity) {
        return new CEvent[capacity];
    }

    @Override
    protected CEvent createNewObj() {
        return new CEvent();
    }
}
