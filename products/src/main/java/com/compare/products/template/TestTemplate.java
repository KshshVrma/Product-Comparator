package com.compare.products.template;

import org.springframework.web.client.RestTemplate;

public class TestTemplate {
    RestTemplate restTemplate;
    public TestTemplate() {
        this.restTemplate = new RestTemplate();
    }
}
