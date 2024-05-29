package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Informacion;

import java.util.List;

public interface IInformacion {
    List<Informacion> Listar();
    Informacion ListarPorId(long id);
    int Crear(Informacion objeto);
    int Modificar(Informacion objeto);
    int Eliminar(long id);
}

