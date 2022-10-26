package com.nantesmatthew.a1902softwaretechexam.common.user.data.data_source;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nantesmatthew.a1902softwaretechexam.common.user.data.entites.UserLocalEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(UserLocalEntity userLocalEntity);

    @Query("DELETE FROM user_table WHERE user_name =:userName")
    Completable delete(String userName);

    @Query("SELECT * FROM user_table")
    Flowable<List<UserLocalEntity>> getUsers();

    @Query("DELETE FROM user_table")
    Completable deleteAll();

}
