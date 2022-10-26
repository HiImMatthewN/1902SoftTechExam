package com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class SaveCredentialUseCase {
    private CredentialsRepository repository;

    @Inject
    public SaveCredentialUseCase(CredentialsRepository repository) {
        this.repository = repository;
    }

    public Completable saveCredential(Credentials credentials){
        return repository.saveCredential(credentials);
    }
}
