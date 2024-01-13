package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Card {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("type")
    public String type;
    @SerializedName("frameType")
    public String frameType;
    @SerializedName("desc")
    public String desc;
    @SerializedName("atk")
    public int atk;
    @SerializedName("def")
    public int def;
    @SerializedName("level")
    public int level;
    @SerializedName("race")
    public String race;
    @SerializedName("attribute")
    public String attribute;
    @SerializedName("archetype")
    public String archetype;
    @SerializedName("ygoprodeck_url")
    public String ygoprodeckUrl;
    @SerializedName("card_sets")
    public ArrayList<CardSet> cardSetList;
    @SerializedName("card_images")
    public ArrayList<CardImage> cardImageList;
    @SerializedName("card_prices")
    public ArrayList<CardPrice> cardPriceList;
    @SerializedName("linkval")
    public int linkval;
    @SerializedName("linkmarkers")
    public ArrayList<String> linkMarkers;
    @SerializedName("banlist_info")
    public BanlistInfo banlistInfo;
}
