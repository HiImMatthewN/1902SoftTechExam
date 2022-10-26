package com.nantesmatthew.a1902softwaretechexam.common.user.data.mapper;

import com.nantesmatthew.a1902softwaretechexam.common.user.data.entites.UserLocalEntity;
import com.nantesmatthew.a1902softwaretechexam.common.user.domain.User;
import com.nantesmatthew.a1902softwaretechexam.core.util.EntityMapper;

import java.util.ArrayList;
import java.util.List;

public class UserLocalMapper implements EntityMapper<UserLocalEntity, User> {
    @Override
    public User mapFromEntity(UserLocalEntity userLocalEntity) {
        return new User(
                userLocalEntity.getFullName(),
                userLocalEntity.getEmail(),
                userLocalEntity.getUserName(),
                userLocalEntity.getDesignation(),
                userLocalEntity.getInformation());
    }

    @Override
    public UserLocalEntity mapToEntity(User user) {
        return new UserLocalEntity(
                user.getFullName(),
                user.getEmail(),
                user.getUserName(),
                user.getDesignation(),
                user.getInformation());
    }
    public List<User> mapFromEntityList(List<UserLocalEntity> userLocalEntities){
        ArrayList<User> users = new ArrayList<>();
        for (UserLocalEntity userLocalEntity : userLocalEntities){
            User user = mapFromEntity(userLocalEntity);
            users.add(user);
        }
        return users;
    }
}
