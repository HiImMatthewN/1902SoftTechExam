package com.nantesmatthew.a1902softwaretechexam.common.user.data.module;

import com.nantesmatthew.a1902softwaretechexam.common.user.data.data_source.UserDao;
import com.nantesmatthew.a1902softwaretechexam.common.user.data.repository.UserRepositoryImpl;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;
import com.nantesmatthew.a1902softwaretechexam.core.db.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UserModule {

    @Provides
    public UserDao providesUserDao(AppDatabase appDatabase){
        return appDatabase.userDao();
    }

    @Provides
    public UserRepository providesUserRepository(UserDao dao){
        return new UserRepositoryImpl(dao);
    }
}
