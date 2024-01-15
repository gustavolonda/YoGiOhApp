package com.fisagrp.yugiohapp.domain;

import static com.fisagrp.yugiohapp.adapter.CardAdapter.toCardEntityList;
import static com.fisagrp.yugiohapp.ui.CardFragment.archeTypes;
import static java.lang.Boolean.TRUE;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.fisagrp.yugiohapp.adapter.CardAdapter;
import com.fisagrp.yugiohapp.data.database.CardRepository;
import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardWithCardSetCardImageCardPriceEntity;
import com.fisagrp.yugiohapp.helper.CardHelper;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CardEntityViewModel extends AndroidViewModel {
    private CardRepository cardRepository;
    public MutableLiveData<CardViewModelView> mPanelResponse;
    public List<CardWithCardSetCardImageCardPriceEntity> cardList;
    public CardEntityViewModel(Application application) {
        super(application);
        if(mPanelResponse == null)
            mPanelResponse = new MutableLiveData<>();
        cardRepository = new CardRepository(application);
        loadDataFromDataBase(application.getBaseContext(),archeTypes[0]);


    }
    public LiveData<CardViewModelView> getPanel() {

        return mPanelResponse;
    }

    public List<CardWithCardSetCardImageCardPriceEntity> getCardList() {

        return cardList;
    }
    public void insertCardAll(List<CardEntity> cardEntitylist) {
        cardRepository.insertCardAll(cardEntitylist);
    }

    public void loadDataFromDataBase(Context context,String archeType){
        Observable.fromCallable(new Callable<List<CardWithCardSetCardImageCardPriceEntity>>() {
                    @Override
                    public List<CardWithCardSetCardImageCardPriceEntity>  call() throws Exception {
                        return cardRepository.getCardByArcheType(archeType);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CardWithCardSetCardImageCardPriceEntity> >() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(List<CardWithCardSetCardImageCardPriceEntity>  cardWithCardSetCardImageCardPriceEntityList) {
                        try {
                            cardList = cardWithCardSetCardImageCardPriceEntityList;
                            if (cardList.size() == 0)
                                loadDataFromServer(context, archeType);
                            else
                                mPanelResponse.postValue(CardAdapter.toCardViewModelView(cardList));
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        CardViewModelView cardViewModelView = new CardViewModelView();
                        cardViewModelView.message = "Ocurrió un error";
                        cardViewModelView.isError = TRUE;
                        mPanelResponse.postValue(cardViewModelView);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public  void loadDataFromServer(Context context, String archeType){
        Observable.defer(() -> Observable.just(CardHelper.getAll(context, archeType)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                            insertCardAll(toCardEntityList(item.cardList));
                            loadDataFromDataBase(context,archeType);
                        },
                        error -> {
                            CardViewModelView cardViewModelView = new CardViewModelView();
                            cardViewModelView.message = "Ocurrió un error";
                            cardViewModelView.isError = TRUE;
                            mPanelResponse.postValue(cardViewModelView);
                        },
                        () -> System.out.println("User Finish")
                );
    }
}