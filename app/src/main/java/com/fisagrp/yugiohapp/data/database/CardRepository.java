package com.fisagrp.yugiohapp.data.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.fisagrp.yugiohapp.data.database.AppDatabase;
import com.fisagrp.yugiohapp.data.database.CardDao;
import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;

import java.util.List;

public class CardRepository {
    AppDatabase appDatabase;
    private CardDao cardDao;
    private LiveData<List<CardWithCardSetCardImageCardPriceEntity>> cardWithCardSetCardImageCardPriceEntitylist;

    public CardRepository(Application application) {
        appDatabase = AppDatabase.getDatabase(application);
        cardDao = appDatabase.getCardDao();
        cardWithCardSetCardImageCardPriceEntitylist = cardDao.getCardWithCardSetCardImageCardPriceEntitys();
    }

    public void insertCardAll(List<CardEntity> cardEntitylist) {
        appDatabase.databaseWriteExecutor.execute(() -> cardDao.insertAll(cardEntitylist));
    }

    public LiveData<List<CardWithCardSetCardImageCardPriceEntity>> getCardWithCardSetCardImageCardPriceEntitylist() {
        return cardWithCardSetCardImageCardPriceEntitylist;
    }
}