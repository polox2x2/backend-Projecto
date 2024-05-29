package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Informacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Informacionimpl implements  IInformacion {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public Informacionimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Informacion> Listar() {
        String SQL = "SELECT * FROM Informacion WHERE bEstado = 1";
        return jdbcTemplate.query(SQL, new Informacionimpl.InformacionimplRowMapper());
    }

    @Override
    public Informacion ListarPorId(long id) {
        String SQL = "";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new Informacionimpl.InformacionimplRowMapper());

    }


    @Override
    public int Crear(Informacion info) {
        String SQL = "INSERT INTO Informacion (bEstado, cDescripcion ) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, info.isBEstado(), info.getCDescripcion());
    }

    @Override
    public int Modificar(Informacion objeto) {
        return 0;
    }

    @Override
    public int Eliminar(long id) {
        return 0;
    }


    private static class InformacionimplRowMapper implements RowMapper<Informacion> {
        @Override
        public Informacion mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Informacion(
                    rs.getLong("nID"),
                    rs.getBoolean("bEstado"),
                    rs.getString("cDescripcion")

            );
        }
    }
}
