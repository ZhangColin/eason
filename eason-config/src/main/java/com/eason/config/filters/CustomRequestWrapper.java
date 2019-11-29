package com.eason.config.filters;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;

/**
 * <p>Title: CustomRequestWrapper</p>
 * <p>Description: 解决使用 webhook 自动刷新出现的 400 问题，
 * github 在 Post 请求的同时默认会在 body 加上一串载荷，
 * spring boot 因为无法正常反序列化而报了 400 错误。</p>
 *
 * @author colin
 */
public class CustomRequestWrapper extends HttpServletRequestWrapper {
    public CustomRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() {
        byte[] bytes = new byte[0];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);


        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.read() == -1 ? true : false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };
    }
}
