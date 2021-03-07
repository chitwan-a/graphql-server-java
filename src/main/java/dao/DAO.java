package dao;

import dtos.Customer;
import dtos.Item;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class DAO {

    private static List<Item> allItems = new ArrayList<>();

    private static List<Customer> allCustomers = new ArrayList<>();

    @PostConstruct
    public void init() {

        allItems.add(new Item("1", "Chips", 10));
        allItems.add(new Item("2", "Apple juice", 20));
        allItems.add(new Item("3", "Cookies", 30));

        allCustomers.add(new Customer("1", "John", "stone", 27, allItems));
        allCustomers.add(new Customer("2", "Mary", "stone", 30, Collections.singletonList(allItems.get(0))));

    }

    public static List<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(List<Item> allItems) {
        this.allItems = allItems;
    }

    public static List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }
}
