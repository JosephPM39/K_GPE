package org.gpe.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class PorcentajeTest {

  static Porcentaje porcentaje;

  @BeforeAll
  static void setUp() {
    porcentaje = new Porcentaje(20);
  }

  @AfterAll
  static void tearDown() {
    porcentaje = null;
  }

  @Test
  void getValor() {
    assertEquals(20, porcentaje.getValorNatural());
  }

  @Test
  void getPorcentaje() {
    assertEquals(0.2, porcentaje.getValor());
  }

  @Test
  void getPorcentajeComplementario() {
    assertEquals(0.8, porcentaje.getComplementario());
  }
}
