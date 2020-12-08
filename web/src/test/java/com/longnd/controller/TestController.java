package com.longnd.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TestController {
    CharSequence charSequence = "baeldung";
    AAA aa = new ABC();
    ABC abc = new ABC();

    @Test
    public void testHello() {

        long start = System.nanoTime();


        /*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        long elapsedTime = System.nanoTime() - start;
        
        String result = encoder.encode("myPassword");
        double seconds = (double)elapsedTime / 1_000_000_000.0;
        System.out.println(result + " ------ : " + seconds);
        assertTrue(encoder.matches("myPassword", result));


        try {
            long start1 = System.nanoTime();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest("myPassword".getBytes(StandardCharsets.UTF_8));
            long elapsedTime2 = System.nanoTime() - start1;
            double seconds2 = (double)elapsedTime2 / 1_000_000_000.0;
            System.out.println(" ------ : " + seconds2);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        long start1 = System.nanoTime();
        String value = passwordEncoder.encode("myPassword");
        long elapsedTime2 = System.nanoTime() - start1;
        double seconds2 = (double)elapsedTime2 / 1_000_000_000.0;
        System.out.println(value + " :: "+ passwordEncoder.toString() + " ------ : " + seconds2);
    }
}