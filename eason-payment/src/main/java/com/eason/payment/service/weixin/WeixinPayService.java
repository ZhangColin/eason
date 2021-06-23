package com.eason.payment.service.weixin;

import com.eason.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author colin
 */
@Service
@Slf4j
public class WeixinPayService implements PayService {
    @Override
    public int pay(String tradeNumber, int amount) {
        log.info("微信支付成功。");
        return 0;
    }
}
