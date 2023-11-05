package org.gpe.domain.asistencia;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;
import org.gpe.domain.horario.HorarioSemanal;
import org.junit.jupiter.api.*;

class AsistenciaLaboralTest {

  static AsistenciaLaboral asistencia;

  @BeforeAll
  static void setUp() {
    HorarioSemanal horario = mock(HorarioSemanal.class);
    LocalDate fechaInicio = LocalDate.of(2023, 10, 1);
    LocalDate fechaFinal = LocalDate.of(2023, 10, 31);
    asistencia = new AsistenciaLaboral(horario, fechaInicio, fechaFinal);
  }

  @AfterAll
  static void tearDown() {
    asistencia = null;
  }

  @Test
  void registrarAusencia() {
    LocalDate fecha = LocalDate.of(2023, 10, 2);
    Ausencia ausencia = new Ausencia("Permiso por salud", "Aprobado");
    asistencia.registrarAusencia(fecha, ausencia);
    assertNotNull(asistencia.getAusencias().get(fecha));
  }

  @Test
  void registrarAsistencia() {
    LocalDate fecha = LocalDate.of(2023, 10, 2);
    LocalDate fecha2 = LocalDate.of(2023, 10, 3);
    LocalTime entrada = LocalTime.of(7, 0);
    LocalTime salida = LocalTime.of(12, 0);
    Asistencia asistenciaDia = new Asistencia(entrada, salida);
    asistencia.registrarAsistencia(fecha, asistenciaDia);
    asistencia.registrarAsistencia(fecha2, asistenciaDia);
    assertNotNull(asistencia.getAsistencias().get(fecha));
    assertNotNull(asistencia.getAsistencias().get(fecha2));
  }

  @Test
  void asignarVacaciones() {
    LocalDate fechaInicio = LocalDate.of(2023, 10, 10);
    LocalDate fechaFinal = LocalDate.of(2023, 10, 20);
    asistencia.asignarVacaciones(fechaInicio, fechaFinal);
    assertEquals("Vacaciones", asistencia.getAusencias().get(fechaInicio).getMotivo());
    assertEquals("Vacaciones", asistencia.getAusencias().get(fechaFinal).getMotivo());
  }

  @Test
  void asignarVacacionesFechaInicialSolapada() {
    LocalDate fechaInicioSolapada = LocalDate.of(2023, 9, 4);
    LocalDate fechaFinalSolapada = LocalDate.of(2023, 11, 2);
    LocalDate fechaInicio = LocalDate.of(2023, 10, 1);
    LocalDate fechaFinal = LocalDate.of(2023, 10, 31);
    asistencia.asignarVacaciones(fechaInicioSolapada, fechaFinalSolapada);
    assertNull(asistencia.getAusencias().get(fechaInicioSolapada));
    assertNull(asistencia.getAusencias().get(fechaFinalSolapada));
    assertEquals("Vacaciones", asistencia.getAusencias().get(fechaInicio).getMotivo());
    assertEquals("Vacaciones", asistencia.getAusencias().get(fechaFinal).getMotivo());
  }

  @Test
  void eliminarAsistencia() {
    LocalDate fecha = LocalDate.of(2023, 10, 2);
    asistencia.eliminarAsistencia(fecha);
    assertNull(asistencia.getAsistencias().get(fecha));
  }

  @Test
  void eliminarAusencia() {
    LocalDate fecha = LocalDate.of(2023, 10, 2);
    asistencia.eliminarAusencia(fecha);
    assertNull(asistencia.getAusencias().get(fecha));
  }

  @Test
  void getHorarioSemanal() {
    assertNotNull(asistencia.getHorarioSemanal());
  }

  @Test
  void getFechaInicio() {
    assertNotNull(asistencia.getFechaInicio());
  }

  @Test
  void getFechaFinal() {
    assertNotNull(asistencia.getFechaFinal());
  }

  @Test
  void getAsistencias() {
    assertNotNull(asistencia.getAsistencias());
  }

  @Test
  void getAusencias() {
    assertNotNull(asistencia.getAusencias());
  }

  @Test
  void setHorarioSemanal() {
    HorarioSemanal horario = mock(HorarioSemanal.class);
    asistencia.setHorarioSemanal(horario);
    assertNotNull(asistencia.getHorarioSemanal());
  }

  @Test
  void setFechaInicio() {
    LocalDate fecha = LocalDate.of(2023, 10, 1);
    asistencia.setFechaInicio(fecha);
    assertEquals(fecha, asistencia.getFechaInicio());
  }

  @Test
  void setFechaFinal() {
    LocalDate fecha = LocalDate.of(2023, 10, 31);
    asistencia.setFechaFinal(fecha);
    assertEquals(fecha, asistencia.getFechaFinal());
  }
}
