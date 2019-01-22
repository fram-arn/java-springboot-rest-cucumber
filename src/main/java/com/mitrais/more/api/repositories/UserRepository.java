package com.mitrais.more.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.more.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
