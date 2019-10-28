package org.shop.bean_post_processors;

import org.shop.annotations.InjectRandomInt;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class<?> beanClass = bean.getClass();
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            boolean isIntOrLong = field.getType().equals(int.class) || field.getType().equals(long.class);
            if (annotation != null && isIntOrLong) {
                int min = annotation.minValue();
                int max = annotation.maxValue();

                int randomInt = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomInt);
            }
        }
        return bean;
    }
}
