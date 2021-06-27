package com.eason.portal.controller;

import com.alibaba.fastjson.JSONObject;
import com.eason.portal.gateway.ProductClientHystrix;
import com.eason.portal.response.ProductCategoryDto;
import com.eason.portal.response.ProductDetailDto;
import com.eason.portal.response.ProductDto;
import com.eason.portal.gateway.ProductClient;
import com.eason.portal.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author colin
 */
@Controller
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {
    private final ProductClient productClient;
    private final ProductClientHystrix productClientHystrix;
    private final KafkaTemplate kafkaTemplate;
    private final RedisTemplate redisTemplate;


    public ProductController(ProductClient productClient, ProductClientHystrix productClientHystrix, KafkaTemplate kafkaTemplate, RedisTemplate redisTemplate) {
        this.productClient = productClient;
        this.productClientHystrix = productClientHystrix;
        this.kafkaTemplate = kafkaTemplate;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping(value = "/list")
    public String searchProduct(Model model, @RequestParam String keyword, @RequestParam Long categoryId,
                                HttpServletRequest request, HttpServletResponse response) {
        PreventSpiderUtils.setSectionCookies(request, response);

        final List<ProductCategoryDto> productCategories = productClientHystrix.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);

        if (categoryId == null) {
            categoryId = productCategories.get(0).getId();
        }

        final List<ProductDto> products = productClient.searchProducts(keyword, categoryId);
        model.addAttribute("products", products);

        // getMessage

        return "product/list";
    }

    @GetMapping(value = "/productdetail")
    public String productDetail(Model model, @RequestParam Long productId,
                                HttpServletRequest request, HttpServletResponse response) {
        if(!PreventSpiderUtils.refervaliad(request)){
            return "producterror";
        }

        if(!PreventSpiderUtils.validSectionCookies(request)){
            return "producterror";
        }

        boolean isspider = IpfrequencyUtils.isspider(redisTemplate,request);
        if(isspider){
            return "producterror";
        }

        /**
         * 埋点收集日志，频道数量少，该模块的频道id固定，id为1，代表生鲜
         */
        Long pindaoid = 1L;//频道id
        //productytpeid//产品类别id
        //producid//产品id
        //用户id
        Long userid = 0L;//游客
        //ip地址
        String ipaddress = IpUtil.getIpAddress(request);
        System.out.println(ipaddress);
        HttpSession sesion = request.getSession();
        Object userobject = sesion.getAttribute("user");
//        if(userobject!=null){
//            User user = (User)userobject;
//            userid =  user.getId();
//        }
        //获取浏览器信息以及操作系统信息
        String osandbrowser = BrowserInfoUtil.getOsAndBrowserInfo(request);
        System.out.println(osandbrowser);
        String[] temps = osandbrowser.split("---");
        String os = temps[0].trim();
        String browser = temps[1].trim();
        System.out.println(os);
        System.out.println(browser);

        ProductScanLog productScanLog = new ProductScanLog();
        //根据ip获取地区和运营商
        try {
            AreaAndNetwork areaAndnetwork = AreaAndNetworkUtil.getAddressByIp(ipaddress);
            productScanLog.setCounty(areaAndnetwork.getCounty());
            productScanLog.setProvice(areaAndnetwork.getProvice());
            productScanLog.setCity(areaAndnetwork.getCity());
            productScanLog.setCounty(areaAndnetwork.getCounty());
            productScanLog.setNetwork(areaAndnetwork.getNetwork());
        }catch (Exception e){
            e.printStackTrace();
        }
        productScanLog.setPindaoId(pindaoid.toString());
        productScanLog.setProductCategoryId("1");
        productScanLog.setProductId(productId.toString());
        productScanLog.setProductId(userid.toString());
        productScanLog.setIp(ipaddress);
        productScanLog.setBrowser(browser);
        productScanLog.setOs(os);
        productScanLog.setTimestamp(System.currentTimeMillis());
        String productscanlogstring = JSONObject.toJSONString(productScanLog);
        System.out.println(productscanlogstring);
        kafkaTemplate.send("productScanLog", "key", productscanlogstring);
        String productflume = userid +"\t" + pindaoid+"\t"+productScanLog.getTimestamp();
        kafkaTemplate.send("productscanlogflume","key",productflume);

        final List<ProductCategoryDto> productCategories = productClientHystrix.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);

        final ProductDetailDto product = productClient.getProduct(productId);
        model.addAttribute("product", product);

        return "product/detail";
    }
}
