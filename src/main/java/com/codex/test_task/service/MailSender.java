package com.codex.test_task.service;

import com.codex.test_task.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MailSender {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;

    public void sendEmailAfterBuying(String emailTo, List<Item> items) {
        StringBuilder messageText = new StringBuilder("Thank you for purchasing: \n");
        for(Item item: items) {
            messageText.append(item + "\n");
        }

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(username);
        msg.setTo(emailTo);
        msg.setSubject("Purchase report");
        msg.setText(messageText.toString());

        javaMailSender.send(msg);
    }

    public void sendEmailIfChangedItemInCart(List<String> emails) {
        for(String emailTo : emails) {
            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setFrom(username);
            msg.setTo(emailTo);
            msg.setSubject("Item(s) you added in the cart has been changed");
            msg.setText("Dear customer! Item(s) you added in the cart has been changed! Check updates!");

            javaMailSender.send(msg);
        }
    }
}
