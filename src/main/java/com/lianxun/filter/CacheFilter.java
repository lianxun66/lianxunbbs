package com.lianxun.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {
        private FilterConfig filterConfig;
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            this.filterConfig = filterConfig;
        }

        //过滤器功能在这里实现
        @Override
        public void doFilter(ServletRequest req, ServletResponse resp,
                FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;

            //1.获取用户想访问的资源
            String uri = request.getRequestURI(); 
            //2.得到用户想访问的资源的后缀名
            String ext = uri.substring(uri.lastIndexOf(".")+1); 
            //得到资源需要缓存的时间
            String time = filterConfig.getInitParameter(ext);
            if(time!=null){
                long t = Long.parseLong(time)*3600*24;
                //设置浏览器缓存
                response.setDateHeader("expires", System.currentTimeMillis() + t*1000);
                response.setHeader("Cache-Control", "max-age=" + t);
            } 
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
        }
}