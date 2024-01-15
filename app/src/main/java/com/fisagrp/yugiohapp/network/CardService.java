package com.fisagrp.yugiohapp.network;

import static com.fisagrp.yugiohapp.BuildConfig.CARD_INFO;

import com.fisagrp.yugiohapp.model.CardResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardService {
    @GET(CARD_INFO)
    Call<CardResponse> getAll();

    @GET(CARD_INFO)
    Call<CardResponse> getAllByArchetype( @Query("archetype") String archetype);
}
