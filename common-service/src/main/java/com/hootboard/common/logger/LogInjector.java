package com.hootboard.common.logger;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Component
public class LogInjector implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
	            @Override
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
	                ReflectionUtils.makeAccessible(field);
	                if (field.getAnnotation(Log.class) != null) {
	                    Logger log = (Logger) LoggerFactory.getLogger(bean.getClass());
	                    field.set(bean, log);
	                }
	            }
	        });
	        return bean;
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
