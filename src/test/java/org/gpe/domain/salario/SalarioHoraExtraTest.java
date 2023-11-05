package org.gpe.domain.salario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.gpe.domain.asistencia.HorasExtra;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalarioHoraExtraTest {

  SalarioHoraExtra salarioHoraExtra;

  @BeforeEach
  void setUp() {
    salarioHoraExtra = new SalarioHoraExtra(new SalarioPorHora(3.00, 1), mock(HorasExtra.class));
  }

  @AfterEach
  void tearDown() {
    salarioHoraExtra = null;
  }

  @Test
  void getSalarioPorHorasNocturnas() {
    assertNotNull(salarioHoraExtra.getSalarioPorHorasNocturnas());
  }

  @Test
  void getSalarioPorHorasDiurnas() {
    assertNotNull(salarioHoraExtra.getSalarioPorHorasDiurnas());
  }

  @Test
  void getSalario() {
    assertNotNull(salarioHoraExtra.getSalario());
  }

  @Test
  void getHorasExtras() {
    assertNotNull(salarioHoraExtra.getHorasExtras());
  }
}
