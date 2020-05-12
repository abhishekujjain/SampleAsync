package com.ujjain.asyncapi.sampleasync.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by abhishekujjain on 10/05/20.
 */
@Document
public class ProductPrice  {
    @Id
    private String product_id;
    private Price price;

    public String getProductId() {
        return product_id;
    }

    public void setProductId(String product_id) {
        this.product_id = product_id;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product_id='" + product_id + '\'' +
                ", price=" + price +
                '}';
    }
}
