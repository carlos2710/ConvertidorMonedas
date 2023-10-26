package com.convert.cambiomoneda.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonedaResponse {
    private double Monto;
    private double MontoTC;
    private String monedaO;
    private String monedaD;
    private double TC;
}
