package com.develhope.spring.Veicoli.Entity;

import java.util.List;

public class Furgone extends Veicolo{
    public Furgone (Long id, String marca, String modello, int cilindrata, int potenza, String tipoCambio, int annoImmatricolazione,
                 String alimentazione, Double prezzo, Double sconto, List<String> accessori, Boolean nuovoOUsato, StatoVeicolo statoVeicolo) {
        super(id,marca,modello,cilindrata,potenza,tipoCambio,annoImmatricolazione,alimentazione,prezzo,sconto,accessori,nuovoOUsato,statoVeicolo);
    }
}
