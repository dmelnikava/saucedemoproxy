package com.solvd.saucedemoproxy.db.persistence;


import com.solvd.saucedemoproxy.db.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface UserRepository {

    void create(User user);

    Optional<User> read(@Param("userId") Long userId, @Param("orderId") Long orderId);

    void update(User user);

    void delete(Long id);

}