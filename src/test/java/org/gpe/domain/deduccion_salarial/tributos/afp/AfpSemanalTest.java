package org.gpe.domain.deduccion_salarial.tributos.afp;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfpSemanalTest {

  AfpSemanal afp;

  @BeforeEach
  void setUp() {
    afp = new AfpSemanal();
  }

  @AfterEach
  void tearDown() {
    afp = null;
  }

  @Test
  void calcularDeduccionBajoLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(163.33));
    assertEquals(12.66, deduccion.getPatronal().getDecimal());
    assertEquals(11.84, deduccion.getEmpleado().getDecimal());
    assertEquals(151.49, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSobreLimite() {
    DeduccionAfp deduccion = afp.calcularDeduccion(new Dinero(280.00));
    assertEquals(21.70, deduccion.getPatronal().getDecimal());
    assertEquals(20.30, deduccion.getEmpleado().getDecimal());
    assertEquals(259.70, deduccion.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoSemanal() {
    assertEquals(1639.93, afp.getSalarioMaximoSemanal().getDecimal());
  }
}
