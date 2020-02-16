package com.r8me.authtools;

import com.r8me.authtools.core.AuthToolsService;
import com.r8me.authtools.core.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AuthtoolsApplication {

    @Autowired
    private AuthToolsService authToolsService;

    public static void main(String[] args) {
        SpringApplication.run(AuthtoolsApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void test(){
        authToolsService.validateToken(new TokenDTO(""));
    }
}
