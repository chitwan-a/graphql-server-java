package common;

import dao.DAO;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLDataFetcher {

    public DataFetcher getCustomerByIdFetcher() {
        return dataFetchingEnvironment -> {
            String customerId = dataFetchingEnvironment.getArgument("id");
            return DAO.getAllCustomers().stream().filter(customer -> customer.getId().equals(customerId)).findFirst().orElse(null) ;
        };
    }

    public DataFetcher getItemByIdFetcher() {
        return dataFetchingEnvironment -> {
            String itemId = dataFetchingEnvironment.getArgument("id");
            return DAO.getAllItems().stream().filter(item -> item.getId().equals(itemId)).findFirst().orElse(null) ;
        };
    }

    public DataFetcher getCustomersDataFetcher() {
        return dataFetchingEnvironment -> {
            return DAO.getAllCustomers();
        };
    }

    public DataFetcher getItemsDataFetcher() {
        return dataFetchingEnvironment -> {
            return DAO.getAllItems();
        };
    }

    public DataFetcher getItemDataFetcher(){
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String itemId = book.get("itemId");
            return DAO.getAllItems().stream().filter(item -> item.getId().equals(itemId)).findFirst().orElse(null) ;
        };
    }
}
