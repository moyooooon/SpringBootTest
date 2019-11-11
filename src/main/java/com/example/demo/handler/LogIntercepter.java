package com.example.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogIntercepter implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LogIntercepter.class);

    // コントローラ処理前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("before handling={}", request.getRequestURI());
        return true;
    }

    // コントローラ処理後
    // ビューレンダリング前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("before view rendering={}", request.getRequestURI());
    }

    // ビューレンダリング後
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("after view rendering={}", request.getRequestURI());
    }
}