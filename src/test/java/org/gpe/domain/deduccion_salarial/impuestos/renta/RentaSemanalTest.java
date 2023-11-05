package org.gpe.domain.deduccion_salarial.impuestos.renta;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentaSemanalTest {
  RentaSemanal renta;

  @BeforeEach
  void setUp() {
    renta = new RentaSemanal();
  }

  @AfterEach
  void tearDown() {
    renta = null;
  }

  @Test
  void calcularDeduccionPrimerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(75.42));
    assertEquals("Tramo 1", deduccion.getTramo().getNombre());
    assertEquals(0.00, deduccion.getRetencion().getDecimal());
    assertEquals(75.42, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSegundoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(152.75));
    assertEquals("Tramo 2", deduccion.getTramo().getNombre());
    assertEquals(7.89, deduccion.getRetencion().getDecimal());
    assertEquals(144.85, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionTercerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(356.14));
    assertEquals("Tramo 3", deduccion.getTramo().getNombre());
    assertEquals(41.47, deduccion.getRetencion().getDecimal());
    assertEquals(314.68, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionCuartoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(1202.16));
    assertEquals("Tramo 4", deduccion.getTramo().getNombre());
    assertEquals(279.93, deduccion.getRetencion().getDecimal());
    assertEquals(922.23, deduccion.getSalarioLiquido().getDecimal());
  }
}
