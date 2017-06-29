package com.session.cookie.core.web;

/**
 * Created by wangziqing on 17/6/28.
 */
public interface SessionConfig {
    String getPrefix();
    boolean isHttp_only();
    boolean isTransferred_over_https_only();
    int getExpire_time_in_seconds();
    String getDomain();
    String getSecret();
}
