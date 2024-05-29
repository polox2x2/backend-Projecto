package com.mvc.Bikes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Informacion {
    private long nID;
    private boolean bEstado;
    private String cDescripcion;
}
