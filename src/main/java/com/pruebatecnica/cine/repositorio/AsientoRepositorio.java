package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsientoRepositorio  extends JpaRepository <Asiento, Long>{
    
}
