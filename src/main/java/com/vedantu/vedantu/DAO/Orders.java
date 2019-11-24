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
    private String itemId;
    private Cart cart;
    private int orderTotal;
    private int totalDiscount;
    private int deliveryCharge;
    private String accountId;
    private OrderConfig orderConfig;
    private String checkout;
    //dipatch
    private DispatchItenary dispatchItenary;

    public Orders() {
    }

    public Orders(Cart cart,DispatchItenary dispatchItenary, int orderTotal,String itemId, int totalDiscount, int deliveryCharge, String accountId, String checkout) {
        this.cart = cart;
        this.orderTotal = orderTotal;
        this.totalDiscount = totalDiscount;
        this.deliveryCharge = deliveryCharge;
        this.accountId = accountId;
        this.checkout = checkout;
        this.itemId= itemId;
        this.dispatchItenary=dispatchItenary;
    }

    public DispatchItenary getDispatchItenary() {
        return dispatchItenary;
    }

    public void setDispatchItenary(DispatchItenary dispatchItenary) {
        this.dispatchItenary = dispatchItenary;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public OrderConfig getOrderConfig() {
        return orderConfig;
    }

    public void setOrderConfig(OrderConfig orderConfig) {
        this.orderConfig = orderConfig;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
