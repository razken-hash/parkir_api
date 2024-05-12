package com.parkir.parkir_api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> getUserByEmailAndPassword(String email, String password);
    public Optional<User> findByEmail(String email);
}
