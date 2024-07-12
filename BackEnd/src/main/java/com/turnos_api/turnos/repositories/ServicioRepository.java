package com.turnos_api.turnos.repositories;

import com.turnos_api.turnos.entities.Servicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends CrudRepository<Servicio, Long> {
}
