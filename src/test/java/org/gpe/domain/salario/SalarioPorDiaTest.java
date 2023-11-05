package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class SalarioPorDiaTest {

  static SalarioPorDia salario;

  @BeforeAll
  static void setUp() {
    salario = new SalarioPorDia(12.50, 7);
  }

  @AfterAll
  static void tearDown() {
    salario = null;
  }

  @Test
  void getTarifa() {
    assertEquals(12.50, salario.getTarifa());
  }

  @Test
  void getUnidades() {
    assertEquals(7, salario.getUnidades());
  }

  @Test
  void getSalario() {
    assertEquals(87.50, salario.getSalario());
  }
}
