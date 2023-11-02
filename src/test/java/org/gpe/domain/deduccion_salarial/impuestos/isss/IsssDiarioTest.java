package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class IsssDiarioTest {

  static IsssDiario isss;

  @BeforeAll
  static void setUp() {
    isss = new IsssDiario();
  }

  @AfterAll
  static void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccion() {
    isss.calcularDeduccion(30.0);
    assertEquals(29.10, isss.getSalarioLiquido());
    assertEquals(2.25, isss.getIsssPatronal());
    assertEquals(0.90, isss.getIsssEmpleado());
  }

  @Test
  void getSalarioMaximoDiario() {
    assertEquals(33.33, isss.getSalarioMaximoDiario());
  }
}
