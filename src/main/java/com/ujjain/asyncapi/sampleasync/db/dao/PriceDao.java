package com.ujjain.asyncapi.sampleasync.db.dao;

import com.ujjain.asyncapi.sampleasync.model.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public interface PriceDao extends MongoRepository<ProductPrice, String> {


    ProductPrice insert(ProductPrice priceRequest);

}
