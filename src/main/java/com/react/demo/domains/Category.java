package com.react.demo.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Product> products= new HashSet<>();

    public Category removeProduct(Product product){
        if(this.products==null) {
            this.products = new HashSet<>();
            return this;
        }
        if(product!=null) this.products.remove(product);
            return this;

    }
}
