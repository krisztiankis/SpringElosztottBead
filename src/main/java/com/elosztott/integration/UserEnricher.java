package com.elosztott.integration;

import com.elosztott.model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.messaging.Message;


import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserEnricher {

    public String fillEmpty(Message<User> user) {

        MessageDigest md=null;
        String pass = "pass";
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if(user.getPayload().getPassword() != null)
        {
            pass = user.getPayload().getPassword();
        }

        if(md!=null)
        {
            return md.digest(pass.getBytes()).toString();
        }
        return pass;

    }

}
