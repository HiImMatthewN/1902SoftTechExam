package com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class DeleteAllCredentialUseCase {
    private CredentialsRepository credentialsRepository;

    @Inject
    public DeleteAllCredentialUseCase(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }
    public Completable deleteAll(){
        return credentialsRepository.deleteAll();
    }
}
