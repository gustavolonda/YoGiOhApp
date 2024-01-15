package com.fisagrp.yugiohapp.domain;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.ObservableBoolean;

import com.fisagrp.yugiohapp.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardViewModelView {
    public int cardId               = 0;
    public  String message    = "";
    public  boolean isError   = false;
    public  boolean isLoading = false;

    public ObservableBoolean  observableBoolean = new ObservableBoolean(false);
    public List<CardItemListViewModel> cardItemList = new ArrayList();

    public List<Card> cardList = new ArrayList();
    public boolean showMessage(){
        return !message.isEmpty();
    }
    public int getLoadinVisibility(){
        return isLoading ? VISIBLE : GONE;
    }
    @BindingAdapter("isLoadinVisibility")
    public static void isLoadinVisibility(View view, boolean bool){
        if(bool){
            view.setVisibility(View.VISIBLE);
        }else{
            view.setVisibility(View.GONE);
        }
    }
    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        view.setText(Integer.toString(value));
    }
    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }
    @BindingAdapter("visible")
    public static void bindVisible(View v, boolean show) {
        v.setVisibility(show ? View.VISIBLE : View.GONE);
    }

}