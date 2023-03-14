package com.solvd.saucedemoproxy.db.service.impl;

import com.solvd.saucedemoproxy.db.domain.User;
import com.solvd.saucedemoproxy.db.domain.exception.QueryException;
import com.solvd.saucedemoproxy.db.persistence.UserRepository;
import com.solvd.saucedemoproxy.db.persistence.impl.UserMapperImpl;
import com.solvd.saucedemoproxy.db.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserMapperImpl();
    }

    @Override
    public User create(User user) {
        user.setId(null);
        userRepository.create(user);
        return user;
    }

    @Override
    public User read(Long userId, Long orderId) {
        return userRepository.read(userId, orderId)
                .orElseThrow(() -> new QueryException("No users found"));
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}