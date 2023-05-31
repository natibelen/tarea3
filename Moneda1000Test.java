package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Moneda1000Test {

    @Test
    void getValor() {
        Moneda1000 moneda1000= new Moneda1000();
        assertEquals(1000,moneda1000.getValor());
    }
}