package com.fisagrp.yugiohapp.adapter;

import static com.fisagrp.yugiohapp.adapter.BanlistInfoAdapter.toBanlistInfo;
import static com.fisagrp.yugiohapp.adapter.CardImageAdapter.toCardImageEntityList;
import static com.fisagrp.yugiohapp.adapter.CardImageAdapter.toCardImageList;
import static com.fisagrp.yugiohapp.adapter.CardPriceAdapter.toCardPriceEntityList;
import static com.fisagrp.yugiohapp.adapter.CardPriceAdapter.toCardPriceList;
import static com.fisagrp.yugiohapp.adapter.CardSetAdapter.toCardSetEntityList;
import static com.fisagrp.yugiohapp.adapter.CardSetAdapter.toCardSetList;

import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;
import com.fisagrp.yugiohapp.domain.CardDetailsItemViewModelView;
import com.fisagrp.yugiohapp.model.Card;
import com.fisagrp.yugiohapp.domain.CardItemListViewModel;
import com.fisagrp.yugiohapp.domain.CardViewModelView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardAdapter {
    public static CardEntity toCardEntity(Card card){
        CardEntity cardEntity = new CardEntity();
        cardEntity.id            = card.id;
        cardEntity.name          = card.name;
        cardEntity.type          = card.type;
        cardEntity.frameType     = card.frameType;
        cardEntity.desc          = card.desc;
        cardEntity.atk           = card.atk; ;
        cardEntity.def           = card.def;
        cardEntity.level         = card.level;
        cardEntity.race          = card.race;
        cardEntity.attribute     = card.attribute;
        cardEntity.archetype     = card.archetype;
        cardEntity.ygoprodeckUrl = card.ygoprodeckUrl;
        cardEntity.cardSetList   = card.cardSetList != null && card.cardSetList.size() >= 0? toCardSetEntityList(card.cardSetList): new ArrayList();
        cardEntity.cardImageList = card.cardImageList != null && card.cardImageList.size() >= 0? toCardImageEntityList(card.cardImageList): new ArrayList();
        cardEntity.cardPriceList = card.cardPriceList != null && card.cardPriceList.size() >= 0? toCardPriceEntityList(card.cardPriceList): new ArrayList();
        cardEntity.linkval       = card.linkval;
        cardEntity.linkMarkers   = card.linkMarkers;
        cardEntity.banlistInfo   = BanlistInfoAdapter.toBanlistInfoEntity(card.banlistInfo);
        return cardEntity;
    }
    public static ArrayList<CardEntity>  toCardEntityList(ArrayList<Card> cardList){
        return new ArrayList(cardList.stream().map(CardAdapter::toCardEntity)
                .collect(Collectors.toList()));
    }

    public static ArrayList<CardEntity>  toCardEntityList(List<Card> cardList){
        return toCardEntityList(new ArrayList(cardList));
    }

    public static Card toCard(CardEntity cardEntity){
        Card card = new Card();
        card.id            = cardEntity.id;
        card.name          = cardEntity.name;
        card.type          = cardEntity.type;
        card.frameType     = cardEntity.frameType;
        card.desc          = cardEntity.desc;
        card.atk           = cardEntity.atk; ;
        card.def           = cardEntity.def;
        card.level         = cardEntity.level;
        card.race          = cardEntity.race;
        card.attribute     = cardEntity.attribute;
        card.archetype     = cardEntity.archetype;
        card.ygoprodeckUrl = cardEntity.ygoprodeckUrl;
        card.cardSetList   = cardEntity.cardSetList != null && cardEntity.cardSetList.size() >= 0? toCardSetList(cardEntity.cardSetList): new ArrayList();
        card.cardImageList = cardEntity.cardImageList != null && cardEntity.cardImageList.size() >= 0? toCardImageList(cardEntity.cardImageList): new ArrayList();
        card.cardPriceList = cardEntity.cardPriceList != null && cardEntity.cardSetList.size() >= 0? toCardPriceList(cardEntity.cardPriceList): new ArrayList();
        card.linkval       = cardEntity.linkval;
        card.linkMarkers   = cardEntity.linkMarkers;
        card.banlistInfo   = toBanlistInfo(cardEntity.banlistInfo);
        return card;
    }
    public static ArrayList<Card>  toCardList(ArrayList<CardEntity> cardEntityList){
        return new ArrayList(cardEntityList.stream().map(CardAdapter::toCard)
                .collect(Collectors.toList()));
    }

    public static Card toCard(CardWithCardSetCardImageCardPriceEntity cardWithCardSetCardImageCardPriceEntity){
        cardWithCardSetCardImageCardPriceEntity.cardEntity.cardPriceList = new ArrayList(cardWithCardSetCardImageCardPriceEntity.cardPriceList);
        cardWithCardSetCardImageCardPriceEntity.cardEntity.cardImageList = new ArrayList(cardWithCardSetCardImageCardPriceEntity.cardImageList);
        cardWithCardSetCardImageCardPriceEntity.cardEntity.cardSetList   = new ArrayList(cardWithCardSetCardImageCardPriceEntity.cardSetList);
        return toCard(cardWithCardSetCardImageCardPriceEntity.cardEntity);
    }

    public static ArrayList<Card>  toCardList(List<CardWithCardSetCardImageCardPriceEntity> cardWithCardSetCardImageCardPriceEntityList){
        return new ArrayList(cardWithCardSetCardImageCardPriceEntityList.stream().map(CardAdapter::toCard)
                             .collect(Collectors.toList()));
    }

    public static CardViewModelView toCardViewModelView(List<CardWithCardSetCardImageCardPriceEntity> cardWithCardSetCardImageCardPriceEntityList){
        CardViewModelView cardViewModelView = new CardViewModelView();
        cardViewModelView.cardList = toCardList(cardWithCardSetCardImageCardPriceEntityList);
        cardViewModelView.cardItemList = cardViewModelView.cardList.stream().map( card -> {
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

        return cardViewModelView;
    }

    public static CardDetailsItemViewModelView toCardDetailsItemViewModelView(CardWithCardSetCardImageCardPriceEntity  card){
        CardDetailsItemViewModelView cardDetailsItemViewModelView = new CardDetailsItemViewModelView();
        cardDetailsItemViewModelView.cardId   = card.cardEntity.id;
        cardDetailsItemViewModelView.name                       = card.cardEntity.name;
        cardDetailsItemViewModelView.type          = card.cardEntity.type;
        cardDetailsItemViewModelView.frameType     = card.cardEntity.frameType;
        cardDetailsItemViewModelView.desc          = card.cardEntity.desc;
        cardDetailsItemViewModelView.atk           = card.cardEntity.atk; ;
        cardDetailsItemViewModelView.def           = card.cardEntity.def;
        cardDetailsItemViewModelView.level         = card.cardEntity.level;
        cardDetailsItemViewModelView.race          = card.cardEntity.race;
        cardDetailsItemViewModelView.attribute     = card.cardEntity.attribute;
        cardDetailsItemViewModelView.archetype     = card.cardEntity.archetype;
        cardDetailsItemViewModelView.ygoprodeckUrl = card.cardEntity.ygoprodeckUrl;
        cardDetailsItemViewModelView.cardSetList   = card.cardSetList != null && card.cardSetList.size() >= 0? toCardSetList(card.cardSetList): new ArrayList();
        cardDetailsItemViewModelView.cardImageList = card.cardImageList != null && card.cardImageList.size() >= 0? toCardImageList(card.cardImageList): new ArrayList();
        cardDetailsItemViewModelView.cardPriceList = card.cardPriceList != null && card.cardPriceList.size() >= 0? toCardPriceList(card.cardPriceList): new ArrayList();
        cardDetailsItemViewModelView.linkval       = card.cardEntity.linkval;
        cardDetailsItemViewModelView.linkMarkers   = card.cardEntity.linkMarkers;
        cardDetailsItemViewModelView.banlistInfo   = toBanlistInfo(card.cardEntity.banlistInfo);
        cardDetailsItemViewModelView.linkString = String.valueOf(cardDetailsItemViewModelView.linkval);
        cardDetailsItemViewModelView.atkString = String.valueOf(cardDetailsItemViewModelView.atk);

        return cardDetailsItemViewModelView;
    }

}
