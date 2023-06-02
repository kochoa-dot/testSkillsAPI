package com.test.Test.of.skills.service;

import com.test.Test.of.skills.entities.Users;
import com.test.Test.of.skills.exception.UserNotFoundException;
import com.test.Test.of.skills.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService{

    @Autowired UsersRepository usersRepository;

    @Override
    public String saveUser(Users users) {
        usersRepository.save(users);
        return "New user has added";
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserByID(Integer id_user) {
        return usersRepository.findById(id_user).orElseThrow(()-> new UserNotFoundException(id_user));
    }

    @Override
    public Users updateUser(Users newUser, Integer id_user) {
        return usersRepository.findById(id_user).map(users -> {
            users.setUsuario(newUser.getUsuario());
            users.setContrasena(newUser.getContrasena());
            users.setRol(newUser.getRol());
            return usersRepository.save(users);
        }).orElseThrow(()-> new UserNotFoundException(id_user));
    }

    @Override
    public String deleteUser(Integer id_user) {
        if (!usersRepository.existsById(id_user)){
            throw new UserNotFoundException(id_user);
        }
        usersRepository.deleteById(id_user);
        return "User with id " + id_user + " has been deleted";
    }

    @Override
    public boolean authenticate(String usuario, String contrasena) {
        Users user = usersRepository.findByUsuario(usuario);
        if (user != null && user.getContrasena().equals(contrasena)) {
            return true;
        }
        return false;
    }
}
