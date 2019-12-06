package com.example.hotel_project.Util.ErrorProcess;//package demo.Util.ErrorProcess;
//
///**
// * Author YZQ
// * 业务自定义异常
// * @DATE 2019/7/9 1:04
// */
//
//public class ServiceCustomException extends RuntimeException {
//
//    private Integer customStatus;
//    private String customMessage;
//
//    private static final long serialVersionUID = 1L;
//
//    public ServiceCustomException() {
//        super();
//    }
//
//    public ServiceCustomException(Integer customStatus, String customMessage) {
//        this.customStatus = customStatus;
//        this.customMessage = customMessage;
//    }
//
//    public ServiceCustomException(Integer customStatus, String customMessage, Throwable cause) {
//        super(cause);
//        this.customStatus = customStatus;
//        this.customMessage = customMessage;
//    }
//
//
//    public Integer getCustomStatus() {
//        return customStatus;
//    }
//
//
//    public void setCustomStatus(Integer customStatus) {
//        this.customStatus = customStatus;
//    }
//
//
//    public String getCustomMessage() {
//        return customMessage;
//    }
//
//
//    public void setCustomMessage(String customMessage) {
//        this.customMessage = customMessage;
//    }
//
//
//}