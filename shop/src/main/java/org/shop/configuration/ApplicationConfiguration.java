package org.shop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
}
