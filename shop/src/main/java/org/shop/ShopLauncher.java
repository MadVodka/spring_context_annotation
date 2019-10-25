package org.shop;


import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.configuration.ApplicationConfiguration;
import org.shop.data.Product;
import org.shop.data.Proposal;
import org.shop.data.Seller;
import org.shop.data.User;
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

        System.out.println("Products");
        ProductService productService = applicationContext.getBean(ProductService.class);
        List<Product> products = productService.getProducts();
        products.forEach(System.out::println);
        System.out.println();

        System.out.println("Sellers");
        SellerService sellerService = applicationContext.getBean(SellerService.class);
        List<Seller> sellers = sellerService.getSellers();
        sellers.forEach(System.out::println);
        System.out.println();

        System.out.println("Proposals");
        ProposalService proposalService = applicationContext.getBean(ProposalService.class);
        List<Proposal> proposalsBySellerId = proposalService.getProposalsBySellerId(1L);
        proposalsBySellerId.addAll(proposalService.getProposalsBySellerId(2L));
        proposalsBySellerId.forEach(System.out::println);
        System.out.println();

        System.out.println("Users");
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> users = userService.getUsers();
        users.forEach(System.out::println);
        System.out.println();
    }
}
