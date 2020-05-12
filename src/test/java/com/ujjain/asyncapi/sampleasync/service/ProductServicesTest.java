package com.ujjain.asyncapi.sampleasync.service;

import com.ujjain.asyncapi.sampleasync.db.dao.PriceDao;
import com.ujjain.asyncapi.sampleasync.db.dao.ProductDao;
import com.ujjain.asyncapi.sampleasync.model.Price;
import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.PriceRequest;
import com.ujjain.asyncapi.sampleasync.model.dto.ProductRequest;
import com.ujjain.asyncapi.sampleasync.services.PriceService;
import com.ujjain.asyncapi.sampleasync.services.ProductServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by abhishekujjain on 11/05/20.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductServicesTest {

    @Mock
    ProductServices productServices;



    @Test
    public void insertData() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setPageTitle("test");
        Product product = new Product();
        product.setTitle("test");
        when(productServices.addProduct(productRequest)).thenReturn(product);
        Product productRes = productServices.addProduct(productRequest);
        Assert.assertEquals(productRes.getTitle(),product.getTitle());
    }

    @Test
    public void updateData() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setPageTitle("test");
        Product product = new Product();
        product.setTitle("test1");
        when(productServices.updateProduct(productRequest)).thenReturn(product);
        Product productRes = productServices.updateProduct(productRequest);
        Assert.assertEquals(product.getTitle(),productRes.getTitle());
    }

    @Test
    public void findProductById() throws ExecutionException, InterruptedException {
        Product product = new Product();
        product.setProductId("1122");
        product.setTitle("test1");
        when(productServices.findProductById("1122")).thenReturn(CompletableFuture.completedFuture(product));
        CompletableFuture<Product> productRes = productServices.findProductById("1122");
        Assert.assertEquals(product.getProductId(),productRes.get().getProductId());
    }
}
