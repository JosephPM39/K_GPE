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
    afp.calcularDeduccion(new Dinero(700.00));
    assertEquals(54.25, afp.getAfpPatronal().getDecimal());
    assertEquals(50.75, afp.getAfpEmpleado().getDecimal());
    assertEquals(649.25, afp.getSalarioLiquido().getDecimal());
  }

  @Test
  void calcularDeduccionSobreLimite() {
    afp.calcularDeduccion(new Dinero(1200.00));
    assertEquals(93.00, afp.getAfpPatronal().getDecimal());
    assertEquals(87.00, afp.getAfpEmpleado().getDecimal());
    assertEquals(1113.00, afp.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoMensual() {
    assertEquals(7028.29, afp.getSalarioMaximoMensual().getDecimal());
  }
}
