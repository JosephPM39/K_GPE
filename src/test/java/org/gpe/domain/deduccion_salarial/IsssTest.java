package org.gpe.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsssTest {
  Isss isss;

  @BeforeEach
  void setUP() {
    isss = new Isss(400.0);
  }

  @Test
  void testCalculate() {
    assertEquals(12.0, isss.getIsssEmpleado());
  }
}
