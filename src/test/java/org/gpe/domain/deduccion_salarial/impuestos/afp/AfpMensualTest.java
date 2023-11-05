package org.gpe.domain.deduccion_salarial.impuestos.afp;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfpMensualTest {

  AfpMensual afp;

  @BeforeEach
  void setUp() {
    afp = new AfpMensual();
  }

  @AfterEach
  void tearDown() {
    afp = null;
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(700.00));
    assertEquals(54.25, deduccion.getPatronal().getDecimal());
    assertEquals(50.75, deduccion.getEmpleado().getDecimal());
    assertEquals(649.25, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(1200.00));
    assertEquals(93.00, deduccion.getPatronal().getDecimal());
    assertEquals(87.00, deduccion.getEmpleado().getDecimal());
    assertEquals(1113.00, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoMensual() {
    assertEquals(7028.29, afp.getSalarioMaximoMensual().getDecimal());
  }

  @Test
  void getPorcentajePatronal() {
    assertEquals(7.75, afp.getAfpPorcentajePatronal().getValor());
  }

  @Test
  void getPorcentajeEmpleado() {
    assertEquals(7.25, afp.getAfpPorcentajeEmpleado().getValor());
  }
}
