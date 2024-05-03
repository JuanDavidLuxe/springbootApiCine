package com.pruebatecnica.cine.controlador;

import com.pruebatecnica.cine.modelo.Asiento;
import com.pruebatecnica.cine.modelo.Cliente;
import com.pruebatecnica.cine.modelo.HorarioProyeccion;
import com.pruebatecnica.cine.modelo.Pelicula;
import com.pruebatecnica.cine.modelo.Reservaciones;
import com.pruebatecnica.cine.modelo.Sala;
import com.pruebatecnica.cine.repositorio.AsientoRepositorio;
import com.pruebatecnica.cine.repositorio.ClienteRepositorio;
import com.pruebatecnica.cine.repositorio.HorarioProyeccionRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pruebatecnica.cine.repositorio.PeliculaRepositorio;
import com.pruebatecnica.cine.repositorio.ReservacionesRepositorio;
import com.pruebatecnica.cine.repositorio.SalaRepositorio;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/admin")
public class AdminControlador {
    
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
    @Autowired
    private SalaRepositorio salaRepositorio;
    @Autowired
    private AsientoRepositorio asientoRepositorio;
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private HorarioProyeccionRepositorio horarioProyeccionRepositorio;
    @Autowired
    private ReservacionesRepositorio reservacionesRepositorio;
    
    @GetMapping("/test")
    public String test() {
        return "<h1>Server ok Permiso:Admin</h1>";
    }
    
    // PELICULAS -----------------------------------------------------------------------
    
    //PELICULAS --> LECTURA [SOLO ADMIN]
    @GetMapping("/peliculas")
    public List<Pelicula> obtenerPeliculas(){
        System.out.println("EL VALOR DE PELICULAS ES: " + peliculaRepositorio.findAll());
        return peliculaRepositorio.findAll();
    }
    
    //PELICULAS --> ESCRIBIR(CREAR) [SOLO ADMIN]
    @PostMapping(value="/crearpelicula")
    public String crearPelicula(@RequestBody Pelicula pelicula) {
        peliculaRepositorio.save(pelicula);
        return "Pelicula guardada";
        
    }
    
    // SALAS ---------------------------------------------------------------------------
    
    //SALAS --> LECTURA [SOLO ADMIN]
    @GetMapping("/salas")
    public List<Sala> obtenerSalas() {
        return salaRepositorio.findAll();
    }
    
    //SALAS --> ESCRIBIR(CREAR) [SOLO ADMIN]
    @PostMapping("/crearsala")
    public String crearSala(@RequestBody Sala sala){
        salaRepositorio.save(sala);
        return "Sala guardada";
    }
    
    
    // ASIENTOS -------------------------------------------------------------------------
    @GetMapping("/asientos")
    public List<Asiento> obtenerAsientos() {
        return asientoRepositorio.findAll();
    }
    
    @PostMapping("/crearasiento")
    public String crearAsiento(@RequestBody Asiento asiento) {
        asientoRepositorio.save(asiento);
        return "Asiento Guardado";
    }
    
    
    
    // CLIENTES --------------------------------------------------------------------------
    @GetMapping("/clientes")
    public List<Cliente> obtenerCliente() {
        return clienteRepositorio.findAll();
    }
    
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
    
    @PostMapping("/crearproyeccion")
    public String crearProyeccion(@RequestBody HorarioProyeccion horarioProyeccion) {
        horarioProyeccionRepositorio.save(horarioProyeccion);
        return "Horario de proyección de la pelicula guardado";
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
    
    @PutMapping(value="/actualizar/{id}")
    public String actualizarReservacion(@PathVariable long id, @RequestBody Reservaciones reservaciones){
        Reservaciones actualizarReservacion = reservacionesRepositorio.findById(id).get();
        actualizarReservacion.setEstado("Cancelado");
        reservacionesRepositorio.save(actualizarReservacion);
        return "Reservacion cancelada";
    }
    
    @GetMapping("/reservaciones/cliente/{clienteId}")
    public List<Reservaciones> obtenerReservacionesPorCliente(@PathVariable Long clienteId){
        return reservacionesRepositorio.findByClienteId(clienteId);
    }
}
