package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Moto;

import java.util.List;

public interface IMoto {

  List<Moto> Listar();
    Moto ListarPorId(long id);
    int Crear(Moto objeto);
    int Modificar(Moto objeto);
    int Eliminar(long id);
}
