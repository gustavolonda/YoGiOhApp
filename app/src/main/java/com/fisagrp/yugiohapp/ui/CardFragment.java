package com.fisagrp.yugiohapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fisagrp.yugiohapp.R;
import com.fisagrp.yugiohapp.adapter.CardAdapter;
import com.fisagrp.yugiohapp.databinding.FragmentCardBinding;
import com.fisagrp.yugiohapp.domain.CardEntityViewModel;
import com.fisagrp.yugiohapp.domain.CardItemListViewModelAdapter;
import com.fisagrp.yugiohapp.domain.CardItemListViewModelAdapterListener;
import com.fisagrp.yugiohapp.domain.CardViewModelView;

public class CardFragment extends Fragment implements CardItemListViewModelAdapterListener, AdapterView.OnItemSelectedListener {
    FragmentCardBinding mBinding;
    CardEntityViewModel mViewModel;
    CardItemListViewModelAdapter mAdapter;
    public static final String[] archeTypes = {"Crystron" ,
                                            "Destiny HERO" ,
                                            "Six Samurai"};
    public static  String TAG = CardFragment.class.getSimpleName();
    private Spinner spinner;
    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance() {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_card,container,false);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(CardEntityViewModel.class);
        mBinding.progressCircular.getRoot().setVisibility(View.VISIBLE);
        mBinding.recyclerview.setVisibility(View.GONE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mViewModel.getPanel().observe(getActivity(), response -> {
            mAdapter.setItems(response.cardItemList);
            mBinding.progressCircular.getRoot().setVisibility(View.GONE);
            mBinding.recyclerview.setVisibility(View.VISIBLE);
        });
        mAdapter = new CardItemListViewModelAdapter(getActivity(),this);
        mBinding.recyclerview.setLayoutManager(layoutManager);
        mBinding.recyclerview.setAdapter(mAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,archeTypes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBinding.spinner.setAdapter(adapter);
        mBinding.spinner.setOnItemSelectedListener(this);
        mViewModel.loadDataFromDataBase(getContext(), archeTypes[0] );
        return mBinding.getRoot();
    }

    @Override
    public void showCardDetails(int cardId) {
        try {
            startActivity(CardDetailsActivity.loadActivity(getActivity(),cardId));
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id)   {
        mBinding.progressCircular.getRoot().setVisibility(View.VISIBLE);
        mBinding.recyclerview.setVisibility(View.GONE);
        mViewModel.loadDataFromDataBase(getContext(), archeTypes[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}