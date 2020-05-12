package com.ujjain.asyncapi.sampleasync.model.dto;

import com.ujjain.asyncapi.sampleasync.model.Metafield;
import com.ujjain.asyncapi.sampleasync.model.WorkFlow;

import java.util.Set;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public class ProductRequest {
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
    private WorkFlow workflow;


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

    public Set<Metafield> getMetafields() {
        return metafields;
    }

    public void setMetafields(Set<Metafield> metafields) {
        this.metafields = metafields;
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

    public WorkFlow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(WorkFlow workflow) {
        this.workflow = workflow;
    }


    @Override
    public String toString() {
        return "ProductRequest{" +
                "sellerId='" + sellerId + '\'' +
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
                ", workflow=" + workflow +
                '}';
    }
}
