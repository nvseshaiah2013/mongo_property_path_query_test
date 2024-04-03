package com.mongotest.test.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class BorrowItem extends Borrow{

    private String itemName;

    public String getType() {
        return "ITEM";
    }

}
