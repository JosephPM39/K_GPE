package org.gpe.domain.deduccion_salarial.impuestos.renta;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentaMensualTest {

  RentaMensual renta;

  @BeforeEach
  void setUp() {
    renta = new RentaMensual();
  }

  @AfterEach
  void tearDown() {
    renta = null;
  }

  @Test
  void calcularDeduccionPrimerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(323.21));
    assertEquals("Tramo 1", deduccion.getTramo().getNombre());
    assertEquals(0.00, deduccion.getRetencion().getDecimal());
    assertEquals(323.21, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSegundoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(654.63));
    assertEquals("Tramo 2", deduccion.getTramo().getNombre());
    assertEquals(35.93, deduccion.getRetencion().getDecimal());
    assertEquals(618.70, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionTercerTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(1526.32));
    assertEquals("Tramo 3", deduccion.getTramo().getNombre());
    assertEquals(186.22, deduccion.getRetencion().getDecimal());
    assertEquals(1340.10, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionCuartoTramo() {
    DeduccionRenta deduccion = renta.calcularDeduccion(new Dinero(5152.12));
    assertEquals("Tramo 4", deduccion.getTramo().getNombre());
    assertEquals(1222.78, deduccion.getRetencion().getDecimal());
    assertEquals(3929.34, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getTramosMensual() {
    assertEquals("Tramo 1", renta.getTramosMensual().get(0).getNombre());
  }
}
