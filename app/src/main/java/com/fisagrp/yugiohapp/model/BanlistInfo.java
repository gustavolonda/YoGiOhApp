package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

public class BanlistInfo{
    @SerializedName("ban_tcg")
    public String banTcg;
    @SerializedName("ban_ocg")
    public String banOcg;
}
