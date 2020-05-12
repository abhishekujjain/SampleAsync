package com.ujjain.asyncapi.sampleasync.service;

import com.ujjain.asyncapi.sampleasync.model.Price;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.PriceRequest;
import com.ujjain.asyncapi.sampleasync.services.PriceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by abhishekujjain on 11/05/20.
 */

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {

    @Mock
    PriceService priceService;


    @Test
    public void insertData() throws Exception {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProductId("1122");
        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setProductPrice(productPrice);
        when(priceService.addPrice(priceRequest)).thenReturn(productPrice);
        ProductPrice productRes = priceService.addPrice(priceRequest);
        Assert.assertEquals(productRes.getProductId(), productPrice.getProductId());
    }



    @Test
    public void findPricebyid() throws ExecutionException, InterruptedException {
        ProductPrice productPrice = new ProductPrice();
        Price price = new Price();
        price.setMax(34);
        price.setMin(14);
        price.setRange("15-20");
        productPrice.setPrice(price);
        when(priceService.getPriceById("3344")).thenReturn(CompletableFuture.completedFuture(productPrice));
        CompletableFuture<ProductPrice> priceCompletableFuture = priceService.getPriceById("3344");
        Assert.assertEquals(price.getMax(), priceCompletableFuture.get().getPrice().getMax());
    }
}
