package com.gxl.searchcheck.base;

/**
 * author:Tomze
 * date:2018/12/18 14:05
 * description: 搜索记录
 */
public class SearchRecord {
    private Long id;            //主键ID
    private Long timeStamp;     //搜索时间戳  排序方便
    private String timeStr;     //搜索时间
    //类型：1.天气 2.单词 3.快递 4.火车 5.电影
    private int type;           //搜索类型
    private String content;     //搜索内容

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
