package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Motoimpl implements IMoto {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Motoimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Moto> Listar() {
        String SQL = "SELECT * FROM Moto WHERE bEstado = 1";
        return jdbcTemplate.query(SQL, new MotoRowMapper());
    }

    @Override
    public Moto ListarPorId(long id) {
        String SQL = "SELECT * FROM Moto WHERE bEstado = 1 AND nID = ? ";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new MotoRowMapper());
    }

    @Override
    public int Crear(Moto moto) {
        String SQL = "INSERT INTO Moto (bEstado, cNombre, cCilindrada, dtFechaRegistro) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, moto.isBEstado(), moto.getCNombre(), moto.getCCilindrada(), moto.getDtFechaRegistro());
    }

    @Override
    public int Modificar(Moto moto) {
        String SQL = "UPDATE Moto SET bEstado = ?, cNombre = ?, cCilindrada = ?, dtFechaRegistro = ?, dtFechaEliminacion = ? WHERE nID = ?";
        return jdbcTemplate.update(SQL, moto.isBEstado(), moto.getCNombre(), moto.getCCilindrada(), moto.getDtFechaRegistro(), moto.getDtFechaEliminacion(), moto.getNID());
    }

    @Override
    public int Eliminar(long id) {
        String SQL = "UPDATE Moto SET bEstado = 0, dtFechaEliminacion = NOW() WHERE nID = ? AND bEstado = 1";
        return jdbcTemplate.update(SQL, id);
    }

    private static class MotoRowMapper implements RowMapper<Moto> {
        @Override
        public Moto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Moto(
                    rs.getLong("nID"),
                    rs.getBoolean("bEstado"),
                    rs.getString("cNombre"),
                    rs.getString("cCilindrada"),
                    rs.getDate("dtFechaRegistro"),
                    rs.getDate("dtFechaEliminacion")
            );
        }
    }
}
