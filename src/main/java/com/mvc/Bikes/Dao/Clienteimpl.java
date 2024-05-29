package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clienteimpl implements ICliente {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Clienteimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Cliente> Listar() {
        String SQL = "SELECT * FROM Cliente WHERE bestado = 1";
        return jdbcTemplate.query(SQL, new ClienteRowMapper());
    }

    @Override
    public Cliente ListarPorId(long id) {
        String SQL = "SELECT nID, bEstado, cNombre, cApellido FROM Cliente WHERE bestado = 1 AND nID = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ClienteRowMapper());
    }

    @Override
    public int Crear(Cliente objeto) {
        String SQL = "INSERT INTO Cliente (cNombre, cApellido) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getApellido());
    }

    @Override
    public int Modificar(Cliente objeto) {
        String SQL = "UPDATE Cliente SET cNombre = ?, cApellido = ? WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getApellido(), objeto.getId());
    }

    @Override
    public int Eliminar(long id) {
        String SQL = "UPDATE Cliente SET bEstado = 0 WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, id);
    }

    private static class ClienteRowMapper implements RowMapper<Cliente> {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cliente(
                    rs.getLong("ID"),
                    rs.getBoolean("Estado"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido")
            );
        }
    }
}