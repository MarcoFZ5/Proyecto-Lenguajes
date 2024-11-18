/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.autodream.services;

import com.autodream.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se obtien los registros de la tabla categoria en un Arraylist
    //de objetos Categoria, todos o solo los activos
    public List<Categoria> getCategorias( );
    
    //Recupera el registro de la tabla categoria es un objeto Categoria
    //si el idCategoria existe... sino devuelve null
    public Categoria getCategoria(Categoria categoria);
    
    //Actualiza un registro en la tabla categoria si el idCategoria exite
    //Cre un registro en la tabla categoria si idCategoria no tiene valor
    public void save(Categoria categoria);
    
    //
    //
    public void delete(Categoria categoria);
}
