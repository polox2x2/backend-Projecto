package com.mvc.Bikes.Controller;

import com.mvc.Bikes.Model.Categoria;
import com.mvc.Bikes.Services.ServicesCategoriaimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final ServicesCategoriaimpl servicesCategoriaimpl;

    @Autowired
    public CategoriaController(ServicesCategoriaimpl servicesCategoriaimpl) {
        this.servicesCategoriaimpl = servicesCategoriaimpl;
    }

    @GetMapping ("/")
    public List<Categoria> Listar() {
        return servicesCategoriaimpl.Listar();
    }

    @GetMapping("/{id}")
    public Categoria ListarPorId(@PathVariable long id) {
        return servicesCategoriaimpl.ListarPorId(id);
    }

    @PutMapping("/{id}")
    public int Modificar(@PathVariable long id, @RequestBody Categoria categoria) {
        categoria.setNID(id);
        return servicesCategoriaimpl.Modificar(categoria);
    }

    @DeleteMapping("/{id}")
    public int Eliminar(@PathVariable long id) {
        return servicesCategoriaimpl.Eliminar(id);
    }
}