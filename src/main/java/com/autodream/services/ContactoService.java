/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.autodream.services;

import com.autodream.domain.Contacto;
import com.autodream.domain.Formulario;
import com.autodream.domain.Transmision;
import java.util.List;

public interface ContactoService {
    //Se obtien los registros de la tabla auto en un Arraylist
    //de objetos Contacto, todos o solo los activos
    public List<Contacto> getContactos();
    
    //Recupera el registro de la tabla auto es un objeto Contacto
    //si el idAuto existe... sino devuelve null
    public Contacto getContacto(Contacto contacto);
    
    //Actualiza un registro en la tabla auto si el idContacto exite
    //Cre un registro en la tabla auto si idAuto no tiene valor
    public void save(Contacto contacto);
    
    //
    //
    public void delete(Contacto contacto);
}
