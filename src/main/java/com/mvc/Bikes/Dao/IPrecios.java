package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Precios;

import java.util.List;

public interface IPrecios {

    List<Precios> Listar();
    Precios ListarPorId(long id);
    int Crear(Precios objeto);
    int Modificar(Precios objeto);
    int Eliminar(long id);
}
