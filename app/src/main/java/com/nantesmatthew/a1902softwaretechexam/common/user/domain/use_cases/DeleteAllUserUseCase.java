package com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class DeleteAllUserUseCase {
    private UserRepository repository;

    @Inject
    public DeleteAllUserUseCase(UserRepository repository) {
        this.repository = repository;
    }
    public Completable deleteAllUser(){
        return repository.deleteAll();
    }
}
