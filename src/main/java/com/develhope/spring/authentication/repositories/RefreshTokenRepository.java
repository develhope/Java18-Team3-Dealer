package com.develhope.spring.authentication.repositories;


import com.develhope.spring.User.Entity.Users;
import com.develhope.spring.authentication.entities.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Integer> {
    Optional<RefreshToken> findByToken(String token);
    List<RefreshToken> findByUserInfo(Users user);
}
