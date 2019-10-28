package org.shop.bean_post_processors;

import org.shop.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null && field.getType().equals(int.class)) {
                int min = annotation.minValue();
                int max = annotation.maxValue();
                Random random = new Random();

                int randomInt = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomInt);
            }
        }
        return bean;
    }
}
