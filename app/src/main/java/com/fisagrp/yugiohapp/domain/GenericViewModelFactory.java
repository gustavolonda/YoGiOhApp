package com.fisagrp.yugiohapp.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class GenericViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;

    public GenericViewModelFactory(Application myApplication) {
        application = myApplication;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CardEntityViewModel(application);
    }
}