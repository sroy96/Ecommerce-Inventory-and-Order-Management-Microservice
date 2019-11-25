package com.vedantu.vedantu.DAO;

import java.util.List;

public class AccountConfig {

    private boolean couponsAllowed;

    private boolean deliveryAllowed;

    private boolean internationalAllowed;

    private boolean cashAllowed;

    private List<String>allowedCoupons;


    public AccountConfig() {
    }

    public AccountConfig(boolean couponsAllowed,List<String>allowedCoupons, boolean deliveryAllowed, boolean internationalAllowed, boolean cashAllowed) {
        this.couponsAllowed = couponsAllowed;
        this.deliveryAllowed = deliveryAllowed;
        this.internationalAllowed = internationalAllowed;
        this.allowedCoupons=allowedCoupons;
        this.cashAllowed = cashAllowed;
    }

    public List<String> getAllowedCoupons() {
        return allowedCoupons;
    }

    public void setAllowedCoupons(List<String> allowedCoupons) {
        this.allowedCoupons = allowedCoupons;
    }

    public boolean isCouponsAllowed() {
        return couponsAllowed;
    }

    public void setCouponsAllowed(boolean couponsAllowed) {
        this.couponsAllowed = couponsAllowed;
    }

    public boolean isDeliveryAllowed() {
        return deliveryAllowed;
    }

    public void setDeliveryAllowed(boolean deliveryAllowed) {
        this.deliveryAllowed = deliveryAllowed;
    }

    public boolean isInternationalAllowed() {
        return internationalAllowed;
    }

    public void setInternationalAllowed(boolean internationalAllowed) {
        this.internationalAllowed = internationalAllowed;
    }

    public boolean isCashAllowed() {
        return cashAllowed;
    }

    public void setCashAllowed(boolean cashAllowed) {
        this.cashAllowed = cashAllowed;
    }
}
