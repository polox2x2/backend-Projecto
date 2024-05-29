package com.mvc.Bikes.Services;

import com.mvc.Bikes.Dao.ICategoria;
import com.mvc.Bikes.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesCategoriaimpl  {



    @Autowired
    private ICategoria categoria;

    public List<Categoria> Listar() {
        return categoria.Listar();
    }


    public Categoria ListarPorId(long id) {
        return categoria.ListarPorId(id);
    }


    public int Modificar(Categoria categorias) {
        return categoria.Modificar(categorias);
    }


    public int Eliminar(long id) {
        return categoria.Eliminar(id);
    }


}
