package com.swwager.cliente.repositories.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "No puede estar vacio")
    @Column(nullable = false)
    private String apellido;
    @Email(message="No cumple con el formato de una cuenta de correo")
    @Column(nullable = false,unique = true)
    private String email;   
    @Column(name="create_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date   createAt; 

    
}
