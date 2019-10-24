package org.shop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
public class ApplicationConfiguration {
}
