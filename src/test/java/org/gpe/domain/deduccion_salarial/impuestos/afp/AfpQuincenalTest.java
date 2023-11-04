package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AfpQuincenalTest {

    AfpQuincenal afp;

    @BeforeEach
    void setUp() {
    afp = new AfpQuincenal();
    }

    @AfterEach
    void tearDown() {
        afp = null;
    }

    @Test
    void calcularDeduccionBajoLimite() {
        afp.calcularDeduccion(350.00);
        assertEquals(27.13, afp.getAfpPatronal());
        assertEquals(25.38, afp.getAfpEmpleado());
        assertEquals(324.63, afp.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionSobreLimite() {
        afp.calcularDeduccion(600.00);
        assertEquals(46.50, afp.getAfpPatronal());
        assertEquals(43.50, afp.getAfpEmpleado());
        assertEquals(556.50, afp.getSalarioLiquido());
    }

    @Test
    void getSalarioMaximoMensual() {
        assertEquals(3514.15, afp.getSalarioMaximoQuincenal());
    }

}