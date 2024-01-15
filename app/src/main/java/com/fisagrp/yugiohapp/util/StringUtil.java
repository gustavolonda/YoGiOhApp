package com.fisagrp.yugiohapp.util;

import com.google.gson.Gson;

import java.util.ArrayList;

public class StringUtil {
    public static final String EMPTY = "";
    public static Gson getGson(){
        return new Gson();
    }
    public static String toJsonString(ArrayList<String> list){
        return getGson().toJson(list);
    }
}
