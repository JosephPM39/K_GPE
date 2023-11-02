package org.gpe.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class DineroTest {

  static Dinero dinero;

  @BeforeEach
  void setUp() {
    dinero = new Dinero(50.0);
  }

  @AfterEach
  void tearDown() {
    dinero = null;
  }

  @Test
  void sumar() {
    dinero.sumar(new Dinero(7.96));
    assertEquals(new Dinero(57.96).getMonto(), dinero.getMonto());
  }

  @Test
  void restar() {
    dinero.restar(new Dinero(1.84));
    assertEquals(new Dinero(48.16).getMonto(), dinero.getMonto());
  }

  @Test
  void dividir() {
    dinero.dividir(3.24);
    assertEquals(new Dinero(15.43).getMonto(), dinero.getMonto());
  }

  @Test
  void multiplicar() {
    dinero.multiplicar(2.5);
    assertEquals(new Dinero(125.00).getMonto(), dinero.getMonto());
  }
}
