package com.example.json_viev.controller;

import com.example.json_viev.exception.UserNotFoundException;
import com.example.json_viev.model.User;
import com.example.json_viev.model.Views;
import com.example.json_viev.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final UserService service;

    @GetMapping("/users")
    @JsonView(Views.UserSummary.class)
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/user/{id}")
    @JsonView(Views.UserDetails.class)
    public ResponseEntity<User> getUser(@PathVariable long id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

    @PostMapping("/user")
    @JsonView(Views.UserDetails.class)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addUser(user));
    }

    @PutMapping("/user/{id}")
    @JsonView(Views.UserDetails.class)
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) throws UserNotFoundException {
        user.setId(id);
        return ResponseEntity.ok(service.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String > deleteUser(@PathVariable long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("User удалён с id:" + id);
    }
}
