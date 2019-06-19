package com.cai.springkafkarun.productor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimerTask {
	
	@Value("${kafka.listener.topics}")
    private String topic;

    @Autowired
    private KafkaSender kafkaSender;


    @Scheduled(fixedDelay=3000)
    public void addUserTask() {
    
    	String message = null;
        for(int i=0;i<50;i++) {
        	message =  "this is message " +i;
        	kafkaSender.sendMessage(topic, message);
        }
        	
    }
}
