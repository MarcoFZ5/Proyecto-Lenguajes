
package com.autodream.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;


@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto")
    private Long idContacto;
    //private Long idCategoria; No se utiliza mas por el arroba ManyToOne
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    
   @OneToMany
    @JoinColumn(name="id_contacto", updatable=false)
    private List<Formulario> formulario;
}
