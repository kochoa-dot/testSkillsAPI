package com.test.Test.of.skills.controller;

import com.test.Test.of.skills.entities.Users;
import com.test.Test.of.skills.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        String usuario = user.getUsuario();
        String contrasena = user.getContrasena();

        boolean isAuthenticated = usersService.authenticate(usuario, contrasena);

        if (isAuthenticated) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PostMapping("/add")
    public String add(@RequestBody Users users){
        return usersService.saveUser(users);
    }

    @GetMapping("/getAll")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/getByid/{id_user}")
    public Users getById(@PathVariable Integer id_user){
        return usersService.getUserByID(id_user);
    }

    @PutMapping("/update/{id_user}")
    public Users update(@RequestBody Users newUser, @PathVariable Integer id_user){
        return usersService.updateUser(newUser, id_user);
    }

    @DeleteMapping("/delete/{id_user}")
    public String deleteUser(@PathVariable Integer id_user){
        return usersService.deleteUser(id_user);
    }
}
