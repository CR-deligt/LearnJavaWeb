package com.qujia.util;

import javax.servlet.http.Cookie;

public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies){
        if( name == null || cookies==null || cookies.length==0){
            return null;
        }
        for(Cookie cookie:cookies){//找单独的cookie只能遍历查找
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
