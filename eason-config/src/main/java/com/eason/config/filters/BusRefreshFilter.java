package com.eason.config.filters;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author colin
 */
@WebFilter(filterName = "BusRefreshFilter", urlPatterns = "/")
public class BusRefreshFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURI();

        // 只过滤/actuator/bus-refresh请求
        final String suffix = "/bus-refresh";
        if (!StringUtils.endsWith(url, suffix)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 使用 HttpServletRequest 包装原始请求达到个性 post 请求中 body 内容的目的
        CustomRequestWrapper requestWrapper = new CustomRequestWrapper(httpServletRequest);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
