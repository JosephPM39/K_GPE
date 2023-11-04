package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AfpMensualTest {

    AfpMensual afp;

    @BeforeEach
    void setUp() {
        afp = new AfpMensual();
      }

    @AfterEach
    void tearDown() {
        afp = null;
      }

    @Test
    void calcularDeduccionBajoLimite() {
        afp.calcularDeduccion(700.00);
        assertEquals(54.25, afp.getAfpPatronal());
        assertEquals(50.75, afp.getAfpEmpleado());
        assertEquals(649.25, afp.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionSobreLimite() {
        afp.calcularDeduccion(1200.00);
        assertEquals(93.00, afp.getAfpPatronal());
        assertEquals(87.00, afp.getAfpEmpleado());
        assertEquals(1113.00, afp.getSalarioLiquido());
    }

    @Test
    void getSalarioMaximoMensual() {
       assertEquals(7028.29,afp.getSalarioMaximoMensual());
    }
}