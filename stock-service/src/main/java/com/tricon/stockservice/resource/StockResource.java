package com.tricon.stockservice.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by premsingh on 2/19/18.
 */

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    private Logger LOGGER = LoggerFactory.getLogger(StockResource.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{username}")
    public List<Quote> getStock(@PathVariable("username") final String userName) {
    //http://localhost:8300/rest/db/
        LOGGER.info("Inside getStock username::{}",userName);
        ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });


        List<String> quotes = quoteResponse.getBody();
        return quotes
                .stream()
                .map(quote -> {
                    //Stock stock = getStockPrice(quote);
                    //System.out.println("For ="+ stock +"======>" +stock.getQuote().getPrice());
                    return new Quote(quote, new BigDecimal(400.00));
                })
                .collect(Collectors.toList());
    }

    private Stock getStockPrice(String quote) {
        try {
          //Commenting as Yahoo Finance API not working
            //return YahooFinance.get(quote);
            Stock stock = new Stock(quote);
            stock.getQuote().setPrice(new BigDecimal(200.00));
            return stock;
        } catch (Exception e) {
            e.printStackTrace();
            return new Stock(quote);
        }

    }

    private class Quote {
        private String quote;
        private BigDecimal price;

        public Quote(String quote, BigDecimal price) {
            this.quote = quote;
            this.price = price;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }

}
