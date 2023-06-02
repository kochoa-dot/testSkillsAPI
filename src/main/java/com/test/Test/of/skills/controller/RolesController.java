package com.test.Test.of.skills.controller;

import com.test.Test.of.skills.entities.Rol;
import com.test.Test.of.skills.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolesController {
    @Autowired
    private RolService rolService;

    @PostMapping("/add")
    public String add(@RequestBody Rol rol){
        return rolService.saveRol(rol);
    }

    @GetMapping("/getAll")
    public List<Rol> getAllRoles(){
        return rolService.getAllRoles();
    }

    @GetMapping("/getRolByID/{id_rol}")
    public Rol getRolById(@PathVariable Integer id_rol){
        return rolService.getRolByID(id_rol);
    }

    @PutMapping("/updateRol/{id_rol}")
    public Rol updateRol(@RequestBody Rol newRol, @PathVariable Integer id_rol){
        return rolService.updateRoles(newRol, id_rol);
    }

    @DeleteMapping("/deleteRol/{id_rol}")
    public String deleteRol(@PathVariable Integer id_rol){
        return rolService.deleteRoles(id_rol);
    }
}
