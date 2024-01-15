package com.fisagrp.yugiohapp.ui;

import static com.fisagrp.yugiohapp.util.FragmentUtil.addFragment;

import android.os.Bundle;

import com.fisagrp.yugiohapp.R;
import com.fisagrp.yugiohapp.data.database.CardDao;
import com.fisagrp.yugiohapp.data.database.AppDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    AppDatabase db;
    CardDao cardDao;
    CardFragment cardFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
        {
            // Init Fragment
            cardFragment = CardFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, cardFragment, CardFragment.TAG)
                    .commit();

        } else {
            // Get Fragment
            cardFragment = (CardFragment) getSupportFragmentManager().findFragmentByTag(CardFragment.TAG);
        }
    }

}