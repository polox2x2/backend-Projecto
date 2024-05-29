package com.mvc.Bikes.Services;

import com.mvc.Bikes.Dao.IMoto;
import com.mvc.Bikes.Model.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
estos servicios son utilizados para abstraer y
encapsular las operaciones de la base de datos, permitiendo que el resto de la
aplicación interactúe sin necesidad de conocer los detalles de implementación de acceso a datos.
 */
@Service
public class ServicesMotoimpl  {

//inyecta la dependencia
    @Autowired
    private IMoto repositoryModelo;

    public int Crear(Moto moto) {
        return repositoryModelo.Crear(moto);
    }


    public List<Moto> Listar() {
        return repositoryModelo.Listar();
    }


    public Moto ListarPorId(long id) {
        return repositoryModelo.ListarPorId(id);
    }


    public int Modificar(Moto moto) {
        return repositoryModelo.Modificar(moto);
    }


    public int Eliminar(long id) {
        return repositoryModelo.Eliminar(id);
    }
}
