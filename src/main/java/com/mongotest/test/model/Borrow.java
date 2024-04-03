package com.mongotest.test.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Data
public abstract class Borrow {

    @Id
    @EqualsAndHashCode.Include
    private ObjectId id;

    @DocumentReference
    private User borrower;

    private Date actualReturnDate;

    @DocumentReference
    private User borrowee;

    private BorrowStatus status;

    public abstract String getType();


}
