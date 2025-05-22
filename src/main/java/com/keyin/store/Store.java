package com.keyin.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    // Each store will have a name , address, list of employees, and a list of inventory items
    private String storeId;
    private String storeName;
    private String address;
    private List<InventoryItem> inventoryItems;
    private List<Employee> employees;

    public Store(String storeId, String storeName, String address) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.address = address;
        inventoryItems = new ArrayList<InventoryItem>();
        employees = new ArrayList<Employee>();
    }

    public Store() {
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public void addInventoryItem(InventoryItem item) {
        inventoryItems.add(item);
    }
    public void removeInventoryItem(InventoryItem item) {
        inventoryItems.remove(item);
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    public void printStoreReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("Store ID: ").append(storeId).append("\n");
        sb.append("Store Name: ").append(storeName).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Employees: \n");
        for (Employee employee : employees) {
            sb.append(employee.toString()).append("\n");
        }
        sb.append("Inventory Items: \n");
        for (InventoryItem item : inventoryItems) {
            sb.append(item.toString()).append("\n");
        }
    }

    public int employeeCount(){
        return employees.size();

    }

    public int inventoryCount(){
        return inventoryItems.size();
    }




}
