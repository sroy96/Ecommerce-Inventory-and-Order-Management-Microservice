package com.vedantu.vedantu.DAO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Orders {

    @Id
    private String trackId;
    private float orderTotal;
    private float totalDiscount;
    private float deliveryCharge;
    private String accountId;
    private DispatchItenary dispatchItenary;
    private String appliedCouponId;

    public Orders() {
    }

    public Orders(DispatchItenary dispatchItenary,String appliedCouponId, float orderTotal, float totalDiscount, float deliveryCharge, String accountId) {

        this.orderTotal = orderTotal;
        this.totalDiscount = totalDiscount;
        this.deliveryCharge = deliveryCharge;
        this.accountId = accountId;
        this.dispatchItenary = dispatchItenary;
        this.appliedCouponId=appliedCouponId;
    }

    public String getAppliedCouponId() {
        return appliedCouponId;
    }

    public void setAppliedCouponId(String appliedCouponId) {
        this.appliedCouponId = appliedCouponId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public DispatchItenary getDispatchItenary() {
        return dispatchItenary;
    }

    public void setDispatchItenary(DispatchItenary dispatchItenary) {
        this.dispatchItenary = dispatchItenary;
    }
}