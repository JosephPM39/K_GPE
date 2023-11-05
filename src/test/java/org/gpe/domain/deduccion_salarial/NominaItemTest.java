package org.gpe.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.gpe.domain.asistencia.Asistencia;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.horario.HorarioDiario;
import org.gpe.domain.horario.HorarioSemanal;
import org.gpe.domain.salario.*;
import org.gpe.domain.utils.Dias;
import org.junit.jupiter.api.*;

class NominaItemTest {

  static NominaItem nominaItem;

  static HorarioSemanal createHorario() {
    HorarioSemanal horario = new HorarioSemanal("Horario tech", "");
    horario.agregarOSustituirHorario(
        Dias.Lunes,
        new HorarioDiario("Horario Diario", "", LocalTime.of(7, 0), LocalTime.of(12, 0)));
    horario.agregarOSustituirHorario(
        Dias.Martes,
        new HorarioDiario("Horario Diario", "", LocalTime.of(7, 0), LocalTime.of(15, 0)));
    return horario;
  }

  static AsistenciaLaboral createAsistencia() {
    LocalDate fechaInicio = LocalDate.of(2023, 10, 1);
    LocalDate fechaFinal = LocalDate.of(2023, 10, 31);

    AsistenciaLaboral asistencia = new AsistenciaLaboral(createHorario(), fechaInicio, fechaFinal);

    LocalDate fechaAsistenciaLunes = LocalDate.of(2023, 10, 2);
    Asistencia asistenciaLunes = new Asistencia(LocalTime.of(7, 0), LocalTime.of(20, 0));

    LocalDate fechaAsistenciaMartes = LocalDate.of(2023, 10, 3);
    Asistencia asistenciaMartes = new Asistencia(LocalTime.of(7, 0), LocalTime.of(14, 0));

    asistencia.registrarAsistencia(fechaAsistenciaLunes, asistenciaLunes);
    asistencia.registrarAsistencia(fechaAsistenciaMartes, asistenciaMartes);

    return asistencia;
  }

  @BeforeAll
  static void setUp() {
    nominaItem =
        new NominaItem.Builder(mock(Empleado.class), new SalarioMensual(700.00))
            .conAsistencia(createAsistencia())
            .conAsistenciaYHorasExtras(createAsistencia(), new SalarioPorHora(3.00, 1))
            .construir();
  }

  @AfterAll
  static void tearDown() {
    nominaItem = null;
  }

  @Test
  void setSalarioBase() {
    nominaItem.setSalarioBase(new SalarioMensual(700.00));
    assertEquals(700.00, nominaItem.getSalarioBase().getSalario().getDecimal());
  }

  @Test
  void setAsistencia() {
    nominaItem.setAsistencia(createAsistencia());
    assertNotNull(nominaItem.getAsistencia());
  }

  @Test
  void setSalarioPorHora() {
    SalarioPorHora salario = new SalarioPorHora(3.00, 1);
    nominaItem.setSalarioPorHora(salario);
    assertEquals(salario, nominaItem.getSalarioPorHora());
  }

  @Test
  void setSalariosExtras() {
    ArrayList<SalarioExtraordinario> extras = new ArrayList<>();
    extras.add(new SalarioHoraExtra(new SalarioPorHora(3.00, 1), mock(HorasExtra.class)));
    nominaItem.setSalariosExtras(extras);
    assertEquals(extras, nominaItem.getSalariosExtras());
  }

  @Test
  void getEmpleado() {
    assertNotNull(nominaItem.getEmpleado());
  }

  @Test
  void getSalarioBase() {
    assertEquals(700.00, nominaItem.getSalarioBase().getSalario().getDecimal());
  }

  @Test
  void getAsistencia() {
    assertNotNull(nominaItem.getAsistencia());
  }

  @Test
  void getHorasExtra() {
    assertNotNull(nominaItem.getHorasExtra());
  }

  @Test
  void getSalarioHoraExtra() {
    assertNotNull(nominaItem.getSalariosExtras());
  }

  @Test
  void getSalarioPorHora() {
    assertNotNull(nominaItem.getSalarioPorHora());
  }

  @Test
  void getSalariosExtras() {
    assertNotNull(nominaItem.getSalariosExtras());
  }

  @Test
  void getDeduccionSalarial() {
    assertEquals(
        732.83, nominaItem.getDeduccionSalarial().getIsss().getSalarioLiquido().getDecimal());
    assertEquals(
        700.73, nominaItem.getDeduccionSalarial().getAfp().getSalarioLiquido().getDecimal());
    assertEquals(
        639.78,
        nominaItem.getDeduccionSalarial().getDeduccionRenta().getSalarioLiquido().getDecimal());
  }

  @Test
  void setEmpleado() {
    nominaItem.setEmpleado(mock(Empleado.class));
    assertNotNull(nominaItem.getEmpleado());
  }
}
