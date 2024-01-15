package com.fisagrp.yugiohapp.domain;

import com.fisagrp.yugiohapp.model.BanlistInfo;
import com.fisagrp.yugiohapp.model.CardImage;
import com.fisagrp.yugiohapp.model.CardPrice;
import com.fisagrp.yugiohapp.model.CardSet;

import java.util.ArrayList;

public class CardDetailsItemViewModelView {
    public int cardId         = 0;
    public String name = "";
    public String type= "";
    public String frameType= "";
    public String desc= "";
    public int atk= 0;
    public int def = 0;
    public int level= 0;
    public String race = "";

    public String attribute= "";
    public String archetype= "";
    public String ygoprodeckUrl= "";
    public ArrayList<CardSet> cardSetList=  new ArrayList();
    public ArrayList<CardImage> cardImageList = new ArrayList();
    public ArrayList<CardPrice> cardPriceList = new ArrayList();
    public int linkval = 0;;
    public ArrayList<String> linkMarkers = new ArrayList();
    public BanlistInfo banlistInfo;
    public  String message    = "";
    public  boolean isError   = false;
    public  boolean isLoading = false;
    public  String linkString = "";
    public  String atkString = "";

}
