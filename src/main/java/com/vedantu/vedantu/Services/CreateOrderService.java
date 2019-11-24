package com.vedantu.vedantu.Services;

import com.vedantu.vedantu.DAO.*;
import com.vedantu.vedantu.ExceptionHandler.AppException;
import com.vedantu.vedantu.Repositories.AccountRepository;
import com.vedantu.vedantu.Repositories.InventoryRepository;
import com.vedantu.vedantu.Repositories.OrderRepository;
import com.vedantu.vedantu.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateOrderService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    OrderRepository orderRepository;

    //get

    //post
    public void createOrder(Cart cart){
                Orders orders = new Orders();
                DispatchItenary dispatchItenary = new DispatchItenary();
                Map<String, >
              Map<String, Integer>map =cart.getItemList();
              for(Map.Entry mapElement : map.entrySet()){
                  Inventory inventory = inventoryRepository.findByItemId((String)mapElement.getKey());
                  OrderConfig orderConfig= new OrderConfig();
                  orderConfig.setCountryCode(inventory.getCountryCode());
                  orderConfig.setInventoryCategory(inventory.getInventoryCategory());
                  orderConfig.setInventoryConfig(inventory.getInventoryConfig());
                  orderConfig.setItemName(inventory.getItemName());
                  orderConfig.setRetailerAddress(inventory.getManufactureLocation());
                  orderConfig.setItemPricePerPiece(inventory.getBasePrice());

              }

        }

        public void createItenary(){

        }



    public void addAccount(Accounts accounts){

    }

    public  void addInventory(Inventory inventory){

    }


    //put

    //delete

    private interface  validate{
      public void validate();

    }

}
