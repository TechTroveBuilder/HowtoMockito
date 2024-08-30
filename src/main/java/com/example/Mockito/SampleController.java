package com.example.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {

    @Autowired
    private MessageService messageService;

    public String sample1(int i) {
        return messageService.getMessage(i);
    }

    public String sample2(int i, String margeMessage) {
        String message = messageService.getMessage(i);
        message = messageService.margeMessage(message, margeMessage);
        return messageTrim(message);
    }

    public String messageTrim(String message) {
        if (2 < message.length()) {
            return message.substring(0, 3);
        }
        return "文字数が小さいよ";
    }
}
