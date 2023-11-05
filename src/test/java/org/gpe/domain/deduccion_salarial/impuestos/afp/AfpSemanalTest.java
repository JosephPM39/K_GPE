package org.gpe.domain.deduccion_salarial.impuestos.afp;

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
    afp.calcularDeduccion(new Dinero(163.33));
    assertEquals(12.66, afp.getAfpPatronal().getDecimal());
    assertEquals(11.84, afp.getAfpEmpleado().getDecimal());
    assertEquals(151.49, afp.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSobreLimite() {
    afp.calcularDeduccion(new Dinero(280.00));
    assertEquals(21.70, afp.getAfpPatronal().getDecimal());
    assertEquals(20.30, afp.getAfpEmpleado().getDecimal());
    assertEquals(259.70, afp.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoMensual() {
    assertEquals(1639.93, afp.getSalarioMaximoSemanal().getDecimal());
  }
}
