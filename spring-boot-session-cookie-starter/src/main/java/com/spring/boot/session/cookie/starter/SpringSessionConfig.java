package com.spring.boot.session.cookie.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.session.cookie.core.web.SessionConfig;

/**
 * Created by wangziqing on 17/6/23.
 */
@Configuration
@ConfigurationProperties(prefix="session")
public class SpringSessionConfig implements SessionConfig {
    private String prefix = "super";
    private boolean http_only;
    private boolean transferred_over_https_only;
    private int expire_time_in_seconds = 1800;
    private String domain;
    private String secret;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean isHttp_only() {
        return http_only;
    }

    public void setHttp_only(boolean http_only) {
        this.http_only = http_only;
    }

    public boolean isTransferred_over_https_only() {
        return transferred_over_https_only;
    }

    public void setTransferred_over_https_only(boolean transferred_over_https_only) {
        this.transferred_over_https_only = transferred_over_https_only;
    }

    public int getExpire_time_in_seconds() {
        return expire_time_in_seconds;
    }

    public void setExpire_time_in_seconds(int expire_time_in_seconds) {
        this.expire_time_in_seconds = expire_time_in_seconds;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }



    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new SessionFilter(this));
        registration.addUrlPatterns("/*");
        registration.setOrder(Integer.MIN_VALUE);
        return registration;
    }

}
