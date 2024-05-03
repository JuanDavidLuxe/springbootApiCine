package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Reservaciones;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionesRepositorio extends JpaRepository <Reservaciones, Long>{
    List<Reservaciones> findByClienteId(Long clienteId);
}
