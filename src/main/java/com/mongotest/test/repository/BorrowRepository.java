package com.mongotest.test.repository;

import com.mongotest.test.model.Borrow;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends MongoRepository<Borrow, ObjectId> {
}
