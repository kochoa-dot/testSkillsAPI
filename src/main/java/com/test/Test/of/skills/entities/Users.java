package com.test.Test.of.skills.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.tool.schema.spi.SchemaTruncator;

@Entity(name = "Users") @Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String usuario;

    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
