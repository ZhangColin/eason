//package com.eason.gateway.filters;
//
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
//public class AuthBuyerFilter extends ZuulFilter {
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
//        if ("/cartisan-example-order/example-order/order/create".equals(request.getRequestURI())) {
//            String cookie = CookieUtil.getCookieValue(request, "openid");
//            if (StringUtils.isEmpty(cookie)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Object run() {
//        final RequestContext requestContext = RequestContext.getCurrentContext();
//        final HttpServletRequest request = requestContext.getRequest();
//
//        /**
//         * /order/create 只能买家访问
//         */
//        String cookie = CookieUtil.getCookieValue(request, "openid");
//        if (StringUtils.isEmpty(cookie)) {
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
//
//        return null;
//    }
//}
