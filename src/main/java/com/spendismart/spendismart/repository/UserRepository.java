package com.spendismart.spendismart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spendismart.spendismart.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
