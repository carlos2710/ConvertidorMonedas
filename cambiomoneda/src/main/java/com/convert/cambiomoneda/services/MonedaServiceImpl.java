package com.convert.cambiomoneda.services;

import com.convert.cambiomoneda.models.MonedaResponse;
import com.convert.cambiomoneda.models.Moneda;
import com.convert.cambiomoneda.repository.MonedaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MonedaServiceImpl implements MonedaService {

    private final MonedaRepository repositoryMonedas;
    @Override
    public Moneda GuardarMonedas(Moneda moneda) {
        return repositoryMonedas.save(moneda);
    }

    @Override
    public Moneda ObtenerMonedas(Long idMoneda) {
        return repositoryMonedas.findById(idMoneda).orElseThrow(()->{throw new RuntimeException();});
    }

    @Override
    public Moneda ModificarMonedas(Long idMoneda, Moneda moneda) {
        Moneda monedaBuscada = repositoryMonedas.findById(idMoneda).get();
        monedaBuscada.setTipoCambio(moneda.getTipoCambio());
        return repositoryMonedas.save(monedaBuscada);
    }

    @Override
    public boolean EliminarMonedas(Long idMoneda) {
        try{
            repositoryMonedas.deleteById(idMoneda);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Moneda> ListadoMonedas() {
        return repositoryMonedas.findAll();
    }

    @Override
    public MonedaResponse MonedaTC(Moneda moneda) {
        MonedaResponse resp = new MonedaResponse();

        Moneda monedaBusq=repositoryMonedas.findByMonedaOrigenAndMonedaDestino(moneda.getMonedaOrigen(),moneda.getMonedaDestino());
        if(monedaBusq==null){
            resp.setMonto(0);
            resp.setMontoTC(0);
            resp.setMonedaO("No Existe Moneda Origen");
            resp.setMonedaD("No Existe Moneda Destino");
            resp.setTC(0);
        }else {
            resp.setMonto(moneda.getTipoCambio());
            resp.setMontoTC(moneda.getTipoCambio() * monedaBusq.getTipoCambio());
            resp.setMonedaO(moneda.getMonedaOrigen());
            resp.setMonedaD(moneda.getMonedaDestino());
            resp.setTC(monedaBusq.getTipoCambio());
        }

        return resp;
    }
}
