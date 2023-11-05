package org.gpe.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.*;

import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioMensual;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NominaSalarialTest {

  NominaSalarial nominaSalarial;

  NominaItem createRegistro(String identificacion) {
    Salario salario = new SalarioMensual(700.00);
    Empleado empleado = new Empleado();
    empleado.setIdenticicacion(identificacion);
    return new NominaItem.Builder(empleado, salario).construir();
  }

  @BeforeEach
  void setUp() {
    nominaSalarial = new NominaSalarial();
    nominaSalarial.agregarRegistro(createRegistro("1234567-8"));
  }

  @AfterEach
  void tearDown() {
    nominaSalarial = null;
  }

  @Test
  void agregarRegistro() {
    String identificacion = "13579-0";
    nominaSalarial.agregarRegistro(createRegistro(identificacion));
    assertEquals(
        identificacion,
        nominaSalarial.buscarRegistro(identificacion).getEmpleado().getIdenticicacion());
  }

  @Test
  void removerRegistro() {
    assertTrue(nominaSalarial.removerRegistro("1234567-8"));
  }

  @Test
  void setVigencia() {
    String vigencia = "Octubre - Noviembre (2023)";
    nominaSalarial.setVigencia(vigencia);
    assertEquals(vigencia, nominaSalarial.getVigencia());
  }
}
