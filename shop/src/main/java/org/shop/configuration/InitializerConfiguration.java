package org.shop.configuration;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.common.Sellers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InitializerConfiguration {
    private static final Long FIRST_SELLER_ID = 1L;
    private static final Long SECOND_SELLER_ID = 2L;

    @Bean
    public ProductInitializer productInitializer(ProductService productService) {
        return new ProductInitializer(productService);
    }

    @Bean("baseProposalInitializer")
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public Map<Long, String> sellersMap() {
        Map<Long, String> sellersMap = new HashMap<>();
        sellersMap.put(FIRST_SELLER_ID, Sellers.AMAZON);
        sellersMap.put(SECOND_SELLER_ID, Sellers.SAMSUNG);
        return sellersMap;
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public UserInitializer userInitializer(UserService userService) {
        return new UserInitializer(userService);
    }

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }
}
