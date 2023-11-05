package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.*;

class IsssSemanalTest {

  static IsssSemanal isss;

  @BeforeAll
  static void setUp() {
    isss = new IsssSemanal();
  }

  @AfterAll
  static void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(280.00));
    assertEquals(7.00, deduccion.getEmpleado().getDecimal());
    assertEquals(21.00, deduccion.getPatronal().getDecimal());
    assertEquals(273.00, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(163.33));
    assertEquals(4.90, deduccion.getEmpleado().getDecimal());
    assertEquals(12.25, deduccion.getPatronal().getDecimal());
    assertEquals(158.43, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoQuincenal() {
    assertEquals(233.33, isss.getSalarioMaximoSemanal().getDecimal());
  }
}
