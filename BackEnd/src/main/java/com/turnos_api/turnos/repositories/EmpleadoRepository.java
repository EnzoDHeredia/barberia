package com.turnos_api.turnos.repositories;

import com.turnos_api.turnos.entities.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}
