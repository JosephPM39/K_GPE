package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class IsssMensualTest {

  static Isss isss;

  @BeforeAll
  static void setUp() {
    isss = new IsssMensual();
  }

  @AfterAll
  static void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccion() {
    isss.calcularDeduccion(1200.00);
    assertEquals(30.00, isss.getIsssEmpleado());
    assertEquals(90.00, isss.getIsssPatronal());
    assertEquals(1170.00, isss.getSalarioLiquido());
    assertEquals(1000.00, isss.getSalarioMaximo());
  }

  @Test
  void getIsssPorcentajeEmpleado() {
    assertEquals(0.03, isss.getIsssPorcentajeEmpleado());
  }

  @Test
  void getIsssPorcentajePatronal() {
    assertEquals(0.075, isss.getIsssPorcentajePatronal());
  }
}
