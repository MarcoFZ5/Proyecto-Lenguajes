/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.services.impl;

import com.autodream.dao.TransmisionDao;
import com.autodream.domain.Transmision;
import com.autodream.services.TransmisionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransmisionServiceImpl implements TransmisionService{
    
    @Autowired
    private TransmisionDao transmisionDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Transmision> getTransmisiones() {
      var lista = transmisionDao.findAll();
      
      return lista;
    }

    @Override
    public Transmision getTransmision(Transmision transmision) {
        return transmisionDao.findById(transmision.getIdTransmision()).orElse(null);
    }

    @Override
    public void save(Transmision transmision) {
        transmisionDao.save(transmision);
    }

    @Override
    public void delete(Transmision transmision) {
        transmisionDao.delete(transmision);
    }

    
    
}
