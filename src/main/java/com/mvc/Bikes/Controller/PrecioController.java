package com.mvc.Bikes.Controller;

import com.mvc.Bikes.Model.Precios;
import com.mvc.Bikes.Services.ServicesPreciosimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/precios")
public class PrecioController {

    private final ServicesPreciosimpl servicesPrecioimpl;

    @Autowired
    public PrecioController(ServicesPreciosimpl servicesPreciosimpl) {
        this.servicesPrecioimpl = servicesPreciosimpl;
    }

    @GetMapping
    public List<Precios> Listar() {
        return servicesPrecioimpl.Listar();
    }

    @GetMapping("/{id}")
    public Precios ListarPorId(@PathVariable long id) {
        return servicesPrecioimpl.ListarPorId(id);
    }

    @PostMapping
    public int Crear(@RequestBody Precios precios) {
        return servicesPrecioimpl.Crear(precios);
    }

    @PutMapping("/{id}")
    public int Modificar(@PathVariable long id, @RequestBody Precios precio) {
        precio.setID(id);
        return servicesPrecioimpl.Modificar(precio);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable long id) {
        return servicesPrecioimpl.Eliminar(id);
    }
}