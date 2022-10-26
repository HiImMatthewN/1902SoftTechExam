package com.nantesmatthew.a1902softwaretechexam.common.credentials.data.mapper;

import com.nantesmatthew.a1902softwaretechexam.common.credentials.data.entites.CredentialsLocalEntity;
import com.nantesmatthew.a1902softwaretechexam.common.credentials.domain.Credentials;
import com.nantesmatthew.a1902softwaretechexam.core.util.EntityMapper;

public class CredentialsLocalMapper implements EntityMapper<CredentialsLocalEntity, Credentials> {
    @Override
    public Credentials mapFromEntity(CredentialsLocalEntity credentialsLocalEntity) {
        return new Credentials(credentialsLocalEntity.getUserName(),credentialsLocalEntity.getPassword());
    }

    @Override
    public CredentialsLocalEntity mapToEntity(Credentials credentials) {
        return new CredentialsLocalEntity(credentials.getUserName(), credentials.getPassword());
    }
}
