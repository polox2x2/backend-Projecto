package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Categoria;

import java.util.List;
//conjunto de metodos abstractos para Definir comportamientos .
public interface ICategoria {

    List<Categoria> Listar();
    Categoria ListarPorId(long id);
    int Crear(Categoria objeto);
    int Modificar(Categoria objeto);
    int Eliminar(long id);

}
