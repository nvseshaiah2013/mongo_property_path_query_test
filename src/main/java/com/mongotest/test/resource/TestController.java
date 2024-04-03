package com.mongotest.test.resource;

import com.mongodb.client.MongoClient;
import com.mongotest.test.model.*;
import com.mongotest.test.repository.BorrowItemRepository;
import com.mongotest.test.repository.BorrowRepository;
import com.mongotest.test.repository.ReminderRepository;
import com.mongotest.test.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoClient mongoClient;

    @GetMapping("/generate-users")
    public ResponseEntity<String> method1() {

        User borrower = new User();
        borrower.setName("borrower");
        borrower.setEmail("borrower@gmail.com");
        borrower.setPassword("aasdsad");
        userRepository.save(borrower);

        User borowee = new User();
        borowee .setName("borrowee");
        borowee     .setEmail("borrowee@gmail.com");
        borowee .setPassword("asdasd");

        userRepository.save(borowee);

        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/generate-reminders")
    public ResponseEntity<String> method2() {

        List<User> users = userRepository.findAll();

        var borrower = users.stream().filter(b -> "borrower".equals(b.getName())).findAny();

        var borowee = users.stream().filter(b -> "borrowee".equals(b.getName())).findAny();

        Borrow borrow = new BorrowItem();

        borrow   .setStatus(BorrowStatus.APPROVED);
        borrow    .setBorrowee(borowee.get());
        borrow     .setBorrower(borrower.get());

        Reminder reminder = Reminder.builder()
                .message("asdsad")
                .borrow(borrowRepository.save(borrow))
                .build();


        reminderRepository.save(reminder);

        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/get-reminders")
    public ResponseEntity<List<Reminder>> getReminders() {
        ObjectId id = userRepository.findAll().stream()
                .filter(user -> "borrower".equals(user.getName())).findFirst().get().getId();

        return ResponseEntity.ok(reminderRepository.findByBorrowBorrowerId(id));
    }
}
