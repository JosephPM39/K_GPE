package org.gpe.domain.horario;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorarioDiarioTest {

  HorarioDiario horario;

  @BeforeEach
  void setUp() {
    LocalTime entrada = LocalTime.of(7, 0);
    LocalTime salida = LocalTime.of(12, 0);
    horario = new HorarioDiario("Horario Del dia", "", entrada, salida);
  }

  @AfterEach
  void tearDown() {
    horario = null;
  }

  @Test
  void setEntrada() {
    LocalTime entrada = LocalTime.of(8, 0);
    horario.setEntrada(entrada);
    assertEquals(entrada, horario.getEntrada());
  }

  @Test
  void setSalida() {
    LocalTime salida = LocalTime.of(8, 0);
    horario.setSalida(salida);
    assertEquals(salida, horario.getSalida());
  }

  @Test
  void setNombre() {
    String nombre = "Horario de mantenimiento";
    horario.setNombre(nombre);
    assertEquals(nombre, horario.getNombre());
  }

  @Test
  void setDescripcion() {
    String descripcion = "Este horario es para el mantenimiento de las PC";
    horario.setDescripcion(descripcion);
    assertEquals(descripcion, horario.getDescripcion());
  }
}
