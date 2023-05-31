package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Moneda500Test {

    @Test
    void getValor() {
        Moneda500 moneda500= new Moneda500();
        assertEquals(500,moneda500.getValor());
    }
}