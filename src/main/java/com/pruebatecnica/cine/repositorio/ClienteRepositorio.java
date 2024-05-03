/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pruebatecnica.cine.repositorio;

import com.pruebatecnica.cine.modelo.Asiento;
import com.pruebatecnica.cine.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juand
 */
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {
    
}
