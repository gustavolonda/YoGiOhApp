package com.fisagrp.yugiohapp.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class CardWithCardSetCardImageCardPriceEntity {
    @Embedded
    public CardEntity cardEntity;

    @Relation(parentColumn = "id",
            entityColumn = "card_id",
            entity = CardSetEntity.class)
    public List<CardSetEntity> cardSetList;

    @Relation(parentColumn = "id",
            entityColumn = "card_id",
            entity = CardImageEntity.class)
    public List<CardImageEntity> cardImageList;

    @Relation(parentColumn = "id",
            entityColumn = "card_id",
            entity = CardPriceEntity.class)
    public List<CardPriceEntity> cardPriceList;

}
