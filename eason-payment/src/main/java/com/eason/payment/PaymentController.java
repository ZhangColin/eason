package com.eason.payment;

import com.eason.payment.gateway.OrderClient;
import com.eason.payment.gateway.response.OrderDto;
import com.eason.payment.service.alipay.AliPayService;
import com.eason.payment.service.unionpay.UnionPayService;
import com.eason.payment.service.weixin.PayRequest;
import com.eason.payment.service.weixin.PayResponse;
import com.eason.payment.service.weixin.WeixinPayService;
import com.eason.payment.service.weixin.WxPayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author colin
 */
@Controller
@RequestMapping(value = "/payment")
@Slf4j
public class PaymentController {
    private final WeixinPayService weixinPayService;
    private final AliPayService aliPayService;
    private final UnionPayService unionPayService;
    private final OrderClient orderClient;
    private final ObjectMapper objectMapper;

    public PaymentController(
            WeixinPayService weixinPayService,
            AliPayService aliPayService,
            UnionPayService unionPayService,
            OrderClient orderClient,
            ObjectMapper objectMapper) {
        this.weixinPayService = weixinPayService;
        this.aliPayService = aliPayService;
        this.unionPayService = unionPayService;
        this.orderClient = orderClient;
        this.objectMapper = objectMapper;
    }

    /**
     *
     * @param paytype 1 微信支付 2 支付宝支付 3 银联卡支付
     * @param tradenumber
     * @param amount
     * @return 1支付成功 2支付失败
     */
    @RequestMapping(value = "payWithAmout")
    public int payWithAmout(String paytype,String tradenumber,int amount){
        int payresult = 2;
        if("1".equals(paytype)){
            payresult = weixinPayService.pay(tradenumber,amount);
        }else if("2".equals(paytype)){
            payresult = unionPayService.pay(tradenumber,amount);
        }else if("3".equals(paytype)){
            payresult =aliPayService.pay(tradenumber,amount);
        }
        return payresult;
    }

    @GetMapping("/auth")
    public ModelAndView auth(@RequestParam("code") String code, @RequestParam("orderid") Long orderid) throws JsonProcessingException {
        log.info("进入auth方法。。。");
        log.info("code={}", code);
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx705762491229630b&redirect_uri=http://youfan.natapp1.cc/auth?orderid=2&response_type=code&scope=snsapi_base#wechat_redirect
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx705762491229630b&secret=f984414914131383e75cd5741371618f&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);

        final JsonNode jsonNode = objectMapper.readValue(response, JsonNode.class);
        String openid = jsonNode.get("openid").asText();

        WxPayService wxPayServiceImpl = new WxPayService();
        PayRequest request = new PayRequest();
        request.setOrderName("友凡测试支付");//订单名字
        //订单查询
        request.setOrderId(orderid+"");//订单号
        OrderDto order = orderClient.getOrder(orderid);
        request.setOrderAmount(Double.valueOf(order.getPayAmount()));//支付金额
        request.setOpenid(openid);//微信openid, 仅微信支付时需要

        PayResponse payResponse = wxPayServiceImpl.pay(request);

        log.info("====="+openid);
        Map<String, Object> map = new HashMap<>();
        map.put("payResponse", payResponse);
        map.put("returnUrl", "http://youfan.natapp1.cc/notify");
        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
//        payService.notify(notifyData);
        WxPayService wxPayServiceImpl = new WxPayService();
        PayResponse payResponse = wxPayServiceImpl.asyncNotify(notifyData);
        if(payResponse != null && payResponse.getOrderId() != null){
            String orderid = payResponse.getOrderId();
            orderClient.pay(Long.valueOf(orderid),1,2);
        }
        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
