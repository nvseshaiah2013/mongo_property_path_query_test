package com.mongotest.test.repository;

import com.mongotest.test.model.Reminder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends MongoRepository<Reminder, ObjectId> {

    List<Reminder> findByBorrowBorrowerId(ObjectId id);
}
