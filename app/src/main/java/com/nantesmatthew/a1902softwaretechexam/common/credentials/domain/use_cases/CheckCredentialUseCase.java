package com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class CheckCredentialUseCase {
    private CredentialsRepository repository;

    @Inject
    public CheckCredentialUseCase(CredentialsRepository repository) {
        this.repository = repository;
    }

   public Single<Credentials> checkCredential(String userName, String password){
        return repository.checkCredential(userName, password);
    }
}
