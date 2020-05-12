package com.ujjain.asyncapi.sampleasync.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by abhishekujjain on 10/05/20.
 */

@Document
public class Product {


    @Id
    private String productId;
    private String sellerId;
    private String title;
    private String pageTitle;
    private String description;
    private String manufacturer;
    private Boolean isLowQuantity;
    private Boolean isSoldOut;
    private Boolean isBackorder;
    private Set<Metafield> metafields;
    private Boolean requiresShipping;
    private Boolean isVisible;
    private CustomDate publishedAt;
    private CustomDate createdAt;
    private CustomDate updatedAt;

    private WorkFlow workflow;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getLowQuantity() {
        return isLowQuantity;
    }

    public void setLowQuantity(Boolean lowQuantity) {
        isLowQuantity = lowQuantity;
    }

    public Boolean getSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(Boolean soldOut) {
        isSoldOut = soldOut;
    }

    public Boolean getBackorder() {
        return isBackorder;
    }

    public void setBackorder(Boolean backorder) {
        isBackorder = backorder;
    }

    public Boolean getRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(Boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }

    public Set<Metafield> getMetafields() {
        return metafields;
    }

    public void setMetafields(Set<Metafield> metafields) {
        this.metafields = metafields;
    }

    public CustomDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(CustomDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public CustomDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(CustomDate createdAt) {
        this.createdAt = createdAt;
    }

    public CustomDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(CustomDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public WorkFlow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(WorkFlow workflow) {
        this.workflow = workflow;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", title='" + title + '\'' +
                ", pageTitle='" + pageTitle + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isLowQuantity=" + isLowQuantity +
                ", isSoldOut=" + isSoldOut +
                ", isBackorder=" + isBackorder +
                ", metafields=" + metafields +
                ", requiresShipping=" + requiresShipping +
                ", isVisible=" + isVisible +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", workflow=" + workflow +
                '}';
    }
}
