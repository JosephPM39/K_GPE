package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class SalarioMensualTest {

  static SalarioMensual salario;

  @BeforeAll
  static void setUp() {
    salario = new SalarioMensual(400.0);
  }

  @AfterAll
  static void tearDown() {
    salario = null;
  }

  @Test
  void getSalario() {
    assertEquals(400.0, salario.getSalario().getDecimal());
  }

  @Test
  void getSalarioImpuesto() {
    assertNotEquals(null, salario.getSalarioImpuesto());
  }
}
