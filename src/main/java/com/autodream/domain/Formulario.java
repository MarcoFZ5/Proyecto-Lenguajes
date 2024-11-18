
package com.autodream.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "formulario")
public class Formulario implements Serializable {

    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formulario")
    private Long idFormulario;

   @ManyToOne
   @JoinColumn(name="id_contacto")
   private Contacto contacto;
    @ManyToOne
   @JoinColumn(name="id_auto")
   private Auto auto;
 
}
