package com.vedantu.vedantu.Services;

import com.vedantu.vedantu.DAO.*;
import com.vedantu.vedantu.ExceptionHandler.AppException;
import com.vedantu.vedantu.Repositories.AccountRepository;
import com.vedantu.vedantu.Repositories.InventoryRepository;
import com.vedantu.vedantu.Repositories.OrderRepository;
import com.vedantu.vedantu.constants.AppConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.vedantu.vedantu.DAO.InventoryCategory.LARGE;

@Service
public class CreateOrderService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    OrderRepository orderRepository;



    public String createBillNo(){
        return "#"+"150"+ RandomStringUtils.randomAlphanumeric(7);
    }


    public void updatedInventory(Inventory inventoryDetail){
        Inventory inventory = new Inventory();
        inventory.setAvailableUnits(inventoryDetail.getAvailableUnits()-1);
        inventory.setBasePrice(inventoryDetail.getBasePrice());
        inventory.setCountryCode(inventoryDetail.getCountryCode());
        inventory.setCreatedAt(inventoryDetail.getCreatedAt());
        if(inventoryDetail.getAvailableUnits()-1 >=1) {
            inventory.setCurrentUseLock(AppConstants.RELEASE);
        }
        else{
            inventory.setCurrentUseLock(AppConstants.LOCK);
        }
        inventory.setMaxDiscountAllowed(inventoryDetail.getMaxDiscountAllowed());
        inventory.setInventoryConfig(inventoryDetail.getInventoryConfig());
        inventory.setItemId(inventoryDetail.getItemId());
        inventory.setItemName(inventoryDetail.getItemName());
        inventory.setInventoryCategory(inventoryDetail.getInventoryCategory());
        inventory.setManufactureLocation(inventoryDetail.getManufactureLocation());
        inventory.setUpdatedAt(inventoryDetail.getUpdatedAt());
        inventory.setMinCommission(inventoryDetail.getMinCommission());
        inventory.setManufacturer(inventoryDetail.getManufacturer());
        inventoryRepository.save(inventory);
    }

    public float extraCharges(String ItemCode){
        Inventory inventory= inventoryRepository.findByItemId(ItemCode);
        float sum=0;
        if(inventory.getInventoryConfig().isAntique()){
            sum=sum+AppConstants.ANTIQUE_CHARGE;
        }
        if(inventory.getInventoryConfig().isFragile()){
            sum=sum+AppConstants.FRAGILE_CHARGE;
        }
        if(inventory.getInventoryConfig().isPremium()){
            sum=sum+AppConstants.PREMIUM_CHARGE;
        }
        if(inventory.getInventoryCategory().equals(LARGE)){
            sum=sum+AppConstants.LARGE_BOX_CHARGE;
        }
        return sum;
    }


    /**
     *
     * @param cart
     */
    public void createOrder(String token,Cart cart){
                Orders orders = new Orders();
                DispatchItenary dispatchItenary = new DispatchItenary();
                Map<String, OrderConfig>orderDetails= new HashMap<>();
              Map<String, Integer>map =cart.getItemList();
              float orderTotal= 0;
              float discount=0;
              float commission=0;
              float extra=0;
              for(Map.Entry mapElement : map.entrySet()){
                  Inventory inventory = inventoryRepository.findByItemId((String)mapElement.getKey());
                  if(inventory!=null &&
                          inventory.getInventoryConfig().isSellable() &&
                          inventory.getCurrentUseLock().equals(AppConstants.RELEASE)) {

                      String orderId = "#" + inventory.getItemId() + inventory.getItemName().substring(0, inventory.getItemName().length() / 2);
                      OrderConfig orderConfig = new OrderConfig();
                      orderConfig.setCountryCode(inventory.getCountryCode());
                      orderConfig.setInventoryCategory(inventory.getInventoryCategory());
                      orderConfig.setInventoryConfig(inventory.getInventoryConfig());
                      orderConfig.setItemName(inventory.getItemName());
                      orderConfig.setRetailerAddress(inventory.getManufactureLocation());
                      orderConfig.setItemPricePerPiece(inventory.getBasePrice());

                      orderDetails.put(orderId, orderConfig);
                      orderTotal = orderTotal + ((int) mapElement.getValue() * inventory.getBasePrice());
                      discount = discount + inventory.getMinCommission();
                      commission = commission + inventory.getMaxDiscountAllowed();
                      extra=extra+ extraCharges((String)mapElement.getKey());
                      updatedInventory(inventory);
                  }
                  else{
                      throw  new AppException(AppConstants.ITEM_NOT_AVAILABLE);
                  }
              }
              String billNo= createBillNo();
              orders.setTrackId(billNo);
              orders.setOrderTotal(orderTotal-discount+commission+AppConstants.DELIVERY_CHARGE);
              orders.setDeliveryCharge(AppConstants.DELIVERY_CHARGE);
              orders.setTotalDiscount(discount);
         Map<String ,Map<String, OrderConfig>>dispatchMap = new HashMap<String ,Map<String, OrderConfig>>();
            dispatchMap.put(billNo,orderDetails);
            dispatchItenary.setDispatchMap(dispatchMap);
            orders.setDispatchItenary(dispatchItenary);
            orders.setAccountId(AppConstants.ACCESS_TOKEN);

            orderRepository.save(orders);

    }

    public void addAccount(Accounts accounts){
            accountRepository.save(accounts);
    }

    public  void addInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void validate(String ItemId){
        if(inventoryRepository.findByItemId(ItemId).getAvailableUnits()<=0){
            throw  new AppException("Item is out of Stock");
        }
        if(!inventoryRepository.findByItemId(ItemId).getInventoryConfig().isSellable()){
            throw  new AppException("Item cannot be Sold");
        }

    }


    public List<Orders> showOrders() {
        return orderRepository.findAll();
    }
}
