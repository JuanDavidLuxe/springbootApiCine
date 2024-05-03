
package com.pruebatecnica.cine.controlador;

import com.pruebatecnica.cine.modelo.Asiento;
import com.pruebatecnica.cine.modelo.Cliente;
import com.pruebatecnica.cine.modelo.HorarioProyeccion;
import com.pruebatecnica.cine.modelo.Pelicula;
import com.pruebatecnica.cine.modelo.Reservaciones;
import com.pruebatecnica.cine.repositorio.AsientoRepositorio;
import com.pruebatecnica.cine.repositorio.ClienteRepositorio;
import com.pruebatecnica.cine.repositorio.HorarioProyeccionRepositorio;
import com.pruebatecnica.cine.repositorio.PeliculaRepositorio;
import com.pruebatecnica.cine.repositorio.ReservacionesRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {
    
    // ESTA CLASE SE CREA CON EL OBJETIVO DE MOSTRARLE AL CLIENTE LA INFORMACION VITAL PARA LA RESERVACION.
    // COMO LA PELICULA Y SU INFORMACION
    // LAS PROYECCIONES DISPONIBLES DE ESA PELICULA
    // LAS RESERVACIONES QUE ESTAN DISPONIBLES
    // AGENDAR UNA RESERVACION
    // Y SI QUIERE MODIFICAR O NO LA RESERVACION, COMO CANCELARLA O CAMBIAR DE FECHA
    
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Autowired
    private HorarioProyeccionRepositorio horarioProyeccionRepositorio;
    @Autowired
    private ReservacionesRepositorio reservacionesRepositorio;
    @Autowired
    private AsientoRepositorio asientoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    
    @GetMapping("/test")
    public String test() {
        return "<h1>Server ok Permiso:Cliente</h1>";
    }
    
    
    // PELICULAS -----------------------------------------------------------------------
    
    //PELICULAS --> LECTURA [SOLO ADMIN]
    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas(){
        return peliculaRepositorio.findAll();
    }
    
    // ASIENTOS -------------------------------------------------------------------------
    @GetMapping("/asientos")
    public List<Asiento> obtenerAsientos() {
        return asientoRepositorio.findAll();
    }
    
    // CLIENTES --------------------------------------------------------------------------
    
    @PostMapping("/crearcliente")
    public String crearCliente(@RequestBody Cliente cliente) {
        clienteRepositorio.save(cliente);
        return "Cliente guardado";
    }
    
    // HORARIO PROYECCION -----------------------------------------------------------------
    @GetMapping("/proyeccion")
    public List<HorarioProyeccion> obtenerProyeccion() {
        return horarioProyeccionRepositorio.findAll();
    }
    
    // RESERVACIONES ----------------------------------------------------------------------
    @GetMapping("/reservaciones")
    public List<Reservaciones> obtenerReservaciones() {
        return reservacionesRepositorio.findAll();
    }
    
    @PostMapping("/crearreservacion")
    public String crearReservacion(@RequestBody Reservaciones reservaciones) {
        reservacionesRepositorio.save(reservaciones);
        return "<h1>Reservacion Exitosa</h1>";
    }
   
}
