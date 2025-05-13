package com.mcc.filter;


import com.mcc.utils.CurrentHolder;
import com.mcc.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j

@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        1.获取uri判断
        String uri = request.getRequestURI();
//        2.判断是否包含login路径
        if (uri.contains("/login")) {
            log.info("登入请求，直接放行");
            filterChain.doFilter(request, response);//放行
            return;
        }
//        3.获取请求中的令牌
        String token = request.getHeader("token");

//        4.判断是否存在，如果不存在返回错误信息（未登入）
        if (!StringUtils.hasText(token)) {
            log.info("令牌为空");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
//        5.解析令牌，解析失败（未登入）
        try {
            Claims claims =  JwtUtils.parseJwt(token);
            Integer userId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(userId);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
//        6.放行;
        filterChain.doFilter(request, response);

//        7.移除用户信息
        CurrentHolder.remove();
    }
}
