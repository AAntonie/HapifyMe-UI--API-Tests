package com.hapifyme.utils;

public class DataGenerator {

    public static String generateEmail() {
        return "john_" + System.currentTimeMillis() + "@hapifyme.com";
    }
}