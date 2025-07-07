package com.compare.products.Service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;


@Service
public class AmazonScraper {

    public static void mained(String[] args) {
        String query = "oneplus nord";  // change search term as needed
        String searchUrl = "https://www.amazon.in/s?k=" + query.replace(" ", "+");

        try {
            // Set user agent to mimic a real browser
            Document doc = Jsoup.connect(searchUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                            + "(KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36")
                    .timeout(10000)
                    .get();

            Elements products = doc.select("div.s-main-slot div[data-component-type='s-search-result']");
            int count = 0;

            for (Element product : products) {
                String title = product.select("h2 span").text();
                String price = product.select(".a-price .a-offscreen").text();
                String link = product.select("h2 a").attr("href");

                if (!title.isEmpty() && !price.isEmpty()) {
                    System.out.println((count + 1) + ". " + title);
                    System.out.println("   Price: " + price);
                    System.out.println("   Link: https://www.amazon.in" + link + "\n");

                    count++;
                }

                if (count >= 3) break;
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
