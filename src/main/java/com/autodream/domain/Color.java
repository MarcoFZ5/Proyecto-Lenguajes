/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author yagoa
 */
@Data
@Entity
@Table(name = "color")
public class Color implements Serializable{

    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color")
    private Long idColor;
    //private Long idCategoria; No se utiliza mas por el arroba ManyToOne
    private String descripcion;

    
   @OneToMany
    @JoinColumn(name="id_color", updatable=false)
   @ToString.Exclude
    private List<Auto> auto;


}
