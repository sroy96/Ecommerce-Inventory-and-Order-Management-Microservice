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


    /**
     * Creating a random Bill Number
     * @return
     */
    public String createBillNo(){
        return "#"+"150"+ RandomStringUtils.randomAlphanumeric(7);
    }

    /**
     * Update after POST request of creating order to make changes in Inventor DB [LOCK/RELEASE] and quantity update
     * @param inventoryDetail
     * @param count
     */
    public void updatedInventory(Inventory inventoryDetail, int count){
        Inventory inventory = new Inventory();
        inventory.setAvailableUnits(inventoryDetail.getAvailableUnits()-count);
        inventory.setBasePrice(inventoryDetail.getBasePrice());
        inventory.setCountryCode(inventoryDetail.getCountryCode());
        inventory.setCreatedAt(inventoryDetail.getCreatedAt());
        if(inventoryDetail.getAvailableUnits()-count > 1) {
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

    /**
     * Extra Charge on the Basis of
     * @param ItemCode
     * @return
     */

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


        return sum;
    }

    /**
     * Validating the User on the basis of HTTP Header Request
     * @param accessId
     * @return
     */

    public boolean validateUserId(String accessId){
        boolean userAuth=false;
        Accounts accounts= accountRepository.findByUserProfileId(accessId);
        if(accounts.getAccountId()!= null){
            userAuth=true;
        }
        else{
            throw  new AppException(AppConstants.USER_INVALID);
        }
        return userAuth;
    }

    /**
     * Fething the Country Code of the User to Levy International Charges.
     * @param userToken
     * @return
     */

public CountryCode userCountryCode(String userToken){
    Accounts accounts= accountRepository.findByUserProfileId(userToken);
    return accounts.getCountryCode();

}

    /**
     * Validating the Coupon Code passed in JSON body with User eligibility and total amount discounted
     * @param accountToken
     * @param cart
     * @return
     */

    public float couponCodes(String accountToken,Cart cart) {
        float discount;
        if(cart.getCouponApplied()!=null) {

            String coupon = cart.getCouponApplied();
            Accounts accounts =  accountRepository.findByUserProfileId(accountToken);
            List<String> allowedCoupons = accounts.getAccountConfig().getAllowedCoupons();
            boolean isCouponAllowed = false;
            for (String allowedCoupon : allowedCoupons) {
                if (coupon.equals(allowedCoupon)) {
                    isCouponAllowed = true;
                    break;
                }

            }


            switch (coupon) {
                case "VEDANTU30":
                    discount = AppConstants.VEDANTU30_COUPON;
                    break;
                case "LEARNED":
                    discount = AppConstants.LEARNED_COUPON;
                    break;
                case "TEACHINDIA":
                    discount = AppConstants.TEACHINDIA_COUPON;
                case "GROWINDIA":
                    discount = AppConstants.GROWINDIA_COUPON;
                default:
                    discount = (float) 0.0;
                    break;
            }
            if(accounts.getAccountConfig().isCouponsAllowed()) {

                if (isCouponAllowed) {
                    return discount;
                } else {
                    return 0;
                }
            }else{
                return 0;
            }

        }
        else{
            return 0;
        }
    }

    /**
     *Creating the Order
     * @param accountToken Validate the User Session
     * @param cart Take input of the Item and Quantity and other details to validate and calculate the price
     */
    public void createOrder(String accountToken,Cart cart){

        if(validateUserId(accountToken)) {

            Orders orders = new Orders();
            DispatchItenary dispatchItenary = new DispatchItenary();
            Map<String, OrderConfig> orderDetails = new HashMap<>();
            Map<String, Integer> map = cart.getItemList();
            float orderTotal = 0;
            float discount = 0;
            float commission = 0;
            float extra = 0;
            float internationalCharge=0;
            for (Map.Entry mapElement : map.entrySet()) {
                Inventory inventory = inventoryRepository.findByItemId((String) mapElement.getKey());
                if (inventory != null &&
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
                    if(userCountryCode(accountToken).equals(inventory.getCountryCode())){
                        internationalCharge=internationalCharge+0;
                    }
                    else if(!userCountryCode(accountToken).equals(inventory.getCountryCode()) && inventory.getInventoryConfig().isInternationalAllowed()){
                        internationalCharge=internationalCharge+AppConstants.INTERNATIONAL_CHARGE;
                    }
                    orderTotal = orderTotal + ((int) mapElement.getValue() * inventory.getBasePrice());
                    discount = discount + inventory.getMinCommission();
                    commission = commission + inventory.getMaxDiscountAllowed();
                    extra = extra + extraCharges((String) mapElement.getKey()) * (int) mapElement.getValue();
                    orderDetails.put(orderId, orderConfig);
                    updatedInventory(inventory, (int) mapElement.getValue());

                } else {
                    throw new AppException(AppConstants.ITEM_NOT_AVAILABLE);
                }
            }

            float couponCodeDiscount = couponCodes(accountToken, cart);

            String billNo = createBillNo();
            orders.setTrackId(billNo);
            orders.setOrderTotal(orderTotal - discount + commission + AppConstants.DELIVERY_CHARGE + extra -couponCodeDiscount + internationalCharge);
            orders.setDeliveryCharge(AppConstants.DELIVERY_CHARGE);
            orders.setTotalDiscount(discount);
            Map<String, Map<String, OrderConfig>> dispatchMap = new HashMap<String, Map<String, OrderConfig>>();
            dispatchMap.put(billNo, orderDetails);
            dispatchItenary.setDispatchMap(dispatchMap);
            orders.setDispatchItenary(dispatchItenary);
            orders.setAccountId(AppConstants.ACCESS_TOKEN);
            orders.setAppliedCouponId(cart.getCouponApplied());

            orderRepository.save(orders);
        }
        else{
            throw  new AppException(AppConstants.USER_INVALID);
        }

    }

    /**
     *
     * @param accounts
     */
    public void addAccount(Accounts accounts){
            accountRepository.save(accounts);
    }

    /**
     *
     * @param inventory
     */

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

    /**
     *
     * @param inventory
     */

   public void changeInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
