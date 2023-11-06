package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SalarioQuincenalTest {
  static SalarioQuincenal salario;

  @BeforeAll
  static void setUp() {
    salario = new SalarioQuincenal(200.0);
  }

  @AfterAll
  static void tearDown() {
    salario = null;
  }

  @Test
  void getSalario() {
    assertEquals(200.00, salario.getSalario().getDecimal());
  }

  @Test
  void getTributo() {
    assertNotEquals(null, salario.getTributo());
  }
}
