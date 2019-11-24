package com.vedantu.vedantu.DAO;

import java.util.List;

public class OrderConfig {
    private String itemName;
    private Address retailerAddress;
    private InventoryConfig inventoryConfig;
    private  InventoryCategory inventoryCategory;
    private  CountryCode countryCode;
    private  float itemPricePerPiece;
    public OrderConfig() {
    }

    public OrderConfig(String itemName,float itemPricePerPiece, Address retailerAddress, InventoryConfig inventoryConfig, InventoryCategory inventoryCategory, CountryCode countryCode) {
        this.itemName = itemName;
        this.retailerAddress = retailerAddress;
        this.inventoryConfig = inventoryConfig;
        this.inventoryCategory = inventoryCategory;
        this.countryCode = countryCode;
        this.itemPricePerPiece= itemPricePerPiece;
    }

    public float getItemPricePerPiece() {
        return itemPricePerPiece;
    }

    public void setItemPricePerPiece(float itemPricePerPiece) {
        this.itemPricePerPiece = itemPricePerPiece;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Address getRetailerAddress() {
        return retailerAddress;
    }

    public void setRetailerAddress(Address retailerAddress) {
        this.retailerAddress = retailerAddress;
    }

    public InventoryConfig getInventoryConfig() {
        return inventoryConfig;
    }

    public void setInventoryConfig(InventoryConfig inventoryConfig) {
        this.inventoryConfig = inventoryConfig;
    }

    public InventoryCategory getInventoryCategory() {
        return inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }
}
