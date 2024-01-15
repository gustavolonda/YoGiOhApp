package com.fisagrp.yugiohapp.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fisagrp.yugiohapp.data.entity.CardEntity;
import com.fisagrp.yugiohapp.data.entity.CardImageEntity;
import com.fisagrp.yugiohapp.data.entity.CardPriceEntity;
import com.fisagrp.yugiohapp.data.entity.CardSetEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CardEntity.class,
                    CardImageEntity.class,
                    CardSetEntity.class,
                    CardPriceEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDao getCardDao();

    private static volatile  AppDatabase appDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (appDatabase == null) {
            synchronized (AppDatabase.class) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "card_database")
                            .build();
                }
            }
        }
        return appDatabase;
    }
}