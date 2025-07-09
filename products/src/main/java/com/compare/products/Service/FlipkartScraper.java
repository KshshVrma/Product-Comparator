package com.compare.products.Service;

import com.compare.products.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlipkartScraper {

    Product product;
    @Autowired
    public FlipkartScraper(Product product) {
        this.product = product;
    }

    public Product scrape(String query) {
//        String query = "motorola edge 60";
        String searchUrl = "https://www.flipkart.com/search?q=" + query.replace(" ", "+");

        try {
            // 1. Set up visible browser (remove headless for debugging)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new","--disable-gpu", "--no-sandbox"); // keep headless OFF for now
            WebDriver driver = new ChromeDriver(options);

            // 2. Go to page and wait for JS to load
            driver.get(searchUrl);
            Thread.sleep(5000); // wait 5 seconds (better: use WebDriverWait in real apps)

            // 3. Get full rendered HTML
            String html = driver.getPageSource();
            Document doc = Jsoup.parse(html);

            Elements productCards = doc.select("a.CGtC98"); // these wrap each product
            int count = 0;

            for (Element card : productCards) {
                String title = card.selectFirst("div.KzDlHZ") != null
                        ? card.selectFirst("div.KzDlHZ").text()
                        : "";

                String price = card.selectFirst("div.Nx9bqj") != null
                        ? card.selectFirst("div.Nx9bqj").text()
                        : "";

                String link = "https://www.flipkart.com" + card.attr("href");

                if (!title.isEmpty() && !price.isEmpty()) {

                    product.setName((count + 1) + ". " + title);
                    product.setLink("   Link: " + link );
                    product.setPrice("   Price: " + price);
//                    System.out.println((count + 1) + ". " + title);
//                    System.out.println("   Price: " + price);
//                    System.out.println("   Link: " + link + "\n");
                    count++;
                }

                if (count >= 1) break;
            }


            driver.quit();

            if (count == 0) {
                System.out.println("No flipkart products found. Check selectors or wait time.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}
