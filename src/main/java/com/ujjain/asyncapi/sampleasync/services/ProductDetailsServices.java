package com.ujjain.asyncapi.sampleasync.services;

import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by abhishekujjain on 11/05/20.
 */
@Service
public class ProductDetailsServices {
    public static final Logger log = LoggerFactory.getLogger(ProductDetailsServices.class);
    @Autowired
    ProductServices productServices;

    @Autowired
    PriceService priceService;


    public ProductResponse getProductResult(String productId) {
        ProductResponse productResponse = new ProductResponse();
        CompletableFuture<Product> productCompletableFuture = productServices.findProductById(productId);
        CompletableFuture<ProductPrice> priceCompletableFuture = priceService.getPriceById(productId);
        CompletableFuture.allOf(priceCompletableFuture, priceCompletableFuture).join();
        try {
            if (productCompletableFuture.get().getProductId() != null)
                productResponse.setProduct(productCompletableFuture.get());
            if (priceCompletableFuture.get().getProductId() != null)
                productResponse.setProductPrice(priceCompletableFuture.get());

        } catch (InterruptedException e) {
            log.error("InterruptedException exception fetching prod details :{}", e.getMessage());
        } catch (ExecutionException e) {
            log.error("ExecutionException exception fetching prod details :{}", e.getMessage());

        }

        return productResponse;
    }

}
