package com.autodream.services.impl;

import com.autodream.dao.FormularioDao;
import com.autodream.domain.Formulario;
import com.autodream.services.FormularioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormularioServiceImpl implements FormularioService {
     @Autowired
    private FormularioDao formularioDao;

    @Override
    public List<Formulario> getFormularios() {
        var lista = formularioDao.findAll();
        
        return lista;
    }

    @Override
    public Formulario getFormulario(Formulario formulario) {
        return formularioDao.findById(formulario.getIdFormulario()).orElse(null);
    }

    @Override
    public void save(Formulario formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void delete(Formulario formulario) {
        formularioDao.delete(formulario);
    }


    
}
