package com.solvd.saucedemoproxy.db.persistence.impl;

import com.solvd.saucedemoproxy.db.domain.User;
import com.solvd.saucedemoproxy.db.persistence.MyBatisConfig;
import com.solvd.saucedemoproxy.db.persistence.UserRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class UserMapperImpl implements UserRepository {

    @Override
    public void create(User user) {
        try(SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.create(user);
        }
    }

    @Override
    public Optional<User> read(Long userId, Long orderId) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            return userRepository.read(userId, orderId);
        }
    }

    @Override
    public void update(User user) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.update(user);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true)) {
            UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
            userRepository.delete(id);
        }
    }
}