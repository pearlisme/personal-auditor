package com.pa.api.personalauditor.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class FilterConfig implements Filter {
    private final String TRACE_ID = "X-Correlation-Id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        MDC.put(TRACE_ID, UUID.randomUUID().toString());
        log.info("Intercept coming request and set MDC context information");
        // pass the request
        chain.doFilter(request, response);
    }
}
