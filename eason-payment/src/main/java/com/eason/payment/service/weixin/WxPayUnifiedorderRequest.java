package com.eason.payment.service.weixin;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author colin
 */
@XStreamAlias("xml")
@Data
public class WxPayUnifiedorderRequest {
    private String appid;

    @XStreamAlias("mch_id")
    private String mchId;

    @XStreamAlias("nonce_str")
    private String nonceStr;

    private String sign;

    private String attach;

    private String body;

    private String detail;


    @XStreamAlias("notify_url")
    private String notifyUrl;

    private String openid;

    @XStreamAlias("out_trade_no")
    private String outTradeNo;

    @XStreamAlias("spbill_create_ip")
    private String spbillCreateIp;

    @XStreamAlias("total_fee")
    private Integer totalFee;

    @XStreamAlias("trade_type")
    private String tradeType;
}
