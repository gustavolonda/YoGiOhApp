package com.fisagrp.yugiohapp.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fisagrp.yugiohapp.model.CardImage;


@Entity(tableName = "card_images")
public class CardImageEntity {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "card_id")
    public int cardId;
    @ColumnInfo(name = "image_url")
    public String imageUrl;
    @ColumnInfo(name = "image_url_small")
    public String imageUrlSmall;
    @ColumnInfo(name = "image_url_cropped")
    public String imageUrlCropped;
}
