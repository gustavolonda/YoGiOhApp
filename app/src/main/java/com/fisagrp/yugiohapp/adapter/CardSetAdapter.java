package com.fisagrp.yugiohapp.adapter;
import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardSetEntity;
import com.fisagrp.yugiohapp.model.Card;
import com.fisagrp.yugiohapp.model.CardSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardSetAdapter {
    private static CardSetEntity toCardSetEntity(CardSet cardSet){
        CardSetEntity cardSetEntity = new CardSetEntity();
        cardSetEntity.code          = cardSet.code;
        cardSetEntity.name          = cardSet.name;
        cardSetEntity.price         = cardSet.price;
        cardSetEntity.rarity        = cardSet.rarity;
        cardSetEntity.rarityCode    = cardSet.rarityCode;
        return cardSetEntity;
    }
    public static ArrayList<CardSetEntity> toCardSetEntityList(ArrayList<CardSet> cardSetList){
        return new ArrayList(cardSetList.stream().map(CardSetAdapter::toCardSetEntity)
                .collect(Collectors.toList()));
    }
    private static CardSet toCardSetE(CardSetEntity cardSetEntity){
        CardSet cardSet     = new CardSet();
        cardSet.code        = cardSetEntity.code;
        cardSet.name        = cardSetEntity.name;
        cardSet.price       = cardSetEntity.price;
        cardSet.rarity      = cardSetEntity.rarity;
        cardSet.rarityCode  = cardSetEntity.rarityCode;
        return cardSet;
    }

    public static ArrayList<CardSet>  toCardSetList(ArrayList<CardSetEntity> cardSetEntityList){
        return new ArrayList(cardSetEntityList.stream().map(CardSetAdapter::toCardSetE)
                .collect(Collectors.toList()));
    }
    public static ArrayList<CardSet>  toCardSetList(List<CardSetEntity> cardSetEntityList){
        return toCardSetList(new ArrayList(cardSetEntityList));
    }
}
