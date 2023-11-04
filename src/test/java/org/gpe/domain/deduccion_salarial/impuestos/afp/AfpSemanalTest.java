package org.gpe.domain.deduccion_salarial.impuestos.afp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AfpSemanalTest {

    AfpSemanal afp;

    @BeforeEach
    void setUp() {
    afp = new AfpSemanal();
    }

    @AfterEach
    void tearDown() {
        afp = null;
    }

    @Test
    void calcularDeduccionBajoLimite() {
        afp.calcularDeduccion(163.33);
        assertEquals(12.66, afp.getAfpPatronal());
        assertEquals(11.84, afp.getAfpEmpleado());
        assertEquals(151.49, afp.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionSobreLimite() {
        afp.calcularDeduccion(280.00);
        assertEquals(21.70, afp.getAfpPatronal());
        assertEquals(20.30, afp.getAfpEmpleado());
        assertEquals(259.70, afp.getSalarioLiquido());
    }

    @Test
    void getSalarioMaximoMensual() {
        assertEquals(1639.93, afp.getSalarioMaximoSemanal());
    }

}