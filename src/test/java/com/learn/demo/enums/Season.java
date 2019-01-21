package com.learn.demo.enums;

/**
 * 季度的枚举类，可以通过季度获取该季度的起始日和结束日
 */
public enum Season {
    Q1("-01-01","-03-31"),Q2("-04-01","-06-30"),Q3("-07-01","-09-30"),Q4("-10-01","-12-31");

    String startTime;
    String endTime;

    Season(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
