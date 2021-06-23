package com.eason.payment.service.unionpay;

import com.eason.payment.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author colin
 */
@Service
@Slf4j
public class UnionPayService implements PayService {
    @Override
    public int pay(String tradeNumber, int amount) {
        log.info("银联支付成功。");
        return 0;
    }
}
