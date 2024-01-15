package com.fisagrp.yugiohapp.ui;

import static com.fisagrp.yugiohapp.adapter.CardAdapter.toCardDetailsItemViewModelView;
import static com.fisagrp.yugiohapp.ui.CardDetailsActivity.CARD_ID;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fisagrp.yugiohapp.R;
import com.fisagrp.yugiohapp.databinding.FragmentCardDetailsBinding;
import com.fisagrp.yugiohapp.domain.CardDetailsItemViewModelView;
import com.fisagrp.yugiohapp.domain.CardDetailsViewModel;
import com.fisagrp.yugiohapp.domain.CardEntityViewModel;
import com.squareup.picasso.Picasso;

public class CardDetailsFragment extends Fragment {

    public static final String TAG = CardDetailsFragment.class.getSimpleName();
    private AppCompatActivity mParentActivity;
    private FragmentCardDetailsBinding mBinding;
    private int mCardId;
    private CardDetailsViewModel mViewModel;
    public CardDetailsFragment() {
        // Required empty public constructor
    }


    public static CardDetailsFragment newInstance(int cardId) {
        CardDetailsFragment fragment = new CardDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(CARD_ID, cardId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCardId = getArguments().getInt(CARD_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_card_details,container,false);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(CardDetailsViewModel.class);
        mViewModel.loadDataFromDataBase(mCardId).observe(getActivity(),response ->{
            CardDetailsItemViewModelView cardDetailsItemViewModelView = toCardDetailsItemViewModelView(response);
            mBinding.toolbar.setTitle(cardDetailsItemViewModelView.name);
            mBinding.setDataViewModel(cardDetailsItemViewModelView);
            if(response.cardImageList.size() > 0){
                String imageUrlCropped = response.cardImageList.get(0).imageUrlCropped;
                try {
                    Picasso.get()
                            .load(imageUrlCropped)
                            .error(R.drawable.no_image)
                            .into(mBinding.cardImageId);
                }catch (Exception e){
                    e.fillInStackTrace();
                }
            }
        });

        return mBinding.getRoot();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Setting the Toolbal.
        if(mParentActivity != null){
            mParentActivity.setSupportActionBar(mBinding.toolbar);
            setHasOptionsMenu(true);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == android.R.id.home) {
            if(mParentActivity!=null) mParentActivity.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
        @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mParentActivity = (AppCompatActivity) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}