package com.itheima.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
  /*  @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //针对登录和跳转到登录界面的请求进行放行
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf("/login")>0||requestURI.indexOf("/toLogin")>0){
            //直接放行
            return true;
        }
        if(requestURI.indexOf("/register")>0){
            return true;
        }
        //其他请求需要做登录权限判断
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            //登录成功，放行
            return true;
        }

        //没有登录，跳转到登录界面
        request.setAttribute("msg","您还没有登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/studentLogin.jsp").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }*/
}
