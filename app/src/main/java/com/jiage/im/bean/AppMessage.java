package com.jiage.im.bean;

/**
 * 作者：李忻佳
 * 日期: 2019/7/30
 * 描述：App消息，用于把protobuf消息转换成app可用的消息类型
 */
public class AppMessage {

    private Head head;  // 消息头
    private String body;// 消息体

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "AppMessage{" +
                "head=" + head +
                ", body='" + body + '\'' +
                '}';
    }
}
