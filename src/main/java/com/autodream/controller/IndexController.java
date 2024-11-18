package com.autodream.controller;

import com.autodream.domain.Auto;
import com.autodream.services.AutoService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.autodream.services.CategoriaService;
import com.autodream.services.ColorService;
import com.autodream.services.TransmisionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private AutoService autoService;
    
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private TransmisionService transmisionService;

    @GetMapping("/")
    public String listado(Model model) {
        var autos = autoService.getAutos();
        model.addAttribute("autos", autos);
        model.addAttribute("totalAutos", autos.size());

       
    autos.forEach(auto -> System.out.println(auto+"Index"));
   
    
        
        return "index";
        
    }

    @PostMapping("/consulta1")
    public String consulta1(
            @RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup,
            Model model) {

        var autos = autoService.findByPrecioBetweenOrderByMarca(precioInf, precioSup);
        model.addAttribute("autos", autos);

        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);

        return "index";
    }

    @PostMapping("/consulta2")
    public String consulta2(
            @RequestParam(value = "añoInf") int añoInf,
            @RequestParam(value = "añoSup") int añoSup,
            Model model) {

        var autos = autoService.findByAñoBetweenOrderByMarca(añoInf, añoSup);
        model.addAttribute("autos", autos);

        model.addAttribute("añoInf", añoInf);
        model.addAttribute("añoSup", añoSup);

        return "index";
    }

      @GetMapping("/buscar")
    public String buscarAutos(@RequestParam("query") String query, Model model) {
        // Busca tanto por marca como por modelo
        List<Auto> autos = autoService.findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(query, query);
        model.addAttribute("autos", autos);
        model.addAttribute("query", query); // Pasar el término de búsqueda al modelo
        return "index"; // Nombre de la vista donde se mostrarán los resultados
    }
}
