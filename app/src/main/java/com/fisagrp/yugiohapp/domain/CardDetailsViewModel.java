package com.fisagrp.yugiohapp.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fisagrp.yugiohapp.data.database.CardRepository;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;

public class CardDetailsViewModel extends AndroidViewModel {
    private CardRepository cardRepository;
    public LiveData<CardWithCardSetCardImageCardPriceEntity> mCardDetailsItemViewModelView;
    public MutableLiveData<CardDetailsItemViewModelView> mPanelResponse;
    public CardDetailsViewModel(@NonNull Application application) {
        super(application);
        if(mPanelResponse == null)
            mPanelResponse = new MutableLiveData<>();
        cardRepository = new CardRepository(application);
    }
    public LiveData<CardWithCardSetCardImageCardPriceEntity>  loadDataFromDataBase(int cardId){
        mCardDetailsItemViewModelView  = cardRepository.getCardWithCardSetCardImageCardById(cardId);
        return mCardDetailsItemViewModelView;
    }
}
