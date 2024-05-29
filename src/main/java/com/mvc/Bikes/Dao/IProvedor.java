package com.mvc.Bikes.Dao;


import com.mvc.Bikes.Model.Provedor;

import java.util.List;

public interface IProvedor {

    List<Provedor> Listar();
    Provedor ListarPorId(long id);
    int Crear(Provedor objeto);
    int Modificar(Provedor objeto);
    int Eliminar(long id);
}

