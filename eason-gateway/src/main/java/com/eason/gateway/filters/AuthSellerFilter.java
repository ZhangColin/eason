//package com.eason.gateway.filters;
//
//import com.cartisan.common.utils.CookieUtil;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpStatus;
//
//import javax.servlet.http.HttpServletRequest;
//
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
//
///**
// * @author colin
// */
////@Component
//public class AuthSellerFilter extends ZuulFilter {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public String filterType() {
//        return PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER - 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        final RequestContext requestContext = RequestContext.getCurrentContext();
//        final HttpServletRequest request = requestContext.getRequest();
//
//        if ("/order/finish".equals(request.getRequestURI())) {
//            String cookie = CookieUtil.getCookieValue(request, "token");
//            if (StringUtils.isEmpty(cookie)
//                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format("token_%s", cookie)))) {
//                return true;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        final RequestContext requestContext = RequestContext.getCurrentContext();
//        final HttpServletRequest request = requestContext.getRequest();
//
//        /**
//         * /order/finish 只能卖家访问
//         */
//
//        String cookie = CookieUtil.getCookieValue(request, "token");
//        if (StringUtils.isEmpty(cookie)
//                || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format("token_%s", cookie)))) {
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
//
//        return null;
//    }
//}
