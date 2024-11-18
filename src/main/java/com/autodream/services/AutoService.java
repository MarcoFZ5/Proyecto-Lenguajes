/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.autodream.services;

import com.autodream.domain.Auto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface AutoService {
    //Se obtien los registros de la tabla auto en un Arraylist
    //de objetos Auto, todos o solo los activos
    public List<Auto> getAutos();
    
    

    
    //Recupera el registro de la tabla auto es un objeto Auto
    //si el idAuto existe... sino devuelve null
    public Auto getAuto(Auto auto);
    
    List<Auto> findByPrecioBetweenOrderByMarca(double precioInf, double precioSup);
    List<Auto> findByAñoBetweenOrderByMarca(double AñoInf, double AñoISup);
    List<Auto> findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(String marca, String modelo);
    
    
    //Actualiza un registro en la tabla auto si el idAuto exite
    //Cre un registro en la tabla auto si idAuto no tiene valor
    public void save(Auto auto);
    
    //
    //
    public void delete(Auto auto);
}
