package com.session.cookie.core.warpper;


import com.session.cookie.core.web.HttpSessionImpl;
import com.session.cookie.core.web.SessionConfig;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Created by wangziqing on 17/6/22.
 */
public class RequestWrapper extends HttpServletRequestWrapper {

    private final SessionConfig sessionConfig;

    private HttpSessionImpl httpSessionImpl;

    public RequestWrapper(ServletRequest request, SessionConfig sessionConfig) {
        super((HttpServletRequest) request);
        this.sessionConfig = sessionConfig;
    }

    @Override
    public HttpSession getSession() {
        return getSession(true);
    }

    @Override
    public HttpSession getSession(boolean create) {
        if(create){
            if (null == httpSessionImpl) {
                synchronized (this) {
                    if (null == httpSessionImpl) {
                        httpSessionImpl = new HttpSessionImpl(this, sessionConfig);
                    }
                }
            }
        }
        return httpSessionImpl;
    }
}
