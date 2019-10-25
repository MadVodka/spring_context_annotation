package org.shop;


import org.shop.configuration.ApplicationConfiguration;
import org.shop.data.User;
import org.shop.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        //TODO: implement using Spring Framework ApplicationContext
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        List<User> users = userRepository.getUsers();
        System.out.println(users);
    }
}
