package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

public class CardSet {
    @SerializedName("set_name")
    public String name;
    @SerializedName("set_code")
    public String code;
    @SerializedName("set_rarity")
    public String rarity;
    @SerializedName("set_rarity_code")
    public String rarityCode;
    @SerializedName("set_price")
    public String price;
}
