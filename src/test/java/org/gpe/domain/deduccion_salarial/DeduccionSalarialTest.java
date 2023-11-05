package org.gpe.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.salario.*;
import org.junit.jupiter.api.*;

class DeduccionSalarialTest {

  static DeduccionSalarial deduccion;

  @BeforeAll
  static void setUp() {
    ArrayList<SalarioExtraordinario> extras = new ArrayList<>();
    extras.add(new SalarioHoraExtra(new SalarioPorHora(2.95, 1), mock(HorasExtra.class)));
    extras.add(new SalarioHoraExtra(new SalarioPorHora(8.65, 1), mock(HorasExtra.class)));
    Salario salario = new SalarioMensual(700.00);
    deduccion = new DeduccionSalarial(salario, extras);
  }

  @AfterAll
  static void tearDown() {
    deduccion = null;
  }

  @Test
  void getIsss() {
    assertEquals(679.00, deduccion.getIsss().getSalarioLiquido());
  }

  @Test
  void getAfp() {
    assertEquals(649.25, deduccion.getAfp().getSalarioLiquido());
  }

  @Test
  void getRenta() {
    assertNotNull(deduccion.getRenta());
  }

  @Test
  void getSalarioBase() {
    assertEquals(700.00, deduccion.getSalarioBase().getSalario());
  }

  @Test
  void getSalariosExtraordinarios() {
    assertEquals(2, deduccion.getSalariosExtraordinarios().size());
  }

  @Test
  void getDeduccionRenta() {
    assertEquals(594.96, deduccion.getDeduccionRenta().getSalarioLiquido());
  }
}
