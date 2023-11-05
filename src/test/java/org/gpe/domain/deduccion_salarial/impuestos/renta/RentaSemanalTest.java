package org.gpe.domain.deduccion_salarial.impuestos.renta;

import static org.junit.jupiter.api.Assertions.*;

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
    DeduccionRenta deduccion = renta.calcularDeduccion(75.42);
    assertEquals("Tramo 1", deduccion.getTramo().getNombre());
    assertEquals(0.00, deduccion.getRetencion());
    assertEquals(75.42, deduccion.getSalarioLiquido());
  }

  @Test
  void calcularDeduccionSegundoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(152.75);
    assertEquals("Tramo 2", deduccion.getTramo().getNombre());
    assertEquals(7.89, deduccion.getRetencion());
    assertEquals(144.85, deduccion.getSalarioLiquido());
  }

  @Test
  void calcularDeduccionTercerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(356.14);
    assertEquals("Tramo 3", deduccion.getTramo().getNombre());
    assertEquals(41.47, deduccion.getRetencion());
    assertEquals(314.68, deduccion.getSalarioLiquido());
  }

  @Test
  void calcularDeduccionCuartoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(1202.16);
    assertEquals("Tramo 4", deduccion.getTramo().getNombre());
    assertEquals(279.93, deduccion.getRetencion());
    assertEquals(922.23, deduccion.getSalarioLiquido());
  }
}
