package org.shop.configuration;

import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    @Value("${repository.order-repository.initial-sequence}")
    public OrderRepository orderRepository(long initialSequence) {
        OrderMapRepository orderMapRepository = new OrderMapRepository();
        orderMapRepository.setSequence(initialSequence);
        return orderMapRepository;
    }

    @Bean
    public ProductRepository productMapRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

    @Bean
    public UserRepositoryFactory userRepositoryFactory() {
        return new UserRepositoryFactory();
    }

    @Bean
    public UserRepository userRepository(UserRepositoryFactory userRepositoryFactory) {
        return userRepositoryFactory.createUserRepository();
    }
}
