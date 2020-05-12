package com.ujjain.asyncapi.sampleasync.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujjain.asyncapi.sampleasync.db.dao.ProductDao;
import com.ujjain.asyncapi.sampleasync.model.CustomDate;
import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.dto.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by abhishekujjain on 10/05/20.
 */
@Service
public class ProductServices {
    public static final Logger log = LoggerFactory.getLogger(ProductServices.class);

    @Autowired
    ProductDao productDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public Product addProduct(ProductRequest data) {
        Product product = new Product();
        try {
            String req = objectMapper.writeValueAsString(data);
            product = objectMapper.readValue(req, Product.class);
            CustomDate customDate = new CustomDate();
            Date date = new Date();
            customDate.setDate(date);
            product.setCreatedAt(customDate);
            product.setPublishedAt(customDate);
            product.setUpdatedAt(customDate);
        } catch (JsonProcessingException e) {
            log.error("InterruptedException exception fetching prod details :{}", e.getMessage());

        }
        return productDao.insert(product);
    }

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public Product updateProduct(ProductRequest productRequest) throws ExecutionException, InterruptedException {
        Product product = new Product();
        try {
            String req = objectMapper.writeValueAsString(productRequest);
            product = objectMapper.readValue(req, Product.class);
            CustomDate customDate = new CustomDate();
            Date date = new Date();
            customDate.setDate(date);
            product.setUpdatedAt(customDate);
        } catch (JsonProcessingException e) {
            log.error("Json exception while updating product :{}", e.getMessage());
        }
        if (findProductById(product.getProductId()).get().getProductId() != null)
            return productDao.save(product);
        log.debug("Product is not availalble with given id,{}", product.getProductId());
        return new Product();
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<Product> findProductById(String productId) {

        Product product = mongoTemplate.findOne(
                query(Criteria.where("productId").is(productId)), Product.class);
        if (product != null)
            return CompletableFuture.completedFuture(product);

        return CompletableFuture.completedFuture(new Product());
    }


}
