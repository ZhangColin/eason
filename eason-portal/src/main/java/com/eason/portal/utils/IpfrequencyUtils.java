package com.eason.portal.utils;

import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author colin
 */
public class IpfrequencyUtils {
    public static boolean isspider(RedisTemplate redisTemplate, HttpServletRequest request){
        String ip = IpUtil.getIpAddress(request);
//        List<String> iplist = redisService.rangekeyvalue("spiderip");
//        if(iplist.contains(ip)){
//            return true;
//        }
//
//        String value = redisService.getkey(ip);
//        if(StringUtils.isBlank(value)){
//            value = "1";
//        }else {
//
//            value = Long.valueOf(value)+1+"";
//            if(Long.valueOf(value)>100){
//                redisService.pushkeyvalue("spiderip",ip);
//                return true;
//            }
//        }
//        redisService.setkey(ip,value);
//        redisService.setkeybypire(ip,5);
        return  false;
    }
}
