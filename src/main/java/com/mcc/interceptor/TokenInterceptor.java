package com.mcc.interceptor;

import com.mcc.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//自定义拦截器,交给ioc容器管理
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    //在目标方法执行前执行，返回true则放行，返回false则不放行
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        1.获取uri 2.判断是否含有login 4.获取请求头中的token 5.判断是否为空 6.解析token 7.放行
//        String uri = request.getRequestURI();
//
//        if (uri.contains("login")) {
//            return true;
//        }
//
//        String token = request.getHeader("token");
//
//        if (!StringUtils.hasText(token)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//
//        try {
//            JwtUtils.parseJwt(token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("解析令牌失败");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        return true;
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //早期前后端不分离，需要在视图执行完后，调用该方法。
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
