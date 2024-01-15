package com.fisagrp.yugiohapp.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardImageEntity;
import com.fisagrp.yugiohapp.data.entity.CardPriceEntity;
import com.fisagrp.yugiohapp.data.entity.CardSetEntity;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;

import java.util.List;

@Dao
public abstract class CardDao {
    public void insertAll(List<CardEntity> cardEntityList) {
        try {
            _insertAll(cardEntityList);
            for(CardEntity cardEntity:cardEntityList) {
                if(cardEntity.cardSetList != null ||
                        cardEntity.cardImageList != null ||
                        cardEntity.cardPriceList != null) {
                    insertCardSetsForCardEntity(cardEntity);

                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void insertCardSetsForCardEntity(CardEntity cardEntity){

        for(CardSetEntity cardSetEntity : cardEntity.cardSetList){
            cardSetEntity.cardId = cardEntity.id;
        }
        _insertAllCardSet(cardEntity.cardSetList);

        for(CardImageEntity cardImageEntity : cardEntity.cardImageList){
            cardImageEntity.cardId = cardEntity.id;
        }
        _insertAllCardImageEntity(cardEntity.cardImageList);

        for(CardPriceEntity cardPriceEntity : cardEntity.cardPriceList){
            cardPriceEntity.cardId = cardEntity.id;
        }
        _insertAllCardPriceEntity(cardEntity.cardPriceList);
    }
    @Insert
    abstract void _insertAll(List<CardEntity> cardEntityList);
    @Insert
    abstract void _insertAllCardSet(List<CardSetEntity> cardSetList);
    @Insert
    abstract void _insertAllCardImageEntity(List<CardImageEntity> cardImageEntityList);
    @Insert
    abstract void _insertAllCardPriceEntity(List<CardPriceEntity> cardPriceEntityList);
    @Query("SELECT * FROM cards")
    abstract LiveData<List<CardWithCardSetCardImageCardPriceEntity>> getCardWithCardSetCardImageCardPriceEntitys();

    @Query("SELECT * FROM cards where id = :cardId")
    abstract LiveData<CardWithCardSetCardImageCardPriceEntity> getCardWithCardSetCardImageCardPriceEntitysById(int cardId);

    @Query("SELECT * FROM cards where archetype = :archeType")
    abstract List<CardWithCardSetCardImageCardPriceEntity> getCardByArcheType(String archeType);
}
