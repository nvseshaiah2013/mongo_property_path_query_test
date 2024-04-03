package com.mongotest.test.repository;

import com.mongotest.test.model.BorrowMoney;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowMoneyRepository extends MongoRepository<BorrowMoney, ObjectId> {
}
