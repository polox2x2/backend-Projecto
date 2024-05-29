package com.mvc.Bikes.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
// metadatos, brinda informacion adicional
    @NotNull
    @NotBlank
    private long id;
    @NotNull
    @NotBlank
    private boolean estado;
    @NotNull
    @NotBlank
    private String nombre;
    @NotNull
    @NotBlank
    private String apellido;
    @NotNull
    @Email
    private String email;


    public Cliente(long id, boolean estado, String nombre, String apellido) {
    }
}
