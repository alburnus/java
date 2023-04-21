package com.github.alburnus.javastuff.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ModelEntity {
    @Id
    String id;
}
