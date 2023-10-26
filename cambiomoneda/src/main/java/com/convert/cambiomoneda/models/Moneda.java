package com.convert.cambiomoneda.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmoneda;
    @Column(nullable = false)
    private String monedaOrigen;
    @Column(nullable = false)
    private String monedaDestino;
    @Column(nullable = false)
    private double tipoCambio;
}
