package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SalarioPorSemanaTest {
  static SalarioPorSemana salario;

  @BeforeAll
  static void setUp() {
    salario = new SalarioPorSemana(80.0);
  }

  @AfterAll
  static void tearDown() {
    salario = null;
  }

  @Test
  void getSalario() {
    assertEquals(80.0, salario.getSalario().getDecimal());
  }

  @Test
  void getSalarioImpuesto() {
    assertNotEquals(null, salario.getSalarioImpuesto());
  }
}
