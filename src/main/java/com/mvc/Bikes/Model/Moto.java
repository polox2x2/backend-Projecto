package com.mvc.Bikes.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*La interfaz Serializable es una interfaz de marcador en Java, lo que significa que no tiene métodos definidos.
 Su único propósito es marcar las clases para indicar que sus objetos pueden ser serializados */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moto implements Serializable{
    @NotNull
    @NotBlank
    private long nID;
    @NotNull
    @NotBlank
    private boolean bEstado;
    @NotNull
    @NotBlank
    private String cNombre;
    @NotNull
    @NotBlank
    private String  cCilindrada;

    private  Date dtFechaRegistro;

    private Date dtFechaEliminacion;


    public Moto(long nID, boolean bEstado, String cDescripcion) {
    }
}
