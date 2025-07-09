package com.compare.products;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Use prototype scope to create a new instance for each request
public class Product {
    private String name;
    private String price;
    private String link;

    public Product(String name, String price, String link) {
        this.name = name;
        this.price = price;
        this.link = link;
    }
    public Product() {
        // Default constructor for Spring to create instances
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
