
package com.autodream.domain;


import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rutaImagen;
    
    
    @OneToMany
    @JoinColumn(name="id_usuario", updatable=false)
    private List<Rol> Roles;
    
   
}
