
package com.autodream.domain;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
   
    private String descripcion;
    
    @OneToMany
    @JoinColumn(name="id_categoria", updatable=false)
    @ToString.Exclude
    private List<Auto> auto;
    
    
   
}
