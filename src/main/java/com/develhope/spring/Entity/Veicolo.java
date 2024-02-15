package com.develhope.spring.Entity;

import com.develhope.spring.StatoVeicolo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public abstract class Veicolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modello;
    @Column(nullable = false)
    private int cilindrata;
    @Column(nullable = false)
    private int potenza;
    @Column(nullable = false)
    private String tipoCambio;
    @Column(nullable = false)
    private int annoImmatricolazione;
    @Column(nullable = false)
    private String alimentazione;
    @Column(nullable = false)
    private Double prezzo;
    @Column(nullable = false)
    private Double sconto;
    @Column(nullable = false)
    private List<String> accessori;
    @Column(nullable = false)
    private Boolean nuovoOUsato;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatoVeicolo statoVeicolo;

    public Veicolo(Long id, String marca, String modello, int cilindrata, int potenza, String tipoCambio, int annoImmatricolazione,
                  String alimentazione, Double prezzo, Double sconto, List<String> accessori, Boolean nuovoOUsato, StatoVeicolo statoVeicolo) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.potenza = potenza;
        this.tipoCambio = tipoCambio;
        this.annoImmatricolazione = annoImmatricolazione;
        this.alimentazione = alimentazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.accessori = accessori;
        this.nuovoOUsato = nuovoOUsato;
        this.statoVeicolo = statoVeicolo;
    }

    public Veicolo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getPotenza() {
        return potenza;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    public void setAnnoImmatricolazione(int annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Double getSconto() {
        return sconto;
    }

    public void setSconto(Double sconto) {
        this.sconto = sconto;
    }

    public List<String> getAccessori() {
        return accessori;
    }

    public void setAccessori(List<String> accessori) {
        this.accessori = accessori;
    }

    public Boolean getNuovoOUsato() {
        return nuovoOUsato;
    }

    public void setNuovoOUsato(Boolean nuovoOUsato) {
        this.nuovoOUsato = nuovoOUsato;
    }

    public StatoVeicolo getStatoVeicolo() {
        return statoVeicolo;
    }

    public void setStatoVeicolo(StatoVeicolo statoVeicolo) {
        this.statoVeicolo = statoVeicolo;
    }

    @Override
    public String toString() {
        return "Veicoli{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", cilindrata=" + cilindrata +
                ", potenza=" + potenza +
                ", tipoCambio='" + tipoCambio + '\'' +
                ", annoImmatricolazione=" + annoImmatricolazione +
                ", alimentazione='" + alimentazione + '\'' +
                ", prezzo=" + prezzo +
                ", sconto=" + sconto +
                ", accessori=" + accessori +
                ", nuovoOUsato=" + nuovoOUsato +
                ", statoVeicolo=" + statoVeicolo +
                '}';
    }
}
