package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Precios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Preciosimpl implements IPrecios {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Preciosimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Precios> Listar() {
        String SQL = "SELECT * FROM Precio WHERE bestado = 1";
        return jdbcTemplate.query(SQL, new PrecioRowMapper());
    }

    @Override
    public Precios ListarPorId(long id) {
        String SQL = "SELECT nID, bEstado, nPrecio FROM Precio WHERE bestado = 1 AND nID = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PrecioRowMapper());
    }

    @Override
    public int Crear(Precios objeto) {
        String SQL = "INSERT INTO Precio (nPrecio) VALUES (?)";
        return jdbcTemplate.update(SQL, objeto.getMonto());
    }

    @Override
    public int Modificar(Precios objeto) {
        String SQL = "UPDATE Precio SET nPrecio = ? WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, objeto.getMonto(), objeto.getID());
    }

    @Override
    public int Eliminar(long id) {
        String SQL = "UPDATE Precio SET bEstado = 0 WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, id);
    }

    private static class PrecioRowMapper implements RowMapper<Precios> {
        @Override
        public Precios mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Precios(
                    rs.getLong("nID"),
                    rs.getBoolean("bEstado"),
                    rs.getDouble("nPrecio")
            );
        }
    }
}