
package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Sala;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SalaRepositorio  extends JpaRepository <Sala, Long> {
    
}
