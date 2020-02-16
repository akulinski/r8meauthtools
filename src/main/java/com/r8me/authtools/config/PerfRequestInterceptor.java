package com.r8me.authtools.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StopWatch;

import java.io.IOException;

@Slf4j
public class PerfRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest hr, byte[] bytes, ClientHttpRequestExecution chre) throws IOException {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        ClientHttpResponse response = chre.execute(hr, bytes);
        stopwatch.stop();

        log.debug("method=" + hr.getMethod() + ", uri=" + hr.getURI() + ", response_time=" + stopwatch.getTotalTimeMillis() + ", response_code=" + response.getStatusCode().value());

        return response;
    }
}
