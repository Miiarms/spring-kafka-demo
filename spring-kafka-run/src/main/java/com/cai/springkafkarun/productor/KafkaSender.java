package com.cai.springkafkarun.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Transactional
public class KafkaSender {

	@Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

	
    public void sendMessage(String topic, String message){

//        ListenableFuture<SendResult<String, String>> sender = kafkaTemplate.send(new ProducerRecord<>(topic, message));
//
//        sender.addCallback(result -> {}, ex -> log.error("数据发送失败!"));
    	ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, message);
    	send.addCallback(result -> {}, ex -> log.error("数据发送失败!"));
    	
    }

}
