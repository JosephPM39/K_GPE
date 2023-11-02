package org.gpe.domain.deduccion_salarial.impuestos.isss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsssSemanalTest {

  IsssSemanal isss = new IsssSemanal();

  @BeforeEach
  void setUp() {
    isss = new IsssSemanal();
  }

  @AfterEach
  void tearDown() {
    isss = null;
  }

  @Test
  void calcularDeduccion() {
    isss.calcularDeduccion(300.00);
    assertEquals(7.0, isss.getIsssEmpleado());
  }

  @Test
  void getSalarioMaximoSemanal() {
    assertEquals(233.33, isss.getSalarioMaximoSemanal());
  }
}
