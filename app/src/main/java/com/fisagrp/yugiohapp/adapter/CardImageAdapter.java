package com.fisagrp.yugiohapp.adapter;

import com.fisagrp.yugiohapp.data.entity.CardImageEntity;
import com.fisagrp.yugiohapp.data.entity.CardPriceEntity;
import com.fisagrp.yugiohapp.model.CardImage;
import com.fisagrp.yugiohapp.model.CardPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardImageAdapter {
    public static CardImageEntity toCardImageEntity(CardImage cardImage){
        CardImageEntity cardImageEntity = new CardImageEntity();
        cardImageEntity.id              = cardImage.id;
        cardImageEntity.imageUrlCropped = cardImage.imageUrlCropped;
        cardImageEntity.imageUrl        = cardImage.imageUrl;
        cardImageEntity.imageUrlSmall   = cardImage.imageUrlSmall;
        return cardImageEntity;

    }
    public static ArrayList<CardImageEntity>  toCardImageEntityList(ArrayList<CardImage> cardImageList){
        return new ArrayList(cardImageList.stream().map(CardImageAdapter::toCardImageEntity)
                                                                    .collect(Collectors.toList()));
    }

    public static CardImage toCardImage(CardImageEntity cardImageEntity){
        CardImage cardImage       = new CardImage();
        cardImage.id              = cardImageEntity.id;
        cardImage.imageUrlCropped = cardImageEntity.imageUrlCropped;
        cardImage.imageUrl        = cardImageEntity.imageUrl;
        cardImage.imageUrlSmall   = cardImageEntity.imageUrlSmall;
        return cardImage;
    }

    public static ArrayList<CardImage>  toCardImageList(ArrayList<CardImageEntity> cardImageEntityList){
        return new ArrayList(cardImageEntityList.stream().map(CardImageAdapter::toCardImage)
                .collect(Collectors.toList()));
    }

    public static ArrayList<CardImage>  toCardImageList(List<CardImageEntity> cardImageEntityList){
        return toCardImageList(new ArrayList(cardImageEntityList));
    }
}
