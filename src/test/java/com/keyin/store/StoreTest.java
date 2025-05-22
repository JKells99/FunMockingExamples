package com.keyin.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreTest {
    Store store;
    Employee employee;
    InventoryItem inventoryItem, inventoryItem2, inventoryItem3, inventoryItem4;

    @BeforeEach
    public void setUp() {
        store = new Store("1", "Test Store", "123 Test St");
        employee = new Employee(1, "John Doe", "Manager");
        inventoryItem = new InventoryItem(1, "Test Item 1", 10.99, 5);
        inventoryItem2 = new InventoryItem(2, "Test Item 2", 15.99, 3);
        inventoryItem3 = new InventoryItem(3, "Test Item 3", 20.99, 7);
        inventoryItem4 = new InventoryItem(4, "Test Item 4", 25.99, 2);
        store.addInventoryItem(inventoryItem);
        store.addInventoryItem(inventoryItem2);
        store.addInventoryItem(inventoryItem3);
        store.addInventoryItem(inventoryItem4);
        store.addEmployee(employee);
    }

    @Test
    void createANewInventoryItem() {
        InventoryItem newItem = new InventoryItem(5, "Test Item 5", 30.99, 4);
        store.addInventoryItem(newItem);
        Assertions.assertTrue(store.getInventoryItems().contains(newItem));
        Assertions.assertEquals(5, store.inventoryCount());
    }

    @Test
    void testDeleteInventoryItem() {
        InventoryItem newItem = new InventoryItem(5, "Test Item 5", 30.99, 4);
        store.removeInventoryItem(newItem);
        Assertions.assertFalse(store.getInventoryItems().contains(newItem));
        Assertions.assertEquals(4, store.inventoryCount());
    }

}
