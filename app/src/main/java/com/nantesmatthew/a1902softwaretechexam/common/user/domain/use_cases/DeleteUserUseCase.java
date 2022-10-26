package com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class DeleteUserUseCase {
    private UserRepository repository;

    @Inject
    public DeleteUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public Completable deleteUser(User user){
        return repository.deleteUser(user);
    }
}
