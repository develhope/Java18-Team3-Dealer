package com.develhope.spring.User.Repository;

import com.develhope.spring.User.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsersRepository extends JpaRepository<User, Long> {
}