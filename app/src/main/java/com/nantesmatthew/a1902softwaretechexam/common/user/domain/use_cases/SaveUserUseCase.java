package com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;
import com.nantesmatthew.a1902softwaretechexam.core.util.Resource;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class SaveUserUseCase {
    private UserRepository repository;

    @Inject
    public SaveUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public Completable saveUser(User user){
        return repository.saveUser(user);
    }
}
