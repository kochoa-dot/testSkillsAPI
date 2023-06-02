package com.test.Test.of.skills.service;

import com.test.Test.of.skills.entities.Rol;
import com.test.Test.of.skills.exception.RolNotFoundException;
import com.test.Test.of.skills.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public String saveRol(Rol rol) {
        rolRepository.save(rol);
        return "New rol has added";
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getRolByID(Integer id_rol) {
        return rolRepository.findById(id_rol).orElseThrow(()-> new RolNotFoundException(id_rol));
    }

    @Override
    public Rol updateRoles(Rol newRol, Integer id_rol) {
        return rolRepository.findById(id_rol).map(rol -> {
            rol.setRol(newRol.getRol());
            return rolRepository.save(rol);
        }).orElseThrow(()-> new RolNotFoundException(id_rol));
    }

    @Override
    public String deleteRoles(Integer id_rol) {

        if (!rolRepository.existsById(id_rol)){
            throw new RolNotFoundException(id_rol);
        }
        rolRepository.deleteById(id_rol);
        return "Rol with id " + id_rol + " has been deleted";
    }

}
