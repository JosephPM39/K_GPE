package org.gpe.domain.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class DineroTest {

    static Dinero dinero;

    @BeforeEach
    void setUp() {
        dinero = new Dinero(50.0);
    }

    @AfterEach
    void tearDown() {
        dinero = null;
    }

    @Test
    void sumar() {
        dinero.sumar(new Dinero(7.96));
        assertEquals(57.96, dinero.getMonto().doubleValue());
      }

    @Test
    void restar() {
        dinero.restar(new Dinero(1.84));
        assertEquals(48.16, dinero.getMonto().doubleValue());
    }

    @Test
    void dividir() {
        dinero.dividir(3.24);
        assertEquals(15.43, dinero.getMonto().doubleValue());
    }

    @Test
    void multiplicar() {
        dinero.multiplicar(2.5);
        assertEquals(125.00, dinero.getMonto().doubleValue());
    }
}