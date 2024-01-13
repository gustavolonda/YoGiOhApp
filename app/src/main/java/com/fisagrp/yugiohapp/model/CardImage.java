package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

public class CardImage {
    @SerializedName("id")
    public int id;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("image_url_small")
    public String imageUrlSmall;
    @SerializedName("image_url_cropped")
    public String imageUrlCropped;
}
