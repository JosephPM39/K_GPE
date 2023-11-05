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
    assertEquals(57.96, dinero.getDecimal());
  }

  @Test
  void sumarPorcentaje() {
    dinero.sumar(new Porcentaje(50));
    assertEquals(75.00, dinero.getDecimal());
  }

  @Test
  void restar() {
    dinero.restar(new Dinero(1.84));
    assertEquals(48.16, dinero.getDecimal());
  }

  @Test
  void restarPorcentaje() {
    dinero.restar(new Porcentaje(50));
    assertEquals(25.00, dinero.getDecimal());
  }

  @Test
  void dividir() {
    dinero.dividir(3.24);
    assertEquals(15.43, dinero.getDecimal());
  }

  @Test
  void dividirPorEntero() {
    dinero.dividir(2);
    assertEquals(25.00, dinero.getDecimal());
  }

  @Test
  void multiplicar() {
    dinero.multiplicar(2.5);
    assertEquals(125.00, dinero.getDecimal());
  }

  @Test
  void multiplicarPorEntero() {
    dinero.multiplicar(2);
    assertEquals(100.00, dinero.getDecimal());
  }

  @Test
  void menorQue() {
    assertTrue(dinero.menorQue(new Dinero(100.00)));
    assertFalse(dinero.menorQue(new Dinero(10.00)));
  }

  @Test
  void mayorQue() {
    assertTrue(dinero.mayorQue(new Dinero(10.00)));
    assertFalse(dinero.mayorQue(new Dinero(100.00)));
  }

  @Test
  void iguales() {
    assertTrue(dinero.iguales(new Dinero(50.00)));
    assertFalse(dinero.iguales(new Dinero(10.00)));
  }

  @Test
  void toStringMethod() {
    assertEquals("50.00", dinero.toString());
  }
}
