package com.ujjain.asyncapi.sampleasync.db.dao;

import com.ujjain.asyncapi.sampleasync.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhishekujjain on 10/05/20.
 */

public interface ProductDao extends MongoRepository<Product, String> {
}
