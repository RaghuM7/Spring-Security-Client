package com.code.client.event.Listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import com.code.client.entity.User;
import com.code.client.event.RegistrationCompleteEvent;
import com.code.client.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistrationCompleteListener implements ApplicationListener<RegistrationCompleteEvent>{

    @Autowired
    private UserService userService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the verification token for the user.

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationToken(token,user);
        //Send Mail to the user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;
        
        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}", url);

    }

}
