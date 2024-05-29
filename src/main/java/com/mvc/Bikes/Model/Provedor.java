package com.mvc.Bikes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provedor {
    private long id;
    private String Nombre ;
    private boolean Estado;
    private String Descripcion;


    public Provedor(long nID, boolean bEstado, String cNombre) {
    }
}
