package com.develhope.spring.Ordini;

import User.UserEntity.User;
import com.develhope.spring.Veicoli.Entity.Veicolo;
import jakarta.persistence.*;

@Entity
@Table
public class Ordine {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private double anticipo;
@Column(nullable = false)
private Boolean pagato;
@Column(nullable = false)
private StatoOrdine statoOrdini;
@ManyToOne
private Veicolo veicolo;
@ManyToOne
User user;

}
