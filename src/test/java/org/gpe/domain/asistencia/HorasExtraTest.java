package org.gpe.domain.asistencia;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import org.gpe.domain.horario.HorarioDiario;
import org.gpe.domain.horario.HorarioSemanal;
import org.gpe.domain.utils.Dias;
import org.junit.jupiter.api.*;

class HorasExtraTest {

  static AsistenciaLaboral asistencia;
  HorasExtra horasExtra;

  static HorarioSemanal getHorario() {
    HorarioSemanal horario = new HorarioSemanal("Horario tech", "");
    horario.agregarOSustituirHorario(
        Dias.LUNES,
        new HorarioDiario("Horario Diario", "", LocalTime.of(7, 0), LocalTime.of(12, 0)));
    horario.agregarOSustituirHorario(
        Dias.MARTES,
        new HorarioDiario("Horario Diario", "", LocalTime.of(7, 0), LocalTime.of(15, 0)));
    return horario;
  }

  static AsistenciaLaboral getAsistencia() {
    LocalDate fechaInicio = LocalDate.of(2023, 10, 1);
    LocalDate fechaFinal = LocalDate.of(2023, 10, 31);

    AsistenciaLaboral asistencia = new AsistenciaLaboral(getHorario(), fechaInicio, fechaFinal);

    LocalDate fechaAsistenciaLunes = LocalDate.of(2023, 10, 2);
    Asistencia asistenciaLunes = new Asistencia(LocalTime.of(7, 0), LocalTime.of(20, 0));

    LocalDate fechaAsistenciaMartes = LocalDate.of(2023, 10, 3);
    Asistencia asistenciaMartes = new Asistencia(LocalTime.of(7, 0), LocalTime.of(14, 0));

    asistencia.registrarAsistencia(fechaAsistenciaLunes, asistenciaLunes);
    asistencia.registrarAsistencia(fechaAsistenciaMartes, asistenciaMartes);

    return asistencia;
  }

  @BeforeAll
  static void setUpBAll() {
    asistencia = getAsistencia();
  }

  @AfterAll
  static void tearDownBAll() {
    asistencia = null;
  }

  @BeforeEach
  void setUp() {
    horasExtra = new HorasExtra(asistencia);
  }

  @AfterEach
  void tearDown() {
    horasExtra = null;
  }

  @Test
  void getHorasDiurnas() {
    assertEquals(8, horasExtra.getHorasDiurnas());
  }

  @Test
  void getHorasNocturnas() {
    assertEquals(1, horasExtra.getHorasNocturnas());
  }

  @Test
  void getAsistencias() {
    assertEquals(asistencia, horasExtra.getAsistencias());
  }
}
