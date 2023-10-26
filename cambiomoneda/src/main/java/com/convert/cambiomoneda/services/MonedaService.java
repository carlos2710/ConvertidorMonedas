package com.convert.cambiomoneda.services;

import com.convert.cambiomoneda.models.MonedaResponse;
import com.convert.cambiomoneda.models.Moneda;

import java.util.List;

public interface MonedaService {
    Moneda GuardarMonedas(Moneda moneda);
    Moneda ObtenerMonedas(Long idMoneda);
    Moneda ModificarMonedas(Long idMoneda, Moneda moneda);
    boolean EliminarMonedas(Long idMoneda);
    List<Moneda> ListadoMonedas();
    MonedaResponse MonedaTC(Moneda Moneda);
}
