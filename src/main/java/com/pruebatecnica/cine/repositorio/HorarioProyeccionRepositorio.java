package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Cliente;
import com.pruebatecnica.cine.modelo.HorarioProyeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioProyeccionRepositorio extends JpaRepository <HorarioProyeccion, Long> {
    
}
