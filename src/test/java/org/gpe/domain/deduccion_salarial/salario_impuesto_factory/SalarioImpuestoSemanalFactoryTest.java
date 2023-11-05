package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalarioImpuestoSemanalFactoryTest {
  SalarioImpuestoSemanalFactory factory;

  @BeforeEach
  void setUp() {
    factory = new SalarioImpuestoSemanalFactory();
  }

  @AfterEach
  void tearDown() {
    factory = null;
  }

  @Test
  void crearIsss() {
    assertNotEquals(null, factory.crearIsss());
  }

  @Test
  void crearAfp() {
    assertNotEquals(null, factory.crearAfp());
  }

  @Test
  void crearRenta() {
    assertNotEquals(null, factory.crearRenta());
  }
}
