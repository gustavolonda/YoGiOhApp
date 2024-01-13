package com.fisagrp.yugiohapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CardResponse {
    @SerializedName("data")
    public ArrayList<Card> cardList;
}
