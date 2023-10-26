package com.convert.cambiomoneda.repository;

import com.convert.cambiomoneda.models.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonedaRepository extends JpaRepository<Moneda,Long> {
    Moneda findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
