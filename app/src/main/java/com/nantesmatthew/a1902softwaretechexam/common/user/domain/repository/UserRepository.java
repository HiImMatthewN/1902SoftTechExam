package com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository;

import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.core.util.Resource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public interface UserRepository {

    Completable saveUser(User user);

    Completable deleteUser(User user);

    Flowable<List<User>> getUsers();

    Completable deleteAll();
}
