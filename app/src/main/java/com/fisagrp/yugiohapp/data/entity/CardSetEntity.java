package com.fisagrp.yugiohapp.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "card_sets")
public class CardSetEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "card_id")
    public int cardId;
    @ColumnInfo(name = "set_name")
    public String name;
    @ColumnInfo(name = "set_code")
    public String code;
    @ColumnInfo(name = "set_rarity")
    public String rarity;
    @ColumnInfo(name = "set_rarity_code")
    public String rarityCode;
    @ColumnInfo(name = "set_price")
    public String price;
}
