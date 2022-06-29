# InfoGainAssignment
InfoGainAssignment.(Use the pom.xml to build the project using Maven)

The project is created in Intellij IDE and has files to run a spring boot app. Once the spring Boot app is up and running you would have three rest end points that are available to call as listed below.

1) To get list of customers that bought items and made transactions in three months.

End Point: http://localhost:8080/v1/getCustomerList

Each time you call the end point, customers with random amounts in a HashMap will be created as there is no database, with their id and name and their total transaction amount. If created list of customers will be sent as a response along with 200 STATUS OK code. 

PS : ** If you dont run the above end point customers list will be empty and none of the below end points will work ** 

2) Once you have the list of customers you can use their id to check the points they gained.

End point : http://localhost:8080/v1/getCustomerPoints/{id}
ex: http://localhost:8080/v1/getCustomerPoints/3

3) You can also simply calculate the points for the given amount at the end point.

End point : http://localhost:8080/v1/getCustomerPointsUsingAmountSpent/{amount}
ex: http://localhost:8080/v1/getCustomerPointsUsingAmountSpent/450


