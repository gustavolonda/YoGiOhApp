package com.fisagrp.yugiohapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fisagrp.yugiohapp.R;

public class CardDetailsActivity extends AppCompatActivity {

    public static final String CARD_ID = "card_id";
    public static final String PARAMS = "params";
    private CardDetailsFragment cardDetailsFragment;
    private int mCardId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        Bundle parms = getIntent().getBundleExtra(PARAMS);
        if(parms != null)
        {

            mCardId = parms.getInt(CARD_ID,0);
        }
        if (savedInstanceState == null)
        {
            // Init Fragment
            cardDetailsFragment = CardDetailsFragment.newInstance(mCardId);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, cardDetailsFragment, CardDetailsFragment.TAG)
                    .commit();
        } else {
            // Get Fragment
            cardDetailsFragment = (CardDetailsFragment) getSupportFragmentManager().findFragmentByTag(CardDetailsFragment.TAG);
        }
    }
    public static Intent loadActivity(Context context, int cardId)
    {
        Intent intent = new Intent(context, CardDetailsActivity.class);
        Bundle parms = new Bundle();
        parms.putInt(CARD_ID, cardId);
        intent.putExtra(PARAMS, parms);
        return intent;
    }
}