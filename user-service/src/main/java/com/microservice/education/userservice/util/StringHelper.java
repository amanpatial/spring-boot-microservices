package com.microservice.education.userservice.util;
import java.util.UUID;

public class StringHelper {
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String cut(String source, int length) {
        if(source.length() <= length){
            return source;
        }else {
            return source.substring(0, length - 1) + "...";
        }
    }

    public static String capitalize(String value){
        if(value != null && !"".equals(value)){
            return value.substring(0,1).toUpperCase() + value.substring(1);
        }
        return value;
    }
}
