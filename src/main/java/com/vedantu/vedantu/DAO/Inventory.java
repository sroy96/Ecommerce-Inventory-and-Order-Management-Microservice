package com.vedantu.vedantu.DAO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Inventory {

    @Id
    private String itemId;
    private String itemName;
    private String manufacturer;
    private Address manufactureLocation;
    private float basePrice;
    private float maxDiscountAllowed;
    private float minCommission;
    private InventoryConfig inventoryConfig;
    private long createdAt;
    private long updatedAt;
    private InventoryCategory inventoryCategory;
    private String currentUseLock;
    private  CountryCode countryCode;
    private int availableUnits;

    public Inventory() {
    }

    public Inventory(String itemName, CountryCode countryCode,String manufacturer, Address manufactureLocation, float basePrice, float maxDiscountAllowed, float minCommission, InventoryConfig inventoryConfig, long createdAt, long updatedAt, InventoryCategory inventoryCategory, String currentUseLock, int availableUnits) {
        this.itemName = itemName;
        this.manufacturer = manufacturer;
        this.manufactureLocation = manufactureLocation;
        this.basePrice = basePrice;
        this.maxDiscountAllowed = maxDiscountAllowed;
        this.minCommission = minCommission;
        this.inventoryConfig = inventoryConfig;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.inventoryCategory = inventoryCategory;
        this.currentUseLock = currentUseLock;
        this.availableUnits = availableUnits;
        this.countryCode= countryCode;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Address getManufactureLocation() {
        return manufactureLocation;
    }

    public void setManufactureLocation(Address manufactureLocation) {
        this.manufactureLocation = manufactureLocation;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public float getMaxDiscountAllowed() {
        return maxDiscountAllowed;
    }

    public void setMaxDiscountAllowed(float maxDiscountAllowed) {
        this.maxDiscountAllowed = maxDiscountAllowed;
    }

    public float getMinCommission() {
        return minCommission;
    }

    public void setMinCommission(float minCommission) {
        this.minCommission = minCommission;
    }

    public InventoryConfig getInventoryConfig() {
        return inventoryConfig;
    }

    public void setInventoryConfig(InventoryConfig inventoryConfig) {
        this.inventoryConfig = inventoryConfig;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public InventoryCategory getInventoryCategory() {
        return inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    public String getCurrentUseLock() {
        return currentUseLock;
    }

    public void setCurrentUseLock(String currentUseLock) {
        this.currentUseLock = currentUseLock;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }
}
