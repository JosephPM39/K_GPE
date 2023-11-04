package org.gpe.domain.deduccion_salarial.impuestos.renta;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RentaQuincenalTest {

    RentaQuincenal renta;

    @BeforeEach
    void setUp() {
        renta = new RentaQuincenal();
      }

    @AfterEach
    void tearDown() {
        renta = null;
      }

    @Test
    void calcularDeduccionPrimerTramo() {
        DeduccionRenta deduccion = renta.calcularDeduccion(161.61);
        assertEquals("Tramo 1", deduccion.getTramo().getNombre());
        assertEquals(0.00, deduccion.getRetencion());
        assertEquals(161.61, deduccion.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionSegundoTramo() {
        DeduccionRenta deduccion = renta.calcularDeduccion(327.32);
        assertEquals("Tramo 2", deduccion.getTramo().getNombre());
        assertEquals(17.96, deduccion.getRetencion());
        assertEquals(309.35, deduccion.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionTercerTramo() {
        DeduccionRenta deduccion = renta.calcularDeduccion(763.16);
        assertEquals("Tramo 3", deduccion.getTramo().getNombre());
        assertEquals(93.11, deduccion.getRetencion());
        assertEquals(670.05, deduccion.getSalarioLiquido());
    }

    @Test
    void calcularDeduccionCuartoTramo() {
        DeduccionRenta deduccion = renta.calcularDeduccion(2576.06);
        assertEquals("Tramo 4", deduccion.getTramo().getNombre());
        assertEquals(611.38, deduccion.getRetencion());
        assertEquals(1964.68, deduccion.getSalarioLiquido());
    }

}