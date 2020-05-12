package com.ujjain.asyncapi.sampleasync.service;

import com.ujjain.asyncapi.sampleasync.model.Price;
import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.ProductResponse;
import com.ujjain.asyncapi.sampleasync.services.PriceService;
import com.ujjain.asyncapi.sampleasync.services.ProductDetailsServices;
import com.ujjain.asyncapi.sampleasync.services.ProductServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.when;

/**
 * Created by abhishekujjain on 11/05/20.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsServicesTest {

    @Mock
    PriceService priceService;

    @Mock
    ProductServices productServices;

    @InjectMocks
    ProductDetailsServices productDetailsServices;


    @Test
    public void getProductDetails_forValidProduct() throws ExecutionException, InterruptedException {
        Product product = new Product();
        product.setProductId("1122");
        product.setTitle("test1");

        ProductPrice productPrice = new ProductPrice();
        Price price = new Price();
        price.setMax(34);
        price.setMin(14);
        price.setRange("15-20");
        productPrice.setPrice(price);

        ProductResponse productResponse = new ProductResponse();

        when(productServices.findProductById("1122")).thenReturn(CompletableFuture.completedFuture(product));
        when(priceService.getPriceById("1122")).thenReturn(CompletableFuture.completedFuture(productPrice));

        CompletableFuture<Product> productCompletableFuture = productServices.findProductById("1122");
        CompletableFuture <ProductPrice> priceCompletableFuture = priceService.getPriceById("1122");

        productResponse.setProductPrice(priceCompletableFuture.get());
        productResponse.setProduct(productCompletableFuture.get());

        ProductResponse response = productDetailsServices.getProductResult("1122");
        Assert.assertEquals(response.getProduct(),productCompletableFuture.get());

    }


}
