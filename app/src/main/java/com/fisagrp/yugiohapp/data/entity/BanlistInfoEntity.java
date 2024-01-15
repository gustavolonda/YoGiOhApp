package com.fisagrp.yugiohapp.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "banlist_infos")
public class BanlistInfoEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "ban_tcg")
    public String banTcg;
    @ColumnInfo(name = "ban_ocg")
    public String banOcg;
}
