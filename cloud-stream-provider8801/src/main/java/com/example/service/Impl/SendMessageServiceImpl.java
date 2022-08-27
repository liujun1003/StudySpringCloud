package com.example.service.Impl;

import com.example.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(Source.class) //指定绑定的对象的类型
public class SendMessageServiceImpl implements SendMessageService {

    @Autowired
    @Qualifier("output")
    private MessageChannel outpot; // 注入绑定的对象output,表示输出消息的管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        outpot.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial:" + serial);
        return serial;
    }
}
