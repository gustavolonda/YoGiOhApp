package com.fisagrp.yugiohapp.adapter;

import com.fisagrp.yugiohapp.data.entity.CardPriceEntity;
import com.fisagrp.yugiohapp.data.entity.CardSetEntity;
import com.fisagrp.yugiohapp.model.CardPrice;
import com.fisagrp.yugiohapp.model.CardSet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardPriceAdapter {
    public static CardPriceEntity toCardPriceEntity(CardPrice cardPrice){
        CardPriceEntity cardPriceEntity   = new CardPriceEntity();
        cardPriceEntity.amazonPrice       = cardPrice.amazonPrice;
        cardPriceEntity.cardmarketPrice   = cardPrice.cardmarketPrice;
        cardPriceEntity.coolstuffincPrice = cardPrice.coolstuffincPrice;
        cardPriceEntity.tcgplayerPrice    = cardPrice.tcgplayerPrice;
        cardPriceEntity.ebayPrice         = cardPrice.ebayPrice;
        return cardPriceEntity;

    }
    public static ArrayList<CardPriceEntity> toCardPriceEntityList(ArrayList<CardPrice> cardPriceList){
        return new ArrayList(cardPriceList.stream().map(CardPriceAdapter::toCardPriceEntity)
                                                .collect(Collectors.toList()));
    }

    public static CardPrice toCardPriceEntity(CardPriceEntity cardPriceEntity){
        CardPrice cardPrice         = new CardPrice();
        cardPrice.amazonPrice       = cardPriceEntity.amazonPrice;
        cardPrice.cardmarketPrice   = cardPriceEntity.cardmarketPrice;
        cardPrice.coolstuffincPrice = cardPriceEntity.coolstuffincPrice;
        cardPrice.tcgplayerPrice    = cardPriceEntity.tcgplayerPrice;
        cardPrice.ebayPrice         = cardPriceEntity.ebayPrice;
        return cardPrice;

    }
    public static ArrayList<CardPrice>  toCardPriceList(ArrayList<CardPriceEntity> cardPriceEntityList){
        return new ArrayList(cardPriceEntityList.stream().map(CardPriceAdapter::toCardPriceEntity)
                                                        .collect(Collectors.toList()));
    }
    public static ArrayList<CardPrice>  toCardPriceList(List<CardPriceEntity> cardPriceEntityList){
        return toCardPriceList(new ArrayList(cardPriceEntityList));
    }
}
