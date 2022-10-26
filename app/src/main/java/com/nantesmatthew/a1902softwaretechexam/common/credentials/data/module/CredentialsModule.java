package com.nantesmatthew.a1902softwaretechexam.common.credentials.data.module;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.data_source.CredentialDao;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.repository.CredentialsRepositoryImpl;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;
import com.nantesmatthew.a1902softwaretechexam.core.db.AppDatabase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class CredentialsModule {

    @Provides
    public CredentialDao providesCredentialDao(AppDatabase appDatabase){
        return appDatabase.credentialDao();
    }

    @Provides
    public CredentialsRepository providesCredentialsRepository(CredentialDao dao){
        return new CredentialsRepositoryImpl(dao);
    }

}
