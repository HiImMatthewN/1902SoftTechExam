package com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.repository.CredentialsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class DeleteCredentialUseCase {
    private CredentialsRepository credentialsRepository;

    @Inject
    public DeleteCredentialUseCase(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Completable delete(String userName){
        return credentialsRepository.deleteCredential(userName);
    }
}
