package com.github.alburnus.javastuff.entity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelRepository extends MongoRepository<ModelEntity, String> {
}
