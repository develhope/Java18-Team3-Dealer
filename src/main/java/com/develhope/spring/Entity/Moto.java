package com.develhope.spring.Entity;

import com.develhope.spring.StatoVeicolo;

import java.util.List;

public class Moto extends Veicolo {
    public Moto (Long id, String marca, String modello, int cilindrata, int potenza, String tipoCambio, int annoImmatricolazione,
                 String alimentazione, Double prezzo, Double sconto, List<String> accessori, Boolean nuovoOUsato, StatoVeicolo statoVeicolo) {
        super(id,marca,modello,cilindrata,potenza,tipoCambio,annoImmatricolazione,alimentazione,prezzo,sconto,accessori,nuovoOUsato,statoVeicolo);
    }

}
