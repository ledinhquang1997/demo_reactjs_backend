package com.react.demo.bootstrap;

import com.react.demo.domains.Category;
import com.react.demo.domains.Product;
import com.react.demo.repositories.CategoryRepository;
import com.react.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataLoader(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category clothing = new Category();
        clothing.setName("clothing");

        Category electronic = new Category();
        electronic.setName("electronic");

        Category savedElectronic = categoryRepository.save(electronic);
        Category savedCloothing = categoryRepository.save(clothing);


        Product tshirt = new Product();
        tshirt.setImage("tshirt");
        tshirt.setName("T shirt");
        tshirt.setDescription("As the topic says, it's quite ergonomic to change the auto complete to cmd+space, since my alfredo is opt+space it's not overlapping functions.");
        tshirt.setPrice(12);
        Product savedTshirt = productRepository.save(tshirt);

        Product suit = new Product();
        suit.setImage("suit");
        suit.setName("suit");
        suit.setDescription("As the topic says, it's quite ergonomic to change the auto complete to cmd+space, since my alfredo is opt+space it's not overlapping functions.");
        suit.setPrice(12);
        Product saved_suit = productRepository.save(suit);


        Product iphone = new Product();
        iphone.setImage("iphone");
        iphone.setName("iphone");
        iphone.setDescription("As the topic says, it's quite ergonomic to change the auto complete to cmd+space, since my alfredo is opt+space it's not overlapping functions.");
        iphone.setPrice(12);
        Product saved_iphone = productRepository.save(iphone);


        Product samsung = new Product();
        samsung.setImage("samsung");
        samsung.setName("samsung");
        samsung.setDescription("As the topic says, it's quite ergonomic to change the auto complete to cmd+space, since my alfredo is opt+space it's not overlapping functions.");
        samsung.setPrice(12);
        Product saved_samsung = productRepository.save(samsung);


        savedCloothing.getProducts().add(savedTshirt);
        savedCloothing.getProducts().add(saved_suit);

        savedElectronic.getProducts().add(saved_iphone);
        savedElectronic.getProducts().add(saved_samsung);


        savedTshirt.setCategory(savedCloothing);
        saved_suit.setCategory(savedCloothing);
        saved_samsung.setCategory(savedElectronic);
        saved_iphone.setCategory(savedElectronic);

        categoryRepository.save(savedCloothing);
        categoryRepository.save(savedElectronic);

        productRepository.save(savedTshirt);
        productRepository.save(saved_iphone);
        productRepository.save(saved_samsung);
        productRepository.save(saved_suit);

        System.out.println("product in clothing:");
        for (Product s: categoryRepository.findById(1).get().getProducts()
             ) {
            System.out.println(s.getImage());
        }
    }
}
