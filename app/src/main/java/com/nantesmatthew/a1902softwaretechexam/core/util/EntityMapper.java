package com.nantesmatthew.a1902softwaretechexam.core.util;

public interface EntityMapper <Entity,Domain>{

    Domain mapFromEntity(Entity entity);

    Entity mapToEntity(Domain domain);

}
