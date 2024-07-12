package com.turnos_api.turnos.repositories;

import com.turnos_api.turnos.entities.Turno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends CrudRepository<Turno, Long> {
}
