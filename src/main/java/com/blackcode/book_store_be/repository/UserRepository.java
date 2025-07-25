package com.blackcode.book_store_be.repository;

import com.blackcode.book_store_be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);
    Boolean existsByUserName(String username);

}
