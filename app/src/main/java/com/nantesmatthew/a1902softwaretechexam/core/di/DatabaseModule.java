package com.nantesmatthew.a1902softwaretechexam.core.di;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nantesmatthew.a1902softwaretechexam.common.user.data.data_source.UserDao;
import com.nantesmatthew.a1902softwaretechexam.core.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Singleton
    @Provides
    public AppDatabase appDatabase(@ApplicationContext Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"app_database").build();
    }

}
