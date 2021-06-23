package com.eason.payment.service.alipay;

import com.eason.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author colin
 */
@Service
@Slf4j
public class AliPayService implements PayService {
    @Override
    public int pay(String tradeNumber, int amount) {
        log.info("支付宝支付成功。");
        return 0;
    }
}
