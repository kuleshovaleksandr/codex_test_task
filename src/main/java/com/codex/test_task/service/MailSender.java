package com.codex.test_task.service;

import com.codex.test_task.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailSender {

//    private final JavaMailSender javaMailSender;
//
//    public void sendEmailAfterBuying(String emailTo, List<Item> items) {
//        StringBuilder messageText = new StringBuilder("Thank you for purchasing: \n");
//        for(Item item: items) {
//            messageText.append(item + "\n");
//        }
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(emailTo);
//        msg.setSubject("Purchase report");
//        msg.setText(messageText.toString());
//
//        javaMailSender.send(msg);
//    }

//    public void sendEmailIfItemInCart(String ... emails) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(emailTo);
//        msg.setSubject("Purchase report");
//        msg.setText(messageText.toString());
//
//        javaMailSender.send(msg);
//    }
}
