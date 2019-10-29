package org.shop.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@PropertySource("classpath:application.properties")
@PropertySource("classpath:log4j.properties")
@ComponentScan(basePackages = {"org.shop.bean_post_processors", "org.shop.aspects"})
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
    @Bean("applicationLogger")
    public Logger logger() {
        return LoggerFactory.getLogger("Application");
    }
}
