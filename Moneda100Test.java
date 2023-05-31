package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Moneda100Test {
    @Test
    void getValorTest() {
        Moneda100 moneda100= new Moneda100();
        assertEquals(100,moneda100.getValor());
    }


}