package com.convert.cambiomoneda.controller;

import com.convert.cambiomoneda.models.Moneda;
import com.convert.cambiomoneda.services.MonedaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monedas")
@RequiredArgsConstructor
public class MonedaController {

    private final MonedaService serviceMonedas;


    @PostMapping
    public ResponseEntity guardarMoneda(@RequestBody Moneda moneda){
        return new ResponseEntity(serviceMonedas.GuardarMonedas(moneda), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerMoneda(@PathVariable("id") Long idMoneda){
        return new ResponseEntity(serviceMonedas.ObtenerMonedas(idMoneda), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity ListarMonedas(){
        return new ResponseEntity(serviceMonedas.ListadoMonedas(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity ModificarMoneda(@PathVariable("id") Long idMoneda,@RequestBody Moneda Moneda){
        return new ResponseEntity(serviceMonedas.ModificarMonedas(idMoneda,Moneda),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity EliminarMoneda(@PathVariable("id") Long idMoneda){
        boolean repuesta = serviceMonedas.EliminarMonedas(idMoneda);
        if(repuesta==true){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/calcular")
    public ResponseEntity CalcularTC(@RequestBody Moneda moneda){
        return new ResponseEntity(serviceMonedas.MonedaTC(moneda),HttpStatus.OK);
    }
}
