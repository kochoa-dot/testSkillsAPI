package com.test.Test.of.skills.service;

import com.test.Test.of.skills.entities.Rol;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface RolService {
    String saveRol(Rol rol);

    public List<Rol> getAllRoles();

    Rol getRolByID(Integer id_rol);

    Rol updateRoles(Rol newRol, Integer id_rol);

    String deleteRoles(Integer id_rol);

}
