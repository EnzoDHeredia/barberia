package com.turnos_api.turnos.controller;

import com.turnos_api.turnos.controller.dto.UsuarioDTO;
import com.turnos_api.turnos.entities.Usuario;
import com.turnos_api.turnos.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();

        // Convertir lista de Usuario a lista de UsuarioDTO usando ModelMapper
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosDTO);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);

        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
