package com.example.websample.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("Hello LogFilter : " + Thread.currentThread());
        // 외부 -> filter (-> 처리 ->) filter -> 외부
        // 필터가 여러개인 경우 필터와 필터를 연결해주기 위해 꼭 필요한 역할을 함
        chain.doFilter(request, response);
        log.info("Bye LogFilter : " + Thread.currentThread());
    }
}
