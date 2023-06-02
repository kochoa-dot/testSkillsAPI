package com.test.Test.of.skills.repository;

import com.test.Test.of.skills.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsuario(String usuario);
}
