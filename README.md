# E-Commerce Ordering Microservice

This is the Solution to the problem statement given by Vedantu.

### System Requirements:
- Java 1.8
- Apache Maven 
- Spring Boot
- Git (For Version Control)
- MongoDB Compass / Atlas

### Versioning
   
 The folder also contains a .git file. Please check the version history using "git log" & "git diff" commands.
 
### Sample Test Cases & Outputs for Reference

## Adding Accounts

To add Account with all the configurations and Coupons allowed we make a POST request with body as [Testing Restricted International Orders] :
````
API for POST - localhost:8080/add/account
````
--------
````
{
	"accountId":"#140LOWP",
	"userProfileId":"account1",
	"address":{
		"lineNumber1":"108, ISTHARA",
		"lineNumber2":"Sri Ram nagar, Kondapur",
		"city":"Hyderabad",
		"state":"Telangana",
		"country":"IN",
		"postalCode":"500084"
	},
	"taxationNumber": "BXIPR3475W",
	"accountConfig": {
		"couponsAllowed":true,
		"allowedCoupons":["LEARNED","VEDANTU30"],
		"cashAllowed":false,
		"internationalAllowed":false,
		"deliveryAllowed":true
	},
	"userDetails":{
		"emailAddress":"sauravroy.eee@gmail.com",
		"phoneNumber":"9585386951",
		"phoneCode":"+91"
	},
	"countryCode":"IN"
	
	
	
}
````
- Adding an Account with POST request [Testing International Ordering Allowed]:

````
{
	"accountId":"#140ABC",
	"userProfileId":"account2",
	"address":{
		"lineNumber1":"8,OYO Life",
		"lineNumber2":"Q city, Nanakramguda",
		"city":"Hyderabad",
		"state":"Telangana",
		"country":"IN",
		"postalCode":"500032"
	},
	"taxationNumber": "BXIPR3831R",
	"accountConfig": {
		"couponsAllowed":true,
		"allowedCoupons":["TEACHINDIA","GROWINDIA"],
		"cashAllowed":false,
		"internationalAllowed":true,
		"deliveryAllowed":true
	},
	"userDetails":{
		"emailAddress":"sauravroy.eee@gmail.com",
		"phoneNumber":"9585386951",
		"phoneCode":"+91"
	},
	"countryCode":"IN"
	
	
	
}
````
## Adding Inventory
 Adding Items in Inventory with all the Inventory Classifications using POST request:
 
 ````
 API to add Inventory: localhost:8080/add/store
 ````
- Inventory POST request with International delivery enabled.
````
{
	"itemId":"AcrPaint",
	"itemName":"Acrylic Paint",
	"manufacturer":"Color Party",
	"manufactureLocation":{
		"lineNumber1":"William Sons",
		"lineNumber2":"2 nd Square, 3rd Stree",
		"city":"Texas",
		"state":"Chicago",
		"country":"US",
		"postalCode":"180032"
	},
	"basePrice":300.0,
	"maxDiscountAllowed":50.0,
	"minCommission":10.0,
	"inventoryConfig":{
		"canReturn":false,
		"sellable":true,
		"canReplace":true,
		"repairInsurance":true,
		"internationalAllowed":true,
		"fragile":true,
		"antique":false,
		"premium":true
		
	},
	"createdAt":2909331,
	"updatedAt":3012029,
	"InventoryCategory": "LARGE",
	"currentUseLock":"Release",
	"countryCode":"US",
	"availableUnits":11

	
}
````
- Sending JSON body using POST request given above:
````
{
	"itemId":"ROMstore",
	"itemName":"KeyBoard",
	"manufacturer":"InfoSoft",
	"manufactureLocation":{
		"lineNumber1":"Chandi Market",
		"lineNumber2":"Nukkad Char Rasta",
		"city":"Haridwar",
		"state":"Uttar Pradesh",
		"country":"IN",
		"postalCode":"300078"
	},
	"basePrice":700.0,
	"maxDiscountAllowed":50.0,
	"minCommission":10.0,
	"inventoryConfig":{
		"canReturn":false,
		"sellable":true,
		"canReplace":true,
		"repairInsurance":true,
		"internationalAllowed":false,
		"fragile":true,
		"antique":false,
		"premium":true
		
	},
	"createdAt":2909331,
	"updatedAt":3012029,
	"InventoryCategory": "LARGE",
	"currentUseLock":"Release",
	"countryCode":"IN",
	"availableUnits":3

	
}
````

### CREATING ORDER WHICH INCLUDE THE FOLLOWING DETAILS

1. Map of object Id and Quantity of object required.
2. Coupon Used in Order to get discount.

- The JSON body for the post request must include the Headers for "access-token" as userProfileId.
- The POST API to be called is :
````
API :  localhost:8080/create
````
- JSON body For Demonstrating the International ordering and also the coupon eligibility of the User:
 ````
 {
 		"itemList" : {
		"AcrPaint":2,
		"ROMstore":1
	
 		},
 		"couponApplied":"VEDANTU30"
 		
 	}
 ````
- JSON body For Demonstrating the non- International ordering and also the coupon eligibility of the difference User:
  (Kindly change the Headers to "access-token" : account1 )
````
 {
 		"itemList" : {
		"AcrPaint":5,
		"ROMstore":1
	
 		},
 		"couponApplied":"TEACHINDIA"
 		
 	}
 ````
 
 ### Multiple Functionality and Exceptions are Handled Some of them are:
 
 - Inventory keeps a check on the availability of the stock.
 - Locks the Inventory while the demand is more than supply.
 -  Charges are levied on multiple basis including Account Classification, Inventory Classification, Order Classification.
 - It keeps a Check while posting the order about the  HTTP Header Request which is passed by the HTTP session matching unique ID.
 - Coupons are an add on which enables discount for users who are eligible.
 -  There are many more checks which are being taken care off. [Please Refer the Code ].
 
 ### TODO for more scalibility:
 
 - During Flash Sale if the inventory count is 5 and 10 users are trying to access it , 
 we can lock the inventory for first 5 users and release for other 5 for a amount of time, and vice versa after that periodto prevent deadlock case.
 
 - For International Transfers the Cash Payment Eligibility is pulled down instead of which the instant currency conversion microservice can hit any converter to do the same on real time basis.
 
  
 