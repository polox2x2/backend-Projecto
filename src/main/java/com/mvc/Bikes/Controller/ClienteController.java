package com.mvc.Bikes.Controller;

import com.mvc.Bikes.Model.Cliente;
import com.mvc.Bikes.Services.ServicesClienteimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ServicesClienteimpl servicesClienteimpl;

    @Autowired
    public ClienteController(ServicesClienteimpl servicesClienteimpl) {
        this.servicesClienteimpl = servicesClienteimpl;
    }

    @GetMapping
    public List<Cliente> Listar() {
        return servicesClienteimpl.Listar();
    }

    @GetMapping("/{id}")
    public Cliente ListarPorId(@PathVariable long id) {
        return servicesClienteimpl.ListarPorId(id);
    }

    @PostMapping
    public int Crear(@RequestBody Cliente cliente) {
        return servicesClienteimpl.Crear(cliente);
    }

    @PutMapping("/{id}")
    public int Modificar(@PathVariable long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return servicesClienteimpl.Modificar(cliente);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable long id) {
        return servicesClienteimpl.Eliminar(id);
    }
}
