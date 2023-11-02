package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsssHoraTest {

  IsssHora isss;

  @BeforeEach
  void setUp() {
    isss = new IsssHora();
  }

  @AfterEach
  void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccion() {
    isss.calcularDeduccion(2.50);
    assertEquals(2.42, isss.getSalarioLiquido());
  }

  @Test
  void getSalarioMaximoHora() {
    assertEquals(4.17, isss.getSalarioMaximoHora());
  }
}
