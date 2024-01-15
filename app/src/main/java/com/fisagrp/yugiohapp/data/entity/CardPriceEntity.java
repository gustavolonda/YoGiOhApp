package com.fisagrp.yugiohapp.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "card_prices")
public class CardPriceEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "card_id")
    public int cardId;
    @SerializedName("cardmarket_price")
    public String cardmarketPrice;
    @ColumnInfo(name = "tcgplayer_price")
    public String tcgplayerPrice;
    @ColumnInfo(name = "ebay_price")
    public String ebayPrice;
    @ColumnInfo(name = "amazon_price")
    public String amazonPrice;
    @ColumnInfo(name = "coolstuffinc_price")
    public String coolstuffincPrice;
}
