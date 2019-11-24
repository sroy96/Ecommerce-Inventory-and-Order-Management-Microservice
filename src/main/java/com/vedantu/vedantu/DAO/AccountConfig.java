package com.vedantu.vedantu.DAO;

import java.util.List;

public class AccountConfig {

    private boolean isCouponsAllowed;

    private boolean isDeliveryAllowed;

    private boolean isInternationalAllowed;

    private boolean isCashAllowed;

    private List<String> excludeCoupons;

    public AccountConfig() {
    }

    public AccountConfig(boolean isCouponsAllowed, boolean isDeliveryAllowed, boolean isInternationalAllowed, boolean isCashAllowed, List<String> excludeCoupons) {
        this.isCouponsAllowed = isCouponsAllowed;
        this.isDeliveryAllowed = isDeliveryAllowed;
        this.isInternationalAllowed = isInternationalAllowed;
        this.isCashAllowed = isCashAllowed;
        this.excludeCoupons = excludeCoupons;
    }

    public boolean isCouponsAllowed() {
        return isCouponsAllowed;
    }

    public void setCouponsAllowed(boolean couponsAllowed) {
        isCouponsAllowed = couponsAllowed;
    }

    public boolean isDeliveryAllowed() {
        return isDeliveryAllowed;
    }

    public void setDeliveryAllowed(boolean deliveryAllowed) {
        isDeliveryAllowed = deliveryAllowed;
    }

    public boolean isInternationalAllowed() {
        return isInternationalAllowed;
    }

    public void setInternationalAllowed(boolean internationalAllowed) {
        isInternationalAllowed = internationalAllowed;
    }

    public boolean isCashAllowed() {
        return isCashAllowed;
    }

    public void setCashAllowed(boolean cashAllowed) {
        isCashAllowed = cashAllowed;
    }

    public List<String> getExcludeCoupons() {
        return excludeCoupons;
    }

    public void setExcludeCoupons(List<String> excludeCoupons) {
        this.excludeCoupons = excludeCoupons;
    }
}
