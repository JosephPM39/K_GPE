package org.gpe.domain.deduccion_salarial.impuestos.renta;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(161.61));
    assertEquals("Tramo 1", deduccion.getTramo().getNombre());
    assertEquals(0.00, deduccion.getRetencion().getDecimal());
    assertEquals(161.61, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSegundoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(327.32));
    assertEquals("Tramo 2", deduccion.getTramo().getNombre());
    assertEquals(17.96, deduccion.getRetencion().getDecimal());
    assertEquals(309.36, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionTercerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(763.16));
    assertEquals("Tramo 3", deduccion.getTramo().getNombre());
    assertEquals(93.11, deduccion.getRetencion().getDecimal());
    assertEquals(670.05, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionCuartoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(2576.06));
    assertEquals("Tramo 4", deduccion.getTramo().getNombre());
    assertEquals(611.38, deduccion.getRetencion().getDecimal());
    assertEquals(1964.68, deduccion.getSalarioLiquido().getDecimal());
  }
}
