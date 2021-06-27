package com.eason.portal.controller;

import com.eason.portal.gateway.OrderClient;
import com.eason.portal.gateway.ProductClient;
import com.eason.portal.request.OrderItemParam;
import com.eason.portal.request.PlaceCommand;
import com.eason.portal.response.OrderDto;
import com.eason.portal.response.ProductCategoryDto;
import com.eason.portal.response.ProductDetailDto;
import com.eason.portal.response.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author colin
 */
@Controller
@RequestMapping(value = "/order")
@Slf4j
public class OrderController {
    private final ProductClient productClient;
    private final OrderClient orderClient;


    public OrderController(ProductClient productClient, OrderClient orderClient) {
        this.productClient = productClient;
        this.orderClient = orderClient;
    }

    @RequestMapping(value = "/place",method = RequestMethod.GET)
    public String tobuy(Model model,@RequestParam Long productId, @RequestParam int num){
        final List<ProductCategoryDto> productCategories = productClient.getAllProductCategories();
        model.addAttribute("productCategories", productCategories);

        final ProductDetailDto product = productClient.getProduct(productId);
        model.addAttribute("product", product);

        double price = product.getPrice();//商品价格
        double totalamount = price*num;//总金额
        model.addAttribute("totalamount",totalamount);
        model.addAttribute("num",num);
        return "order/place";
    }

    @RequestMapping(value = "/insertOrder",method = RequestMethod.POST)
    public String place(Model model, HttpServletRequest req, int num, Long productid, int payamount, Long mechartid, String consigneeadress, String consigneename, String consigneephone){
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            return "login";
        }else {
            PlaceCommand placeCommand = new PlaceCommand();
//            User userreal = (User)user;
//            int userid = userreal.getId();
            placeCommand.setUserId(1111L);
            placeCommand.setPayAmount(payamount);
            placeCommand.setConsigneeName(consigneename);
            placeCommand.setConsigneePhone(consigneephone);
            placeCommand.setConsigneeAddress(consigneeadress);

            OrderItemParam orderDetail = new OrderItemParam();
            orderDetail.setProductId(productid);
            orderDetail.setMerchantId(mechartid);
//            orderDetail.setQuantity(num);
            placeCommand.setItems(asList(orderDetail));
            OrderDto orderDto = orderClient.place(placeCommand);
            model.addAttribute("orderid",orderDto.getId());
            return "order/payorder.html";
        }


    }
}
