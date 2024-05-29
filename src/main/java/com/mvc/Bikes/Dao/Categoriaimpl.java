package com.mvc.Bikes.Dao;

import com.mvc.Bikes.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*utiliza para marcar una clase como un componente de repositorio,
 ayuda al menejo de la base de datos */
@Repository
public class Categoriaimpl implements ICategoria {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Categoriaimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Categoria> Listar() {
        String SQL = "SELECT * FROM Categoria WHERE bestado = 1";
        return jdbcTemplate.query(SQL, new CategoriaRowMapper());
    }

    @Override
    public Categoria ListarPorId(long id) {
        String SQL = "SELECT nID, bEstado, cNombre FROM Categoria WHERE bestado = 1 AND nID = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new CategoriaRowMapper());
    }

    @Override
    public int Crear(Categoria objeto) {
        String SQL = "INSERT INTO Categoria (cNombre) VALUES (?)";
        return jdbcTemplate.update(SQL, objeto.getNombre());
    }

    @Override
    public int Modificar(Categoria objeto) {
        String SQL = "UPDATE Categoria SET cNombre = ? WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, objeto.getNombre(), objeto.getNID());
    }

    @Override
    public int Eliminar(long id) {
        String SQL = "UPDATE Categoria SET bEstado = 0 WHERE nID = ? AND bestado = 1";
        return jdbcTemplate.update(SQL, id);
    }

    private static class CategoriaRowMapper implements RowMapper<Categoria> {
        @Override
        public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Categoria(
                    rs.getLong("nID"),
                    rs.getBoolean("Estado"),
                    rs.getString("Nombre")
            );
        }
    }
}