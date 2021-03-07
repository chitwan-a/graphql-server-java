# graphql-server-java

This graphql server is a Spring boot application with Gradle build tool. As an example, shopping mart is considered in graphql schema where there are two entities for simplicity, Items and Customers. Both can act as seperate entities if we wnat to retrieve all item details or all customer details. Hierarchicaly, Items can be the child of Customer when we want to fetch what all items were bought by a customer.

Below are example queries to test the application:

1. Fetch all customers with items

 {
      
    customers {
      firstName
      lastName
      id
      items {
        name
        quantity
            }
              }
  }


2. Fetch all items

 {

    items{
      id
      name
      quantity
    }
  
}

3. Fetch customer with id

 {
    
    customerById(id:1) {
      firstName
      lastName
      id

  
                        }
  }