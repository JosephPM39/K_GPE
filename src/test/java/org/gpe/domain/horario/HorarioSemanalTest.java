package org.gpe.domain.horario;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import org.gpe.domain.utils.Dias;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HorarioSemanalTest {

  HorarioSemanal horario;

  @BeforeEach
  void setUp() {
    horario = new HorarioSemanal("Horario tech", "");
  }

  @AfterEach
  void tearDown() {
    horario = null;
  }

  @Test
  void agregarEliminarHorario() {
    HorarioDiario horarioDiario =
        new HorarioDiario("Horario Diario 2", "", LocalTime.of(8, 0), LocalTime.of(13, 0));
    horario.agregarOSustituirHorario(Dias.MARTES, horarioDiario);
    assertEquals(horarioDiario.getEntrada(), horario.getHorario().get(Dias.MARTES).getEntrada());
    horario.eliminarHorario(Dias.MARTES);
    assertNull(horario.getHorario().get(Dias.MARTES));
  }
}
