package org.gpe.domain.deduccion_salarial.impuestos.afp;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfpQuincenalTest {

  AfpQuincenal afp;

  @BeforeEach
  void setUp() {
    afp = new AfpQuincenal();
  }

  @AfterEach
  void tearDown() {
    afp = null;
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(350.00));
    assertEquals(27.13, deduccion.getPatronal().getDecimal());
    assertEquals(25.38, deduccion.getEmpleado().getDecimal());
    assertEquals(324.62, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(600.00));
    assertEquals(46.50, deduccion.getPatronal().getDecimal());
    assertEquals(43.50, deduccion.getEmpleado().getDecimal());
    assertEquals(556.50, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoQuincenal() {
    assertEquals(3514.15, afp.getSalarioMaximoQuincenal().getDecimal());
  }
}
