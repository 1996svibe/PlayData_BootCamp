package com.naver.user.domain.request;

public class InsertRequest {
    private Integer uid;
    private String content;

    public InsertRequest(Integer uid, String content) {
        this.uid = uid;
        this.content = content;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InsertRequest{" +
                "uid=" + uid +
                ", content='" + content + '\'' +
                '}';
    }
}
