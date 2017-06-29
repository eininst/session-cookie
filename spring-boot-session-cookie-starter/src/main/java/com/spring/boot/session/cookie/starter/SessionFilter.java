package com.spring.boot.session.cookie.starter;


import com.session.cookie.core.warpper.RequestWrapper;
import com.session.cookie.core.warpper.ResponseWrapper;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wangziqing on 17/6/28.
 */
public class SessionFilter implements Filter {

    private final SpringSessionConfig springSessionConfig;

    public SessionFilter(SpringSessionConfig springSessionConfig){
        this.springSessionConfig = springSessionConfig;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestWrapper requestWrapper = new RequestWrapper(request,springSessionConfig);
        ResponseWrapper responseWrapper = new ResponseWrapper(response,requestWrapper);
        chain.doFilter(requestWrapper,responseWrapper);
    }

    @Override
    public void destroy() {

    }
}
