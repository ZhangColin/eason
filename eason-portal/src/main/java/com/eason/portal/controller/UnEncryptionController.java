package com.eason.portal.controller;

import com.eason.portal.utils.EncryptionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author colin
 */
@RestController
public class UnEncryptionController {
    @RequestMapping(value = "unencryptionprice",method = RequestMethod.POST)
    public String unencryptionprice(String price){
        String re1 = EncryptionUtils.unbase64(price);
        String re2 = EncryptionUtils.unescape(re1);
        return re2;
    }


    @RequestMapping(value = "unencryptionproducttile",method = RequestMethod.POST)
    public String unencryptionproducttile(String producttitle){
        String re1 = EncryptionUtils.unescape(producttitle);
        String re2 = EncryptionUtils.unbase64(re1);
        return re2;
    }

    @RequestMapping(value = "unencryptionproductdes",method = RequestMethod.POST)
    public String unencryptionproductdes(String productdes){
        String result = EncryptionUtils.myunAlgorithm(productdes);
        return result;
    }
}
