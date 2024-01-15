package com.fisagrp.yugiohapp.helper;

import static java.lang.Boolean.TRUE;

import android.content.Context;

import com.fisagrp.yugiohapp.model.CardResponse;
import com.fisagrp.yugiohapp.network.APIClient;
import com.fisagrp.yugiohapp.network.CardService;
import com.fisagrp.yugiohapp.util.InternetUtil;
import com.fisagrp.yugiohapp.domain.CardItemListViewModel;
import com.fisagrp.yugiohapp.domain.CardViewModelView;

import java.util.stream.Collectors;

import retrofit2.Call;

public class CardHelper {
    public static CardViewModelView getAll(Context context, String archeType){
        CardViewModelView cardVieModelView = new CardViewModelView();
        CardService apiInterface = APIClient.getClient().create(CardService.class);
        try {
            if (!InternetUtil.getInstance(context).isOnline()){
                cardVieModelView.message = "Verificar la conexion del Internet";
                cardVieModelView.isError = TRUE;
                return cardVieModelView;
            }
            Call<CardResponse> call = apiInterface.getAllByArchetype(archeType);
            CardResponse response = call.execute().body();
            if (response.cardList.size() == 0){
                cardVieModelView.message = "No hay datos para mostrar";
                return cardVieModelView;
            }


            cardVieModelView.cardItemList = response.cardList.stream().map( card -> {
                CardItemListViewModel cardItemListViewModel = new CardItemListViewModel();
                cardItemListViewModel.cardId    = card.id;
                cardItemListViewModel.name      = card.name;
                cardItemListViewModel.type      = card.type;
                cardItemListViewModel.attribute = card.attribute;
                if(card.cardImageList.size() > 0){
                    cardItemListViewModel.imageUrlCropped = card.cardImageList.get(0).imageUrlCropped;
                }
                return cardItemListViewModel;
            }).collect(Collectors.toList());
            cardVieModelView.cardList = response.cardList;

            return cardVieModelView;

        }catch (Exception e){
            cardVieModelView.message = "Ocurrió un error";
            cardVieModelView.isError = TRUE;
            return cardVieModelView;
        }
    }
}