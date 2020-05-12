package com.ujjain.asyncapi.sampleasync.services;

import com.ujjain.asyncapi.sampleasync.db.dao.PriceDao;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import com.ujjain.asyncapi.sampleasync.model.dto.PriceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by abhishekujjain on 11/05/20.
 */
@Service
public class PriceService {
    public static final Logger log = LoggerFactory.getLogger(PriceService.class);

    @Autowired
    PriceDao priceDao;

    @Autowired
    MongoTemplate mongoTemplate;

    public ProductPrice addPrice(PriceRequest priceRequest) {
        return priceDao.insert(priceRequest.getProductPrice());
    }


    public List<ProductPrice> getAllPrice() {
        return priceDao.findAll();
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<ProductPrice> getPriceById(String productId) {
        ProductPrice productPrice = mongoTemplate.findOne(
                query(Criteria.where("product_id").is(productId)), ProductPrice.class);
        if (productPrice != null)
            return CompletableFuture.completedFuture(productPrice);
        log.debug("No Product Available {}", productId);
        return CompletableFuture.completedFuture(new ProductPrice());

    }
}
