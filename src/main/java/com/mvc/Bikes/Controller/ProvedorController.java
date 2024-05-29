package com.mvc.Bikes.Controller;

import com.mvc.Bikes.Model.Provedor;
import com.mvc.Bikes.Services.ServicesProvedorimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/provedores")
public class ProvedorController {

    private final ServicesProvedorimpl servicesProvedorimpl;

    @Autowired
    public ProvedorController(ServicesProvedorimpl servicesProvedorimpl) {
        this.servicesProvedorimpl = servicesProvedorimpl;
    }

    @GetMapping
    public List<Provedor> Listar() {
        return servicesProvedorimpl.Listar();
    }

    @GetMapping("/{id}")
    public Provedor ListarPorId(@PathVariable long id) {
        return servicesProvedorimpl.ListarPorId(id);
    }

    @PostMapping
    public int Crear(@RequestBody Provedor provedor) {
        return servicesProvedorimpl.Crear(provedor);
    }

    @PutMapping("/{id}")
    public int Modificar(@PathVariable long id, @RequestBody Provedor provedor) {
        provedor.setId(id);
        return servicesProvedorimpl.Modificar(provedor);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable long id) {
        return servicesProvedorimpl.Eliminar(id);
    }
}