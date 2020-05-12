package com.ujjain.asyncapi.sampleasync.model.dto;

import com.ujjain.asyncapi.sampleasync.model.ProductPrice;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public class PriceRequest {
    private ProductPrice productPrice;

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "PriceRequest{" +
                "productPrice=" + productPrice +
                '}';
    }
}
