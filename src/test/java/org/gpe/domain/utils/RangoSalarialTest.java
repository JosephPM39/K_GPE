package org.gpe.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class RangoSalarialTest {

  RangoSalarial rangoSalarial;

  @BeforeEach
  void setUp() {
    rangoSalarial = new RangoSalarial(new Dinero(100.0), new Dinero(200.0));
  }

  @AfterEach
  void tearDown() {
    rangoSalarial = null;
  }

  @Test
  void esEnRango() {
    assertTrue(rangoSalarial.esEnRango(new Dinero(150.00)));
    assertFalse(rangoSalarial.esEnRango(new Dinero(300.00)));
    assertFalse(rangoSalarial.esEnRango(new Dinero(50.00)));
  }

  @Test
  void esPreRango() {
    assertFalse(rangoSalarial.esPreRango(new Dinero(150.00)));
    assertFalse(rangoSalarial.esPreRango(new Dinero(300.00)));
    assertTrue(rangoSalarial.esPreRango(new Dinero(50.00)));
  }

  @Test
  void esPosRango() {
    assertFalse(rangoSalarial.esPosRango(new Dinero(150.00)));
    assertTrue(rangoSalarial.esPosRango(new Dinero(300.00)));
    assertFalse(rangoSalarial.esPosRango(new Dinero(50.00)));
  }

  @Test
  void getInicio() {
    assertEquals(100.00, rangoSalarial.getInicio().getDecimal());
  }

  @Test
  void getFin() {
    assertEquals(200.00, rangoSalarial.getFin().getDecimal());
  }

  @Test
  void setInicio() {
    rangoSalarial.setInicio(new Dinero(10.00));
    assertEquals(10.00, rangoSalarial.getInicio().getDecimal());
  }

  @Test
  void setFin() {
    rangoSalarial.setFin(new Dinero(10.00));
    assertEquals(10.00, rangoSalarial.getFin().getDecimal());
  }
}
