package com.fisagrp.yugiohapp.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


import java.util.ArrayList;

@Entity(tableName = "cards")
public class CardEntity {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "type")
    public String type;
    @ColumnInfo(name = "frameType")
    public String frameType;
    @ColumnInfo(name = "desc")
    public String desc;
    @ColumnInfo(name = "atk")
    public int atk;
    @ColumnInfo(name = "def")
    public int def;
    @ColumnInfo(name = "level")
    public int level;
    @ColumnInfo(name = "race")
    public String race;
    @ColumnInfo(name = "attribute")
    public String attribute;
    @ColumnInfo(name = "archetype")
    public String archetype;
    @ColumnInfo(name = "ygoprodeck_url")
    public String ygoprodeckUrl;
    @ColumnInfo(name = "linkval")
    public int linkval;
    @Ignore
    public ArrayList<CardSetEntity> cardSetList;
    @Ignore
    public ArrayList<CardImageEntity> cardImageList;
    @Ignore
    public ArrayList<CardPriceEntity> cardPriceList;
    @Ignore
    public ArrayList<String> linkMarkers;
    @Ignore
    public BanlistInfoEntity banlistInfo;
}
