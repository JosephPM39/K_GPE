package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
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
    isss.calcularDeduccion(new Dinero(1200.00));
    assertEquals(30.00, isss.getIsssEmpleado().getDecimal());
    assertEquals(90.00, isss.getIsssPatronal().getDecimal());
    assertEquals(1170.00, isss.getSalarioLiquido().getDecimal());
    assertEquals(1000.00, isss.getSalarioMaximo().getDecimal());
  }

  @Test
  void getIsssPorcentajeEmpleado() {
    assertEquals(0.03, isss.getIsssPorcentajeEmpleado().getPorcentaje());
  }

  @Test
  void getIsssPorcentajePatronal() {
    assertEquals(0.075, isss.getIsssPorcentajePatronal().getPorcentaje());
  }
}
