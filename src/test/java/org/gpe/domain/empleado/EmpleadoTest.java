package org.gpe.domain.empleado;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {

  Empleado empleado;

  @BeforeEach
  void setUp() {
    empleado =
        new Empleado(
            "Jairo",
            "Mercury",
            LocalDate.of(2000, 1, 1),
            "San Miguel, El Salvador",
            "21425611-1",
            "test@test.test",
            LocalDate.of(2023, 5, 15));
  }

  @AfterEach
  void tearDown() {
    empleado = null;
  }

  @Test
  void setNombres() {
    empleado.setNombres("Edu");
    assertEquals("Edu", empleado.getNombres());
  }

  @Test
  void setApellidos() {
    empleado.setApellidos("Taboada");
    assertEquals("Taboada", empleado.getApellidos());
  }

  @Test
  void setFechaNacimiento() {
    LocalDate fecha = LocalDate.of(1999, 1, 1);
    empleado.setFechaNacimiento(fecha);
    assertEquals(fecha, empleado.getFechaNacimiento());
  }

  @Test
  void setDireccion() {
    empleado.setDireccion("San Salvador, El Salvador");
    assertEquals("San Salvador, El Salvador", empleado.getDireccion());
  }

  @Test
  void setIdenticicacion() {
    empleado.setIdenticicacion("1234567-8");
    assertEquals("1234567-8", empleado.getIdenticicacion());
  }

  @Test
  void setContacto() {
    empleado.setContacto("1234-5678");
    assertEquals("1234-5678", empleado.getContacto());
  }

  @Test
  void setFechaContrato() {
    LocalDate fecha = LocalDate.of(2022, 1, 1);
    empleado.setFechaContrato(fecha);
    assertEquals(fecha, empleado.getFechaContrato());
  }
}
