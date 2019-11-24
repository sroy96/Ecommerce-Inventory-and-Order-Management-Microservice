package com.vedantu.vedantu.DAO;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart {


    private Map<String, Integer> itemList= new HashMap<>();


    public Cart() {
    }

    public Cart(Map<String, Integer> itemList) {
        this.itemList = itemList;

    }

    public Map<String, Integer> getItemList() {
        return itemList;
    }

    public void setItemList(Map<String, Integer> itemList) {
        this.itemList = itemList;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "itemList=" + itemList +
                '}';
    }
}

