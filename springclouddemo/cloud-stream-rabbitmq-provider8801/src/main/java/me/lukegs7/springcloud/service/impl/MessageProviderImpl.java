package me.lukegs7.springcloud.service.impl;

import me.lukegs7.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

// 操作的是rabbitmq，而不是数据库
@EnableBinding(Source.class)//定义消息推送的通道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    /**
     * 发送消息到rabbitmq
     * @return
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial: " + serial);
        return serial;
    }
}
