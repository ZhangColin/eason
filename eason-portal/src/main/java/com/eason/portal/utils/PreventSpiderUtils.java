package com.eason.portal.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author colin
 */
public class PreventSpiderUtils {
    public static boolean refervaliad(HttpServletRequest request){
        boolean result = false;
        String referer = request.getHeader("Referer");
        if(StringUtils.isNotBlank(referer)){
            result = referer.contains("indexproduct?productytpeid");
        }
        return result;
    }

    public static void setSectionCookies(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        boolean hast1 = false;
        boolean hast2 = false;
        boolean hast3 = false;
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                if (key.equals("t1")) {
                    hast1 = true;
                }
                if (key.equals("t2")) {
                    hast2 = true;
                }
                if (key.equals("t3")) {
                    hast3 = true;
                }
            }
        }
        if(!hast1){
            Cookie cookie1 = new Cookie("t1","value1");
            response.addCookie(cookie1);
        }
        if(!hast2){
            Cookie cookie2 = new Cookie("t2","value2");
            response.addCookie(cookie2);
        }

        if(!hast3){
            Cookie cookie3 = new Cookie("t3","value3");
            response.addCookie(cookie3);
        }
    }

    public static boolean validSectionCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        boolean ist1 = false;
        boolean ist2 = false;
        boolean ist3 = false;
        for(Cookie cookie:cookies){
            String key = cookie.getName();
            String value = cookie.getValue();
            if("t1".equals(key)&&"value1".equals(value)){
                ist1 = true;
            }
            if("t2".equals(key)&&"value2".equals(value)){
                ist2 = true;
            }
            if("t3".equals(key)&&"value3".equals(value)){
                ist3 = true;
            }
        }
        return ist1&&ist2&&ist3;
    }
}
