/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.services.impl;

import com.autodream.domain.Auto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.autodream.dao.AutoDao;
import com.autodream.services.AutoService;
import org.springframework.data.jpa.repository.Query;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Auto> getAutos() {
        var lista = autoDao.findAllWithRelations();

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Auto getAuto(Auto auto) {
        
        return autoDao.findById(auto.getIdAuto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Auto auto) {
        autoDao.save(auto);
    }

    @Override
    @Transactional
    public void delete(Auto auto) {
        autoDao.delete(auto);
    }

    
    
    @Override
    @Transactional(readOnly = true)
    public List<Auto> findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(String marca, String modelo) {
        return autoDao.findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(marca, modelo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Auto> findByPrecioBetweenOrderByMarca(double precioInf, double precioSup) {
        return autoDao.findByPrecioBetweenOrderByMarca(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Auto> findByAñoBetweenOrderByMarca(double AñoInf, double AñoISup) {
        return autoDao.findByAñoBetweenOrderByMarca(AñoInf, AñoISup);
    }
}
