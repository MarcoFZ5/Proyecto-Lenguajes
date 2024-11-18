package com.autodream.controller;

import com.autodream.services.AutoService;
import com.autodream.services.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/nosotros")
public class NosotrosController {

    @GetMapping("/pagina")
    public String listado(Model model) {
        
        return "/nosotros/pagina";
    }
}
