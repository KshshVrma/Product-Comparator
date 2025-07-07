package com.compare.products.controller;

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
//@Autowired
//FlipkartScraper flipkartScraper;
    GeminiService geminiService=new GeminiService();

@GetMapping("/compare")
    public String compareProducts(@RequestParam("productName") String product){
    return geminiService.generateContent("what is a :"+product);

}
}
