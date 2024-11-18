/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.services.impl;

import com.autodream.dao.ColorDao;
import com.autodream.domain.Color;
import com.autodream.services.ColorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColorServiceImpl implements ColorService{
    
    @Autowired
    private ColorDao colorDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Color> getColores() {
      var lista = colorDao.findAll();
      
      return lista;
    }

    @Override
    public Color getColor(Color color) {
        return colorDao.findById(color.getIdColor()).orElse(null);
    }

    @Override
    public void save(Color color) {
        colorDao.save(color);
    }

    @Override
    public void delete(Color color) {
        colorDao.delete(color);
    }

    
    
}
