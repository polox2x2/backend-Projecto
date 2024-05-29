package com.mvc.Bikes.Controller;

import com.mvc.Bikes.Model.Moto;
import com.mvc.Bikes.Services.ServicesMotoimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final ServicesMotoimpl servicesMotoimpl;

    @Autowired
    public MotoController(ServicesMotoimpl servicesMotoimpl) {
        this.servicesMotoimpl = servicesMotoimpl;
    }

    @GetMapping
    public List<Moto> Listar() {
        return servicesMotoimpl.Listar();
    }

    @GetMapping("/{id}")
    public Moto ListarPorId(@PathVariable long id) {
        return servicesMotoimpl.ListarPorId(id);
    }

    @PostMapping
    public int Crear(@RequestBody Moto moto) {
        return servicesMotoimpl.Crear(moto);
    }

    @PutMapping("/{id}")
    public int Modificar(@PathVariable long id, @RequestBody Moto moto) {
        moto.setNID(id);
        return servicesMotoimpl.Modificar(moto);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable long id) {
        return servicesMotoimpl.Eliminar(id);
    }
}
