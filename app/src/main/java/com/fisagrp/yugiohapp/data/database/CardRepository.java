package com.fisagrp.yugiohapp.data.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fisagrp.yugiohapp.data.database.AppDatabase;
import com.fisagrp.yugiohapp.data.database.CardDao;
import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;

import java.util.List;

import io.reactivex.Observable;

public class CardRepository {
    AppDatabase appDatabase;
    private CardDao cardDao;
    private LiveData<List<CardWithCardSetCardImageCardPriceEntity>> cardWithCardSetCardImageCardPriceEntitylist;
    private LiveData<CardWithCardSetCardImageCardPriceEntity> cardDetailsLiveData;
    public CardRepository(Application application) {
        appDatabase = AppDatabase.getDatabase(application);
        cardDao = appDatabase.getCardDao();

    }

    public void insertCardAll(List<CardEntity> cardEntitylist) {
        appDatabase.databaseWriteExecutor.execute(() -> cardDao.insertAll(cardEntitylist));
    }

    public LiveData<List<CardWithCardSetCardImageCardPriceEntity>> getCardWithCardSetCardImageCardPriceEntitylist() {
        cardWithCardSetCardImageCardPriceEntitylist = cardDao.getCardWithCardSetCardImageCardPriceEntitys();
        return cardWithCardSetCardImageCardPriceEntitylist;
    }

    public LiveData<CardWithCardSetCardImageCardPriceEntity> getCardWithCardSetCardImageCardById(int cardId) {
        cardDetailsLiveData = cardDao.getCardWithCardSetCardImageCardPriceEntitysById(cardId);
        return cardDetailsLiveData;
    }

    public List<CardWithCardSetCardImageCardPriceEntity> getCardByArcheType(String archeType) {
        return cardDao.getCardByArcheType(archeType);
    }
}