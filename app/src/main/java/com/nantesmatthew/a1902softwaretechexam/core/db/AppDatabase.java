package com.nantesmatthew.a1902softwaretechexam.core.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.data_source.CredentialDao;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.entites.CredentialsLocalEntity;
import com.nantesmatthew.a1902softwaretechexam.common.user.data.data_source.UserDao;
import com.nantesmatthew.a1902softwaretechexam.common.user.data.entites.UserLocalEntity;

@Database(entities = {UserLocalEntity.class, CredentialsLocalEntity.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract CredentialDao credentialDao();
}