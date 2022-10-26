package com.nantesmatthew.a1902softwaretechexam.common.user.data.repository;


import com.nantesmatthew.a1902softwaretechexam.common.user.data.data_source.UserDao;
import com.nantesmatthew.a1902softwaretechexam.common.user.data.mapper.UserLocalMapper;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.repository.UserRepository;
import com.nantesmatthew.a1902softwaretechexam.core.util.Resource;
import com.nantesmatthew.a1902softwaretechexam.core.util.Status;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

public class UserRepositoryImpl implements UserRepository {
    private UserDao dao;

    @Inject
    public UserRepositoryImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Completable saveUser(User user) {
       return dao.insert(new UserLocalMapper().mapToEntity(user));
    }

    @Override
    public Completable deleteUser(User user) {
        return dao.delete(user.getUserName());
    }

    @Override
    public Flowable<List<User>> getUsers() {
        return dao.getUsers().map(userLocalEntities -> {
            return new UserLocalMapper().mapFromEntityList(userLocalEntities);
        });
    }

    @Override
    public Completable deleteAll() {
        return dao.deleteAll();
    }
}
