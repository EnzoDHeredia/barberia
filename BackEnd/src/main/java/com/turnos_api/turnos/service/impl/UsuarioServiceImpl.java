package com.turnos_api.turnos.service.impl;

import com.turnos_api.turnos.entities.Usuario;
import com.turnos_api.turnos.persistence.IUsuarioDAO;
import com.turnos_api.turnos.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public List<Usuario> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioDAO.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioDAO.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return usuarioDAO.existsById(id);  // Implementación del método
    }
}
