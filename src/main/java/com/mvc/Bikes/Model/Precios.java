package com.mvc.Bikes.Model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Precios {
    @NotNull
    @NotBlank
    private long ID;
    @NotNull
    @NotBlank
    private boolean Estado;
    @NotNull
    @DecimalMin(value = "0.1")
    private float Monto;
    private Date dtFechaRegistro;

    private Date dtFechaEliminacion;


    public Precios(long nID, boolean bEstado, double nPrecio) {
    }
}
