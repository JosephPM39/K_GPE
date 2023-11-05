package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SalarioPorHoraTest {
  static SalarioPorHora salario;

  @BeforeAll
  static void setUp() {
    salario = new SalarioPorHora(2.50, 36);
  }

  @AfterAll
  static void tearDown() {
    salario = null;
  }

  @Test
  void getTarifa() {
    assertEquals(2.50, salario.getTarifa());
  }

  @Test
  void getUnidades() {
    assertEquals(36, salario.getUnidades());
  }

  @Test
  void getSalario() {
    assertEquals(90.00, salario.getSalario());
  }
}
