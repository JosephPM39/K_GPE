package org.gpe.domain.asistencia;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import org.gpe.domain.horario.HorarioDiario;
import org.gpe.domain.horario.HorarioSemanal;
import org.gpe.domain.utils.DateUtils;
import org.gpe.domain.utils.Dias;

public class HorasExtra {
  private LocalTime horaMaximaDiurna = LocalTime.of(19, 0);
  @Getter private int horasDiurnas = 0;
  @Getter private int horasNocturnas = 0;
  @Getter private AsistenciaLaboral asistencias;

  public HorasExtra(AsistenciaLaboral asistencias) {
    this.asistencias = asistencias;
    calcularHorasExtras();
  }

  private void calcularHorasExtras() {
    LocalDate fechaInicial = asistencias.getFechaInicio();
    LocalDate fechaFinal = asistencias.getFechaFinal();

    LocalDate fechaActual = fechaInicial;
    while (!fechaActual.isAfter(fechaFinal)) {
      if (!asistencias.getAsistencias().containsKey(fechaActual)) {
        fechaActual = fechaActual.plusDays(1);
        continue;
      }
      Asistencia asistencia = asistencias.getAsistencias().get(fechaActual);
      Dias dia = DateUtils.getDayOfWeek(fechaActual);
      HorarioSemanal horarioSemanal = asistencias.getHorarioSemanal();
      HorarioDiario horario = horarioSemanal.getHorario().get(dia);

      LocalTime horaSalidaHorario = horario.getSalida();
      LocalTime horaSalidaAsistencia = asistencia.getHoraSalida();

      horasDiurnas += calcularHorasDiurnas(horaSalidaHorario, horaSalidaAsistencia);
      horasNocturnas += calcularHorasNocturnas(horaSalidaHorario, horaSalidaAsistencia);
      fechaActual = fechaActual.plusDays(1);
    }
  }

  private int calcularHorasDiurnas(LocalTime horaSalidaHorario, LocalTime horaSalidaAsistencia) {
    if (horaSalidaHorario.isAfter(horaSalidaAsistencia)) {
      return 0;
    }
    if (horaSalidaHorario.isAfter(horaMaximaDiurna)) {
      return 0;
    }
    return calcularTotalHoras(horaSalidaHorario, horaSalidaAsistencia);
  }

  private int calcularHorasNocturnas(LocalTime horaSalidaHorario, LocalTime horaSalidaAsistencia) {
    if (horaSalidaHorario.isAfter(horaSalidaAsistencia)) {
      return 0;
    }
    if (horaSalidaAsistencia.isBefore(horaMaximaDiurna)) {
      return 0;
    }
    return calcularTotalHoras(horaMaximaDiurna, horaSalidaAsistencia);
  }

  private int calcularTotalHoras(LocalTime desde, LocalTime hasta) {
    Duration duracion = Duration.between(desde, hasta);
    int horaAdicional = 0;
    int totalHorasCompletas = (int) duracion.toHours();
    if ((duracion.toMinutes() % 60) > 5) {
      horaAdicional = 1;
    }

    return horaAdicional + totalHorasCompletas;
  }
}
