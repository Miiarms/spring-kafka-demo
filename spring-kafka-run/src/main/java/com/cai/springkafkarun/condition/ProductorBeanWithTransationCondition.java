package com.cai.springkafkarun.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * kakfa事务是否支持
 * @author legend
 *
 */
public class ProductorBeanWithTransationCondition  implements Condition{
	
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		String pro = context.getEnvironment().getProperty("kafka.bootstrap-servers");
		
		String[] split = pro.split(",");
		if(split.length>1) {
			return true;
		}
		
		return false;
	}

}
