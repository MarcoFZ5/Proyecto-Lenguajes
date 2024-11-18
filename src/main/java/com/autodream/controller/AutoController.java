/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodream.controller;

import com.autodream.domain.Auto;
import com.autodream.services.AutoService;
import com.autodream.services.CategoriaService;
import com.autodream.services.ColorService;
import com.autodream.services.FirebaseStorageService;
import com.autodream.services.TransmisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private TransmisionService transmisionService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/listado")
    public String listado( @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size, Model model) {
        var autos = autoService.getAutos();
        model.addAttribute("autos", autos);
        model.addAttribute("totalAutos", autos.size());

      
        

        return "auto/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Auto auto, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            autoService.save(auto);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "auto", auto.getIdAuto());
            auto.setRutaImagen(rutaImagen);
        }
        autoService.save(auto);
        return "redirect:/auto/listado";
    }

    @GetMapping("/eliminar/{idAuto}")
    public String eliminar(Auto auto) {
        autoService.delete(auto);
        return "redirect:/auto/listado";
    }

    @GetMapping("/modificar/{idAuto}")
    public String modificar(Auto auto, Model model) {
        auto = autoService.getAuto(auto);
        model.addAttribute("auto", auto);

        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);

        return "/auto/modifica";
    }
}

