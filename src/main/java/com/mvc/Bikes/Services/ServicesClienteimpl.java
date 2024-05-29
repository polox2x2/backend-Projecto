package com.mvc.Bikes.Services;

import com.mvc.Bikes.Dao.ICliente;
import com.mvc.Bikes.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicesClienteimpl  {
    @Autowired
    private ICliente repositoryUsuario;



    public List<Cliente> Listar() {
        return repositoryUsuario.Listar();


    }


    public Cliente ListarPorId(long id) {
        return repositoryUsuario.ListarPorId(id);
    }


    public int Crear(Cliente cliente) {
        return repositoryUsuario.Crear(cliente);
    }


    public int Modificar(Cliente cliente) {
        return repositoryUsuario.Modificar(cliente);
    }


    public int Eliminar(long id) {
        return repositoryUsuario.Eliminar(id);
    }
}
