/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.services.impl;

import com.autodream.dao.ContactoDao;
import com.autodream.domain.Contacto;
import com.autodream.services.ContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDao contactoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Contacto> getContactos() {
      var lista = contactoDao.findAll();
      
      return lista;
    }

    @Override
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }

    
    
}
