package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Provedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Provedorimpl implements IProvedor {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Provedorimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Provedor> Listar() {
        String SQL = "SELECT * FROM Provedor WHERE bestado = 1";
        return jdbcTemplate.query(SQL, new ProvedorRowMapper());
    }

    @Override
    public Provedor ListarPorId(long id) {
        String SQL = "SELECT nID, bEstado, cNombre FROM Provedor WHERE bestado = 1 AND nID = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ProvedorRowMapper());
    }

    @Override
    public int Crear(Provedor objeto) {
        String SQL = "INSERT INTO Provedor (cNombre) VALUES (?)";
        return jdbcTemplate.update(SQL, objeto.getNombre());
    }

    @Override
    public int Modificar(Provedor objeto) {
        String SQL = "UPDATE Provedor SET cNombre = ? WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getId());
    }

    @Override
    public int Eliminar(long id) {
        String SQL = "UPDATE Provedor SET bEstado = 0 WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, id);
    }

    private static class ProvedorRowMapper implements RowMapper<Provedor> {
        @Override
        public Provedor mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Provedor(
                    rs.getLong("nID"),
                    rs.getBoolean("bEstado"),
                    rs.getString("cNombre")
            );
        }
    }
}

