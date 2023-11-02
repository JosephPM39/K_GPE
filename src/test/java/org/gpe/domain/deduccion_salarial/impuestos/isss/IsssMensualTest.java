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
    assertEquals(isss.getIsssEmpleado(), 30.00);
    assertEquals(isss.getIsssPatronal(), 90.00);
    assertEquals(isss.getSalarioLiquido(), 1170.00);
    assertEquals(isss.getSalarioMaximo(), 1000.00);
  }

  @Test
  void getIsssPorcentajeEmpleado() {
    assertEquals(isss.getIsssPorcentajeEmpleado(), 0.03);
  }

  @Test
  void getIsssPorcentajePatronal() {
    assertEquals(isss.getIsssPorcentajePatronal(), 0.075);
  }
}
