package org.gpe.domain.deduccion_salarial.tributos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.*;

class IsssQuincenalTest {

  static IsssQuincenal isss;

  @BeforeAll
  static void setUp() {
    isss = new IsssQuincenal();
  }

  @AfterAll
  static void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(600.00));
    assertEquals(15.00, deduccion.getEmpleado().getDecimal());
    assertEquals(45.00, deduccion.getPatronal().getDecimal());
    assertEquals(585.00, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(350.00));
    assertEquals(10.50, deduccion.getEmpleado().getDecimal());
    assertEquals(26.25, deduccion.getPatronal().getDecimal());
    assertEquals(339.50, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoQuincenal() {
    assertEquals(500.00, isss.getSalarioMaximoQuincenal().getDecimal());
  }
}
