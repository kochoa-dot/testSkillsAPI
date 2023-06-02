package com.test.Test.of.skills.service;

import com.test.Test.of.skills.entities.Rol;
import com.test.Test.of.skills.entities.Users;


import java.util.List;

public interface UsersService {
    String saveUser(Users users);

    public List<Users> getAllUsers();

    Users getUserByID(Integer id_user);

    Users updateUser(Users newUser, Integer id_user);

    String deleteUser(Integer id_user);

    boolean authenticate(String usuario, String contrasena);
}
