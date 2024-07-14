package com.turnos_api.turnos.service;

import com.turnos_api.turnos.entities.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    void save(Usuario usuario);

    void deleteById(Long id);

    boolean existsById(Long id);
}
