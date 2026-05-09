package com.elshamy.productApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.elshamy.productApp.Repo.ProductRepo;
import com.elshamy.productApp.dto.Voucher;
import com.elshamy.productApp.model.Product;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
    @Autowired
    ProductRepo repo;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${voucherService.url}")
    private String voucherServiceUrl;

    @PostMapping("/products")
    public Product create(@RequestBody Product product) {
        Voucher voucher = restTemplate.getForObject(voucherServiceUrl + product.getVoucherCode(), Voucher.class);

        double discountedPrice = product.getPrice() - voucher.getDiscount().doubleValue();
        product.setPrice(discountedPrice);
        return repo.save(product);
    }

}