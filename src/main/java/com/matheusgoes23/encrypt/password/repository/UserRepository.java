package com.matheusgoes23.encrypt.password.repository;

import com.matheusgoes23.encrypt.password.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByLogin(String login);
}
