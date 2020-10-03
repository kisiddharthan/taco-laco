# Taco Loco

Java Services to calculate Taco Ordered

Veggie Taco, $2.50 ea. 

Chicken or Beef Taco, $3.00 ea. 

Chorizo Taco, $3.50 ea. 

If a customer orders 4 or more tacos, 
then a 20% discount will be applied to the entire order

#### Endpoints

Actuator Health Check Endpoint http://localhost:8080/actuator/health

Get Total Endpoint http://localhost:8080/getTotal

TacoRequest Example

{ 
    "tacoVeggie": 4,
    "tacoChickenBeef" : 0,
    "tacoChorizo" : 0
}
