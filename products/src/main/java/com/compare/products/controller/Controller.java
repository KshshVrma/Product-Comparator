package com.compare.products.controller;

import com.compare.products.Product;
import com.compare.products.Service.AmazonScraper;
import com.compare.products.Service.FlipkartScraper;
import com.compare.products.Service.GeminiService;
import com.compare.products.template.GeminiHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
@Autowired
    AmazonScraper amazonservice;
@Autowired
FlipkartScraper flipkartScraper;
    GeminiService geminiService=new GeminiService();

@GetMapping("/compare")
    public String compareProducts(@RequestParam("productName") String product){
    return geminiService.generateContent("what is a :"+product);

}

@GetMapping("getproducts")
    public String getProducts(@RequestParam("productName") String productName){
    StringBuilder response=new StringBuilder();
    response.append("\n\n");
    response.append(amazonservice.scrape(productName).getName());
    response.append("\n");
    response.append(amazonservice.scrape(productName).getPrice());
    response.append("\n");
    response.append(amazonservice.scrape(productName).getLink());
    response.append("\n\n");
    response.append(flipkartScraper.scrape(productName).getName());
    response.append("\n");
    response.append(flipkartScraper.scrape(productName).getPrice());
    response.append("\n");
    response.append(flipkartScraper.scrape(productName).getLink());
    return response.toString();
}
@GetMapping("/gemini")
    public String getGeminiResponse(@RequestParam("product") String prompt) {
    StringBuilder response=new StringBuilder();
    Product amazon=amazonservice.scrape(prompt);
    Product flipkart=flipkartScraper.scrape(prompt);
    response.append("compare these 2 products first one from amazon and the next one from flipkart:");
    response.append("\n\n");
    response.append(amazon.getName());
    response.append("\n");
        response.append(amazon.getPrice());
    response.append("\n");
        response.append(amazon.getLink());
    response.append("\n\n");
    response.append(flipkart.getName());
    response.append("\n");
    response.append(flipkart.getPrice());
    response.append("\n");
    response.append(flipkart.getLink());

    String res= amazon.getName()+amazon.getPrice()+" vs "+flipkart.getName()+flipkart.getPrice()+"\n"+geminiService.generateContent(response.toString());
    System.out.println(res);
    return res;
}
}
