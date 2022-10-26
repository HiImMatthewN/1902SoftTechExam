package com.nantesmatthew.a1902softwaretechexam.common.credentials.data.repository;

import android.util.Log;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.data_source.CredentialDao;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.entites.CredentialsLocalEntity;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.mapper.CredentialsLocalMapper;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public class CredentialsRepositoryImpl implements CredentialsRepository {
    private CredentialDao dao;
    private static final String TAG = "CredentialsRepositoryIm";
    @Inject
    public CredentialsRepositoryImpl(CredentialDao dao) {
        this.dao = dao;
    }

    @Override
    public Completable saveCredential(Credentials credentials) {
        return dao.saveCredential(new CredentialsLocalMapper().mapToEntity(credentials));
    }

    @Override
    public Completable deleteCredential(String userName) {
        return dao.deleteCredential(userName);
    }

    @Override
    public Single<Credentials> checkCredential(String userName, String password) {
        Log.d(TAG, "checkCredential: CHECKING");
        return dao.checkCredential(userName,password).map(credentialsLocalEntity ->{
            Log.d(TAG, "checkCredential: TEST");
            return new CredentialsLocalMapper().mapFromEntity(credentialsLocalEntity);
        });
    }

    @Override
    public Completable deleteAll() {
        return dao.deleteAll();
    }
}
