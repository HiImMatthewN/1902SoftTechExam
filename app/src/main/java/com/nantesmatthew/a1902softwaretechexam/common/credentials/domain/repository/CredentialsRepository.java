package com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface CredentialsRepository {

    Completable saveCredential(Credentials credentials);

    Completable deleteCredential(String userName);

    Single<Credentials> checkCredential(String userName, String password);

    Completable deleteAll();

}
