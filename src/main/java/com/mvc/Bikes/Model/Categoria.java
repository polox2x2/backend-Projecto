package com.mvc.Bikes.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable {
    @NotNull
    @NotBlank
    private long  nID;
    @NotNull
    @NotBlank
    private  boolean Estado;
    @NotNull
    @NotBlank
    private String Nombre;
    private Date UsuarioRegistro;
    private Date UsuarioEliminacion;
    private Date FechaRegistro;
    private Date FechaEliminacion;


    public Categoria(long nID, boolean estado, String nombre) {
    }
}
