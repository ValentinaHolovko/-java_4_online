package ua.com.alevel.controller;

import ua.com.alevel.db.Dictionary;

import java.util.Collection;
import java.util.Set;

public class DictionaryController {
    Dictionary dictionary;

    public void start() {
        System.out.println();
        System.out.println("-------------------PHONE-------------------");
        addProduct();
        emptyСell();
        getProduct();
        containsProduct();
        deleteProduct();
        System.out.println();
    }

    public void putValuesTheDictionary() {
        dictionary = new Dictionary();
        System.out.println("product code - 318463890");
        System.out.println("phone - Samsung Galaxy.");
        System.out.println("product code - 318468963");
        System.out.println("phone -  Apple iPhone.");
        dictionary.put("318463890", "Samsung Galaxy.");
        dictionary.put("318468963", "Apple iPhone.");
    }

    public void update() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        dictionary.put("361481908", "Motorola");
        System.out.println("update: 361481908");
    }

    public void addPhone() {
        System.out.println();
        Dictionary dictionary = new Dictionary();
        dictionary.put("318463890", "Samsung Galaxy.");
        dictionary.put("318468963", "Apple iPhone.");
        dictionary.put("361481908", "Motorola");
        System.out.println("Dictionary: " + dictionary);
        dictionary.putAll(dictionary);
    }

    public void addProduct() {
        System.out.println();
        putValuesTheDictionary();
        update();
        addPhone();
    }

    public void checkIsEmpty() {
        System.out.println();
        Dictionary newDictionary = new Dictionary();
        System.out.println("Dictionary 1: " + dictionary);
        System.out.println("Dictionary 2: " + newDictionary);
    }

    public void getSize() {
        System.out.println();
        Dictionary newDictionary = new Dictionary();
        System.out.println("Dictionary 1: " + dictionary);
        System.out.println("Dictionary 2: " + newDictionary);
    }

    public void emptyСell() {
        System.out.println();
        checkIsEmpty();
        getSize();
    }

    public void getAllKeys() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        Set keySet = dictionary.keySet();
    }

    public void getAllValues() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        Collection valuesList = dictionary.values();
        System.out.println(("All values: " + valuesList.toString()));
    }

    public void getValue() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        String key = "361481908";
        System.out.println("Get" + key);
        String phone = (String) dictionary.get(key);
    }

    public void getProduct() {
        System.out.println();
        getValue();
        getAllKeys();
        getAllValues();
    }

    public void containsKey() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        String key1 = "361567890";
        String key2 = "361483437";
    }

    public void containsValue() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary());
        String value1 = "Samsung Galaxy";
        String value2 = "Motorola";
        System.out.println("Value 1: " + value1 + ". Value 2: " + value2);
    }

    public void containsProduct() {
        System.out.println();
        containsKey();
        containsValue();
    }

    public void removeValueByKey() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        String key = "314657379";
        System.out.println("Delete: " + key);
        dictionary.remove(key);
        System.out.println("Dictionary: " + dictionary);
    }

    public void clearDictionary() {
        System.out.println();
        System.out.println("Dictionary: " + dictionary);
        dictionary.clear();
        System.out.println("Dictionary: " + dictionary);
    }

    public void deleteProduct() {
        removeValueByKey();
        clearDictionary();
    }

    private String dictionary() {
        return String.valueOf(false);
    }
}