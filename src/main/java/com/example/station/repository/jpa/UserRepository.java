package com.example.station.repository.jpa;

import com.example.station.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findUserByEmbg(String embg);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
    Optional<User> findByUsername(String username);
}
