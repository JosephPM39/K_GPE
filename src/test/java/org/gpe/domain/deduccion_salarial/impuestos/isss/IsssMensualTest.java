package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.*;

class IsssMensualTest {

  static IsssMensual isss;

  @BeforeAll
  static void setUp() {
    isss = new IsssMensual();
  }

  @AfterAll
  static void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(1200.00));
    assertEquals(30.00, deduccion.getEmpleado().getDecimal());
    assertEquals(90.00, deduccion.getPatronal().getDecimal());
    assertEquals(1170.00, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionIsss deduccion = isss.calcularDeduccion(new Dinero(700.00));
    assertEquals(21.00, deduccion.getEmpleado().getDecimal());
    assertEquals(52.50, deduccion.getPatronal().getDecimal());
    assertEquals(679.00, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoMensual() {
    assertEquals(1000.00, isss.getSalarioMaximoMensual().getDecimal());
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
