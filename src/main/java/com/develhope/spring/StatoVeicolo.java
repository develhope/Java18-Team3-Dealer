package com.develhope.spring;

public enum StatoVeicolo {
    ORDINABILE,
    ACQUISTABILE,
    NONDISPONIBILE;

    @Override
    public String toString() {
        return "StatoVeicolo{}";
    }
}