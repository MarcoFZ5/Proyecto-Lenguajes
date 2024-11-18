/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.controller;

import com.autodream.domain.Formulario;
import com.autodream.services.AutoService;
import com.autodream.services.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private FormularioService formularioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = autoService.getAutos();
        model.addAttribute("autos", lista);
        return "/formulario/listado";
    }
    
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = formularioService.getFormularios();
        model.addAttribute("formularios", lista);
        model.addAttribute("totalClientes", lista.size());
        return "/formulario/listado2";
    }

    @PostMapping("/guardar")
    public String guardar(Formulario formulario) {

        formularioService.save(formulario);
        
        return "redirect:/";
    }
}
