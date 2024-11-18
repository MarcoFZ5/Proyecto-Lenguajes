
package com.autodream.services.impl;

import com.autodream.dao.UsuarioDao;
import com.autodream.domain.Rol;
import com.autodream.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.autodream.services.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsServcie")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //Se busca el registro en la tabla usario que tenga el username pasado por parametro
        Usuario usuario = usuarioDao.findByUsername(username);

        //Se valida se el usuario se encontro
        if (usuario == null) {
            //No se encontro el usuario
            throw new UsernameNotFoundException(username);
        }

        //Si estamos aca se encontro el usuario
        //Debemos cargar la foto de imagen
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());

        //Se deben crear los roles que viene desde la tabnla rol...
        var roles = new ArrayList<GrantedAuthority>();

        //Se recorre los roles del usuario y se pasan al arreglo.. ya como rol de
        for (Rol r : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }

        //Se retorna un usuario del sistema con username, password y roles..
        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }

}
