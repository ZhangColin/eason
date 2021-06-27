package com.eason.portal.controller;

import lombok.Data;

import java.util.Date;

/**
 * @author colin
 */
@Data
public class ProductScanLog {
    private String county;
    private String provice;
    private String city;
    private String network;
    private String pindaoId;
    private String productCategoryId;
    private String productId;
    private String userId;
    private String ip;
    private String browser;
    private String os;
    private Long timestamp;
}
