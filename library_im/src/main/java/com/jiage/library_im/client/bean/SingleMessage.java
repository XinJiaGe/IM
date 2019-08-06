package com.jiage.library_im.client.bean;


import com.jiage.library_im.client.utils.StringUtil;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：单聊消息
 */
public class SingleMessage extends ContentMessage implements Cloneable {

    @Override
    public int hashCode() {
        try {
            return this.msgId.hashCode();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof SingleMessage)) {
            return false;
        }

        return StringUtil.equals(this.msgId, ((SingleMessage) obj).getMsgId());
    }
}
