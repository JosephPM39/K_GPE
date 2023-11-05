package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.utils.Dinero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsssQuincenalTest {

  IsssQuincenal isss;

  @BeforeEach
  void setUp() {
    isss = new IsssQuincenal();
  }

  @AfterEach
  void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccion() {
    isss.calcularDeduccion(new Dinero(600.00));
    assertEquals(585.00, isss.getSalarioLiquido().getDecimal());
  }

  @Test
  void getSalarioMaximoQuincenal() {
    assertEquals(500.00, isss.getSalarioMaximoQuincenal().getDecimal());
  }
}
