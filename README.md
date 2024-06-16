1. run this project with port:8081
2. use postman to test 
  2.1: endpoint: http://localhost:8081/orders
  2.2: payload:
{
"customerName": "Norbert Bautista",
"customerEmail": "norbert.bautista@gmail.com",
"totalPrice": 100.50,
"products": [
{
"productId": 1,
"quantity": 2
},
{
"productId": 2,
"quantity": 1
}
]
}