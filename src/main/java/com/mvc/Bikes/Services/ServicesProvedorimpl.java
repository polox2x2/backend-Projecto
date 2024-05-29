package com.mvc.Bikes.Services;

import com.mvc.Bikes.Dao.IProvedor;
import com.mvc.Bikes.Model.Provedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProvedorimpl {


    @Autowired
    private IProvedor repositoryProvedor;


    public int Crear(Provedor provedor) {
        return repositoryProvedor.Crear(provedor);
    }

    public List<Provedor> Listar() {
        return repositoryProvedor.Listar();
    }

    public Provedor ListarPorId(long id) {
        return repositoryProvedor.ListarPorId(id);
    }

    public int Modificar(Provedor provedor) {
        return repositoryProvedor.Modificar(provedor);
    }


    public int Eliminar(long id) {
        return repositoryProvedor.Eliminar(id);

    }
}
