package ua.com.alevel.controller;

import ua.com.alevel.db.Dictionary;

import java.util.Collection;

public class DictionaryController {
    Dictionary dictionary = new Dictionary();

    public void start() {
        System.out.println();
        System.out.println("-------------------PHONE-------------------");
        addProduct();
        Empty();
        getProduct();
        containsProduct();
        deleteProduct();
        System.out.println();
    }

    public void putValuesTheDictionary() {
        System.out.println("product code - 318463890");
        System.out.println("phone - Samsung Galaxy.");
        System.out.println("product code - 318468963");
        System.out.println("phone -  Apple iPhone.");
        dictionary.put("318463890", "Samsung Galaxy.");
        dictionary.put("318468963", "Apple iPhone.");
    }

    public void update() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        dictionary.put("361481908", "Motorola");
        System.out.print("update: 361481908");
    }

    public void addPhone() {
        System.out.println();
        dictionary.put("318463890", "Samsung Galaxy.");
        dictionary.put("318468963", "Apple iPhone.");
        dictionary.put("361481908", "Motorola");
        System.out.printf("Dictionary: " + dictionary);
        dictionary.putAll(dictionary);
    }

    public void addProduct() {
        System.out.println();
        putValuesTheDictionary();
        update();
        addPhone();
    }

    public void Empty() {
        System.out.println();
        System.out.printf("Dictionary : " + dictionary);
        System.out.printf("Dictionary : " + dictionary);
    }

    public void getAllKeys() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        Collection keysList = dictionary.keySet();
        System.out.printf(("Keys: " + keysList.toString()));

    }

    public void getAllValues() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        Collection valuesList = dictionary.values();
        System.out.printf(("Values: " + valuesList.toString()));
    }

    public void getValue() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        String key = "361481908";
        System.out.printf("get key" + key);
        String phone = (String) dictionary.get(key);
    }

    public void getKey() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        String value = "Motorola";
        System.out.printf("get value" + value);
        String phone = (String) dictionary.get(value);
    }

    public void getProduct() {
        System.out.println();
        getValue();
        getKey();
        getAllKeys();
        getAllValues();
    }

    public void containsKey() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        String key1 = "361567890";
        String key2 = "361483437";
    }

    public void containsValue() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary());
        String value1 = "Samsung Galaxy";
        String value2 = "Motorola";
        System.out.printf("Value 1: " + value1 + ". Value 2: " + value2);
    }

    public void containsProduct() {
        System.out.println();
        containsValue();
        containsKey();

    }

    public void removeValueByKey() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        String key = "314657379";
        System.out.println("Delete: " + key);
        dictionary.remove(key);
        System.out.printf("Dictionary: " + dictionary);
    }

    public void clearDictionary() {
        System.out.println();
        System.out.printf("Dictionary: " + dictionary);
        dictionary.clear();
        System.out.printf("Dictionary: " + dictionary);
    }

    public void deleteProduct() {
        removeValueByKey();
        clearDictionary();
    }

    private String dictionary() {
        return String.valueOf(false);
    }
}