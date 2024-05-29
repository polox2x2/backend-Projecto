package com.mvc.Bikes.Services;


import com.mvc.Bikes.Dao.IPrecios;
import com.mvc.Bikes.Model.Precios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesPreciosimpl{


    @Autowired
    private IPrecios repositoryPrecios;



    public int Crear(Precios precios) {
        return repositoryPrecios .Crear(precios);
    }


    public List<Precios> Listar() {
        return repositoryPrecios.Listar();
    }


    public Precios ListarPorId(long id) {
        return repositoryPrecios.ListarPorId(id);    }


    public int Modificar(Precios precios) {
        return repositoryPrecios.Modificar(precios);
    }

    public int Eliminar(long id) {
        return repositoryPrecios.Eliminar(id);
    }
}
