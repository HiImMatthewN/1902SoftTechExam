package com.nantesmatthew.a1902softwaretechexam.common.user.domain.use_cases;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class GetUsersUseCase {
    private UserRepository repository;

    @Inject
    public GetUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

   public Flowable<List<User>> getUsers(){
        return repository.getUsers();
    }
}
