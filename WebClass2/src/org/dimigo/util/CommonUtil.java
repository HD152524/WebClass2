package org.dimigo.util;

public class CommonUtil {
    public static boolean isEmpty(String s){
        return s==null || "".equals(s.trim());
    }

    public static void main(String[] args) {
        String uri = "WebClass/jsp/aa/bb/login.do";
        String actionName = uri.substring(uri.lastIndexOf("/")+1);
        actionName = actionName.substring(0, actionName.indexOf("."));
        System.out.println("Action Name: "+actionName);
    }
}
