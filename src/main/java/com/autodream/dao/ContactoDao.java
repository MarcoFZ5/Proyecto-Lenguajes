/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.autodream.dao;

import com.autodream.domain.Categoria;
import com.autodream.domain.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactoDao extends JpaRepository<Contacto,Long>{
    
}
