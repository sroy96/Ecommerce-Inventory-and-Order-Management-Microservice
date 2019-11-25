package com.vedantu.vedantu.controller;

import com.vedantu.vedantu.DAO.Accounts;
import com.vedantu.vedantu.DAO.Cart;
import com.vedantu.vedantu.DAO.Inventory;
import com.vedantu.vedantu.DAO.Orders;
import com.vedantu.vedantu.Services.CreateOrderService;
import com.vedantu.vedantu.constants.ApiMapper;
import com.vedantu.vedantu.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoreController {

    @Autowired
    CreateOrderService createOrderService;

    @GetMapping(ApiMapper.GET_HEALTH)
    public ResponseEntity getHealth() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(ApiMapper.POST_ORDER)
    public ResponseEntity createOrder(@RequestHeader(AppConstants.ACCESS_TOKEN) String accessToken, @RequestBody Cart cart) {

        createOrderService.createOrder(accessToken,cart);
        return new ResponseEntity(HttpStatus.OK);
    }
        @PostMapping(ApiMapper.ACCOUNT_POST)
        public ResponseEntity newAccount(@RequestBody Accounts account){
            createOrderService.addAccount(account);
            return new ResponseEntity(HttpStatus.OK);
        }


        @PostMapping(ApiMapper.INVENTORY_POST)
        public ResponseEntity newInventory(@RequestBody Inventory inventory){
        createOrderService.addInventory(inventory);
        return  new ResponseEntity(HttpStatus.OK);
    }

   @PutMapping(ApiMapper.INVENTORY_PUT)
    public ResponseEntity updateInventory(@RequestBody Inventory inventory){
        createOrderService.changeInventory(inventory);
        return new ResponseEntity(HttpStatus.OK);
   }

}


