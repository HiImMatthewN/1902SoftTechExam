package com.nantesmatthew.a1902softwaretechexam.common.credentials.data.data_source;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.entites.CredentialsLocalEntity;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface CredentialDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable saveCredential(CredentialsLocalEntity credentialsLocalEntity);

    @Query("DELETE FROM credentials_table WHERE user_name = :userName")
    Completable deleteCredential(String userName);

    @Query("SELECT * FROM credentials_table WHERE user_name =:userName AND password =:password")
    Single<CredentialsLocalEntity> checkCredential(String userName, String password);

    @Query("DELETE FROM credentials_table")
    Completable deleteAll();
}
