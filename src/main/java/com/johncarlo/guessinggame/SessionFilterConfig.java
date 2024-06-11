package com.johncarlo.guessinggame;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SessionFilterConfig {

    @Bean
    public FilterRegistrationBean<SessionFilter> sessionFilter() {
        FilterRegistrationBean<SessionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SessionFilter());
        registrationBean.addUrlPatterns("/game/*");

        return registrationBean;
    }

    public static class SessionFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession httpSession = req.getSession(false);

            if (httpSession == null || httpSession.getAttribute("player") == null) {
                res.sendRedirect("/player/login");
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}