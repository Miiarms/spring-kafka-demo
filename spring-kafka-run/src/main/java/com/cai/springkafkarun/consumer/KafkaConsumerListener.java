package com.cai.springkafkarun.consumer;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumerListener {

    //@KafkaListener(containerFactory = "kafkaListenerContainerFactory",topics = {"${kafka.listener.topics}"})
    public void batchListener(List<ConsumerRecord<?,?>> records,Acknowledgment ack){

        try {
            records.forEach(record -> {
            	log.info("topic:{},patition:{},offset:{}",record.topic(),record.partition(),record.offset());
                System.out.println(record.value());
            });
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            ack.acknowledge();//手动提交偏移量
        }

    }
    
    
    
    @KafkaListener(containerFactory = "kafkaListenerContainerFactory",topics = {"${kafka.listener.topics}"})
    public void Listener(ConsumerRecord<String,String> record,Acknowledgment ack){
    	
    	try {
			log.info("topic:{},patition:{},offset:{}",record.topic(),record.partition(),record.offset());
			System.out.println(record.value());
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		ack.acknowledge();//手动提交偏移量
    	}
    	
    }

}
