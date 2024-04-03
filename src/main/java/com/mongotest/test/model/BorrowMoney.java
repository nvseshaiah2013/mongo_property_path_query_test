package com.mongotest.test.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "borrows")
@Data
@EqualsAndHashCode(callSuper = true)
public class BorrowMoney extends Borrow{

    private Double amount;

    public String getType() {
        return "MONEY";
    }

}