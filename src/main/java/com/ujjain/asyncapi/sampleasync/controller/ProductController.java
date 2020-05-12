package com.ujjain.asyncapi.sampleasync.controller;

import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.PriceRequest;
import com.ujjain.asyncapi.sampleasync.model.dto.ProductRequest;
import com.ujjain.asyncapi.sampleasync.services.PriceService;
import com.ujjain.asyncapi.sampleasync.services.ProductDetailsServices;
import com.ujjain.asyncapi.sampleasync.services.ProductServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * Created by abhishekujjain on 10/05/20.
 */
@RestController
public class ProductController {
    public static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductServices productServices;

    @Autowired
    PriceService priceService;

    @Autowired
    ProductDetailsServices productDetailsServices;
    private String productNotAvailable = "Product is not Available";


    @PostMapping(value = "/product")
    public ResponseEntity addProduct(@RequestBody ProductRequest request) {
        logger.info("Recieved request to add Product : {}", request);
        return new ResponseEntity(productServices.addProduct(request), HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") String productId) throws ExecutionException, InterruptedException {
        logger.info("Recieved request for Product id : {} ", productId);
        Product product = productServices.findProductById(productId).get();
        if (product.getProductId() != null)
            return new ResponseEntity(product, HttpStatus.OK);
        else
            return new ResponseEntity(productNotAvailable, HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/product")
    public ResponseEntity updateProduct(@RequestBody ProductRequest productRequest) throws ExecutionException, InterruptedException {
        logger.info("Recieved request to update Product  : {} ", productRequest);

        Product product = productServices.updateProduct(productRequest);
        if (product.getProductId() != null)
            return new ResponseEntity(product, HttpStatus.OK);
        else
            return new ResponseEntity(productNotAvailable, HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/price")
    public ResponseEntity addProductPrice(@RequestBody PriceRequest priceRequest) {
        logger.info("Recieved request to add price  : {} ", priceRequest);
        return new ResponseEntity(priceService.addPrice(priceRequest), HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/price/{id}")
    @Async("threadPoolTaskExecutor")
    public ResponseEntity getPriceById(@PathVariable("id") String productId) throws ExecutionException, InterruptedException {
        logger.info("Recieved request to get  price  by Product id : {}  ", productId);
        ProductPrice productPrice = priceService.getPriceById(productId).get();
        if (productPrice.getProductId() != null)
            return new ResponseEntity(productPrice, HttpStatus.OK);
        else
            return new ResponseEntity(productNotAvailable, HttpStatus.BAD_REQUEST);
    }


    @GetMapping(value = "/product-details/{id}")
    public ResponseEntity getPrpductInfo(@PathVariable("id") String productId) {
        logger.info("Recieved request to get  price  by Product id : {}  ", productId);
        return new ResponseEntity(productDetailsServices.getProductResult(productId), HttpStatus.OK);
    }
}
