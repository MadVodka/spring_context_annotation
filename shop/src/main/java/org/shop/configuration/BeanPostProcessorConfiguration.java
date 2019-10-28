package org.shop.configuration;

import org.shop.bean_post_processors.InjectRandomIntAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfiguration {
    @Bean("injectRandomIntAnnotationBeanPostProcessor")
    public BeanPostProcessor injectRandomIntAnnotationBeanPostProcessor() {
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }
}
