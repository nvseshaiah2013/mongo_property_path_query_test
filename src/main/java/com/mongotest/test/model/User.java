package com.mongotest.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@JsonIgnoreProperties(value = {"password", "email"})
public class User {

    @Id
    @Indexed
    private ObjectId id;

    private String name;

    private String email;

    private String password;
}
