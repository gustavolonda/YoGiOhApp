package com.fisagrp.yugiohapp.network;

import static com.fisagrp.yugiohapp.BuildConfig.CARD_INFO;

import com.fisagrp.yugiohapp.model.CardResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CardService {
    @GET(CARD_INFO)
    Call<CardResponse> getAll();
}
