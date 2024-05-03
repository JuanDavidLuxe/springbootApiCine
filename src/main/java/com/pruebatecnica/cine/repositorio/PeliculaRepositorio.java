package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepositorio extends JpaRepository <Pelicula, Long>{
    
}
