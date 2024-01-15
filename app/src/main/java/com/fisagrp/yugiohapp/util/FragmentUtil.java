package com.fisagrp.yugiohapp.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fisagrp.yugiohapp.R;

public class FragmentUtil {
    public static void addFragment(Fragment fragment, FragmentManager manager) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_container,fragment,"Fragment");
        transaction.commit();
    }
}
