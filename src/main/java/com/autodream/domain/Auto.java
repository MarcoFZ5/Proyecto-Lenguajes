
package com.autodream.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author yagoa
 */
@Data
@Entity
@Table(name = "auto")
public class Auto implements Serializable {

    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auto")
    private Long idAuto;
    //private Long idCategoria; No se utiliza mas por el arroba ManyToOne
    private String marca;
    private String modelo;
    private int año;
   
    private double cilindrada;
    
    private int kilometraje;
    private double precio;
    private String rutaImagen;
    
    
 @ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="id_categoria")
private Categoria categoria;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_color")
private Color color;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_transmision")
private Transmision transmision;

   
   
   
}



