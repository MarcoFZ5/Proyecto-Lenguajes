/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.controller;

import com.autodream.domain.Categoria;
import com.autodream.domain.Auto;
import com.autodream.services.CategoriaService;
import com.autodream.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.autodream.services.AutoService;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private AutoService autoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {

        var autos = autoService.getAutos();
        model.addAttribute("autos", autos);
        
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria,Model model) {
        var autos=categoriaService.getCategoria(categoria).getAuto();
        model.addAttribute("autos", autos);
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }

}
