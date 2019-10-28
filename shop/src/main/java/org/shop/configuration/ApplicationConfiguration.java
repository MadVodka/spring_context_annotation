package org.shop.configuration;

import org.springframework.context.annotation.*;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@PropertySource("classpath:application.properties")
@PropertySource("classpath:log4j.properties")
@ComponentScan(basePackages = {"org.shop.bean_post_processors", "org.shop.aspects"})
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
}
