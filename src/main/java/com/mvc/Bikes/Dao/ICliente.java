package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Cliente;

import java.util.List;

public interface ICliente {

    List<Cliente> Listar();
    Cliente ListarPorId(long id);
    int Crear(Cliente objeto);
    int Modificar(Cliente objeto);
    int Eliminar(long id);


    
}
