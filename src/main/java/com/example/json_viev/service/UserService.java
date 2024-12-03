package com.example.json_viev.service;

import com.example.json_viev.exception.UserNotFoundException;
import com.example.json_viev.model.Order;
import com.example.json_viev.model.User;
import com.example.json_viev.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getUser(long id) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        for (Order order: user.getOrders()) {
            order.calculateSumm();
        }
        return user;
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) throws UserNotFoundException {
        User user1 = getUser(user.getId());
        if (user.getName() != null) user1.setName(user.getName());
        if (user.getEmail() != null) user1.setEmail(user.getEmail());
        if (user.getOrders() != null) user1.setOrders(user.getOrders());
        return repository.save(user1);
    }

    public void deleteUser(long id) {
        repository.deleteById(id);
    }
}
