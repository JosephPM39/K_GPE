package org.gpe.domain.deduccion_salarial.impuestos.isss;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
class IsssDiarioTest {

    static IsssDiario isss;

    @BeforeAll
    static void setUp() {
       isss = new IsssDiario();
    }

    @AfterAll
    static void tearDown() {
        isss = null;
    }

    @Test
    void calcularDeduccion() {
        isss.calcularDeduccion(30.0);
        assertEquals(isss.getSalarioLiquido(), 29.10);
        assertEquals(isss.getIsssPatronal(), 2.25);
        assertEquals(isss.getIsssEmpleado(), 0.90);
    }

    @Test
    void getSalarioMaximoDiario() {
        assertEquals(isss.getSalarioMaximoDiario(), 33.33);
    }
}