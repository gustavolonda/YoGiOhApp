package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

public class CardPrice {
    @SerializedName("cardmarket_price")
    public String cardmarketPrice;
    @SerializedName("tcgplayer_price")
    public String tcgplayerPrice;
    @SerializedName("ebay_price")
    public String ebayPrice;
    @SerializedName("amazon_price")
    public String amazonPrice;
    @SerializedName("coolstuffinc_price")
    public String coolstuffincPrice;
}
