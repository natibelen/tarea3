package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Moneda1500Test {

    @Test
    void getValor() {
        Moneda1500 moneda1500= new Moneda1500();
        assertEquals(1500,moneda1500.getValor());
    }
}