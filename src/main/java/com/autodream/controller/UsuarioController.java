package com.autodream.controller;

import com.autodream.domain.Usuario;
import com.autodream.services.UsuarioService;
import com.autodream.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }

    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario, @RequestParam("imagenFile") MultipartFile imagenFile) {
        // Verificar si el archivo de imagen no está vacío
        if (!imagenFile.isEmpty()) {
            // Subir la imagen y obtener la ruta
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "usuario", usuario.getIdUsuario());
            usuario.setRutaImagen(rutaImagen);
        }

        // Guardar el usuario, preservando el username
        Usuario usuarioExistente = usuarioService.getUsuario(usuario);
        if (usuarioExistente != null) {
            // Preservar el username actual
            usuario.setUsername(usuarioExistente.getUsername());
        }
        usuarioService.save(usuario, true);

        return "redirect:/usuario/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
    
     @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }
}
