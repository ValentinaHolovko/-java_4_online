package ua.com.alevel.controller;

import ua.com.alevel.db.DbStorage;
import ua.com.alevel.entity.Shop;
import ua.com.alevel.entity.Сustomer;
import ua.com.alevel.service.ShopService;
import ua.com.alevel.service.СustomerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class СustomerController {

    private СustomerService сustomerService = new СustomerService();
    private ShopService shopService = new ShopService();

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to shop!");
        System.out.println("Please select your option:");
        String input;
        menu();
        while ((input = reader.readLine()) != null) {
            crud(reader, input);
            menu();
        }
    }

    private void menu() {
        System.out.println("If You want to create a new customer, please enter 1");
        System.out.println("If You want to create a new shop, please enter 2");
        System.out.println("If You want to find a customer, please enter 3");
        System.out.println("If You want to find a shop, please enter 4");
        System.out.println("If You want to find all customer, please enter 5");
        System.out.println("If You want to find all shops, please enter 6");
        System.out.println("If You want to update a customer, please enter 7");
        System.out.println("If You want to update a shop, please enter 8");
        System.out.println("If You want to attach a customer to the shop, please enter 9");
        System.out.println("If You want to attach a shop to the customer, please enter 10");
        System.out.println("If You want to delete a customer, please enter 11");
        System.out.println("If You want to delete a shop, please enter 12");
        System.out.println("If You want to close application, please enter 13");
    }

    private void crud(BufferedReader reader, String input) throws IOException {
        switch (input) {
            case "1":
                createCustomer(reader);
                break;
            case "2":
                createShop(reader);
                break;
            case "3":
                findCustomer(reader);
                break;
            case "4":
                findShop(reader);
                break;
            case "5":
                findAllCustomers();
                break;
            case "6":
                findAllShops();
                break;
            case "7":
                updateCustomer(reader);
                break;
            case "8":
                updateShop(reader);
                break;
            case "9":
                attachCustomerToShop(reader);
                break;
            case "10":
                attachShopToCustomer(reader);
                break;
            case "11":
                deleteCustomer(reader);
                break;
            case "12":
                deleteShop(reader);
                break;
            case "13":
                exit();
                break;
            default:
                System.out.println("Something went wrong... Try again please");
        }
    }

    private void createCustomer(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new сustomer.");
        System.out.println("Please enter сustomer's name:");
        String Name = reader.readLine();
        System.out.println("Please enter сustomer's phone:");
        String phone = reader.readLine();
        Сustomer сustomer = new Сustomer();
        сustomer.setName(Name);
        сustomer.setPhone(phone);
        сustomerService.create(сustomer);
        System.out.println("New сustomer is created. His/her ID is " + сustomer.getId());
    }

    private void createShop(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new shop.");
        System.out.println("Please enter shop's name:");
        String shopName = reader.readLine();
        System.out.println("Please enter shop's country:");
        String country = reader.readLine();
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setCountry(country);
        shopService.create(shop);
        System.out.println("New shop is created. It's ID is " + shop.getId());
    }

    private void findCustomer(BufferedReader reader) throws IOException {
        System.out.println("To find the сustomer please enter сustomer's ID:");
        String customerId = reader.readLine();
        Сustomer сustomer = сustomerService.findById(customerId);
        if (сustomer == null) {
            System.out.println("This сustomer does not exist.");
        } else {
            System.out.println(сustomer);
        }
    }

    private void findShop(BufferedReader reader) throws IOException {
        System.out.println("To find the shop please enter shop's ID:");
        String shopId = reader.readLine();
        Shop shop = shopService.findShopById(shopId);
        if (shop == null) {
            System.out.println("This shop does not exist.");
        } else {
            System.out.println(shop);
        }
    }

    private void findAllCustomers() {
        System.out.println("Customer list:");
        List<Сustomer> сustomers = сustomerService.findAll();
        System.out.println("сustomers = " + сustomers);
    }

    private void findAllShops() {
        System.out.println("Shops list:");
        List<Shop> shops = shopService.findAllShop();
        System.out.println("shops = " + shops);
    }

    private void updateCustomer(BufferedReader reader) throws IOException {
        System.out.println("Let's update customer's information. To start, please enter customer's ID:");
        String customerId = reader.readLine();
        Optional<Сustomer> existing = DbStorage.getInstance().getCustomer(customerId);
        if (existing.isEmpty()) {
            System.out.println("This customer does not exist.");
        } else {
            Сustomer сustomer = existing.get();

            System.out.println("Please enter сustomer's name:");
            String name = reader.readLine();
            сustomer.setName(name);
            System.out.println("Please enter сustomer's phone:");
            String phone = reader.readLine();
            сustomer.setPhone(phone);

            сustomerService.update(сustomer);
            System.out.println("Thank you, the сustomer's information is updated.");
        }
    }

    private void updateShop(BufferedReader reader) throws IOException {
        System.out.println("Let's update shop's information. To start, please enter shop's ID:");
        String shopId = reader.readLine();
        Optional<Shop> shop = DbStorage.getInstance().getShop(shopId);
        if (shop.isEmpty()) {
            System.out.println("This shop does not exist.");
        } else {
            System.out.println("Please enter shop's name:");
            String shopName = reader.readLine();
            shop.get().setShopName(shopName);
            System.out.println("Please enter shop's сountry:");
            String сountry = reader.readLine();
            shop.get().setCountry(сountry);
            System.out.println("Thank you, the shop's information is updated.");
        }
    }

    private void attachCustomerToShop(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the client to shop. To start, please enter client's ID:");
        String customerId = reader.readLine();
        System.out.println("Then please enter shop's ID:");
        String shopId = reader.readLine();
        сustomerService.attach(customerId, shopId);
    }

    private void attachShopToCustomer(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the shop to customer. To start, please enter shop's ID:");
        String shopId = reader.readLine();
        System.out.println("Then please enter customer's ID:");
        String customerId = reader.readLine();
        shopService.attach(customerId, shopId);
    }

    private void deleteCustomer(BufferedReader reader) throws IOException {
        System.out.println("To delete the customer please enter his ID:");
        String customerId = reader.readLine();
        сustomerService.delete(customerId);
        System.out.println("The customer is deleted.");
    }

    private void deleteShop(BufferedReader reader) throws IOException {
        System.out.println("To delete the shop please enter it's ID:");
        String shopId = reader.readLine();
        shopService.delete(shopId);
        System.out.println("The shop is deleted.");
    }

    private void exit() {
        System.exit(0);
    }
}