package com.ujjain.asyncapi.sampleasync.model.dto;

import com.ujjain.asyncapi.sampleasync.model.Product;
import com.ujjain.asyncapi.sampleasync.model.ProductPrice;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public class ProductResponse {
    Product product;
    ProductPrice productPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }
}
