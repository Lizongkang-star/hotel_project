package com.example.hotel_project.Util.ErrorProcess;//package demo.Util.ErrorProcess;
//
///**
// * Author YZQ
// *
// * @DATE 2019/7/9 1:05
// */
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class AjaxUtil {
//    //得到一个map
//    public static Map<String, Object> getMap() {
//        return new HashMap<String, Object>();
//    }
//
//    //返回json数据 状态
//    public static Map<String, Object> messageMap(int status) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status);
//        return map;
//    }
//
//    //返回json数据 状态、消息
//    public static Map<String, Object> messageMap(int status, String message) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status);
//        map.put("message", message);
//        return map;
//    }
//
//    //返回json数据 状态、消息 和一个参数
//    public static Map<String, Object> messageMap(int status, String message,
//                                                 String paramName, Object paramValue) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status);
//        map.put("message", message);
//        map.put(paramName, paramValue);
//        return map;
//    }
//
//    //返回json数据 状态、消息 和多个参数
//    public static Map<String, Object> messageMap(int status, String message,
//                                                 String[] paramNames, Object[] paramValues) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", status);
//        map.put("message", message);
//        if (paramNames != null && paramNames.length > 0) {
//            for (int i = 0; i < paramNames.length; i++) {
//                map.put(paramNames[i], paramValues[i]);
//            }
//        }
//        return map;
//    }
//}