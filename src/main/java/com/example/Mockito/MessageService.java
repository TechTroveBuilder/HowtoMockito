package com.example.Mockito;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    public String getMessage(int a) {
        if (1 < a) {
            return "getMessageメソッドを呼び出しました。";
        }
        return "引数が小さいです";
    }

    public String margeMessage(String a, String b) {
        return a + b;
    }
}

