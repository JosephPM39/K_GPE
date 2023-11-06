package org.gpe.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import org.gpe.domain.asistencia.Asistencia;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.NominaItem;
import org.gpe.domain.deduccion_salarial.NominaSalarial;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.horario.HorarioDiario;
import org.gpe.domain.horario.HorarioSemanal;
import org.gpe.domain.salario.*;
import org.gpe.domain.utils.Dias;

public class Demo {

  public static void main(String[] args) {

    // ===================================================
    // Fake Empleado
    // ===================================================
    Empleado empleado = new Empleado();
    empleado.setNombres("Jairo");
    empleado.setApellidos("Mercury");
    empleado.setIdenticicacion("234252-2");
    empleado.setFechaNacimiento(LocalDate.of(2000, 1, 1));

    // ===================================================
    // Fake Horarios
    // ===================================================
    HorarioSemanal horarioTecnicoSemanal =
        new HorarioSemanal("Horario tecnico", "Horario de los tecnicos en mantenimiento");
    HorarioDiario horarioMantenimiento =
        new HorarioDiario(
            "Mantenimiento",
            "Horario de mantenimiento de equipos",
            LocalTime.of(7, 0),
            LocalTime.of(12, 0));
    horarioTecnicoSemanal.agregarOSustituirHorario(Dias.LUNES, horarioMantenimiento);

    // ===================================================
    // Fake Asistencias
    // ===================================================
    Asistencia asistencia = new Asistencia(LocalTime.of(7, 0), LocalTime.of(4, 0));
    AsistenciaLaboral asistenciaLaboral =
        new AsistenciaLaboral(
            horarioTecnicoSemanal, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 31));
    asistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 10, 9), asistencia);

    // ===================================================
    // Fake Salarios
    // ===================================================
    Salario salarioBaseMensual = new SalarioMensual(1200.0);
    Salario salarioBaseQuincenal = new SalarioQuincenal(600.0);
    Salario salarioBaseSemanal = new SalarioPorSemana(200.0);
    // Convirtiendo salario por hora a por semana
    Salario salarioPor8Horas =
        new SalarioPorSemana(new SalarioPorHora(6.0, 8).getSalario().getDecimal());
    HorasExtra horasExtras = new HorasExtra(asistenciaLaboral);
    SalarioPorHora salarioPorHora = new SalarioPorHora(3.0, 1);
    SalarioHoraExtra salarioHoraExtra = new SalarioHoraExtra(salarioPorHora, horasExtras);

    // ===================================================
    // Fake Registro
    // ===================================================
    NominaItem registro = new NominaItem.Builder(empleado, salarioBaseSemanal).construir();

    // ===================================================
    // Fake Nomina
    // ===================================================
    NominaSalarial nomina = new NominaSalarial();
    nomina.agregarRegistro(registro);
    nomina.setVigencia("From yesterday");

    // ===================================================
    // Resultados
    // ===================================================
    NominaItem registroEncontrado = nomina.buscarRegistro("234252-2");
    System.out.println(
        "Empleado: "
            + registroEncontrado.getEmpleado().getNombres()
            + " "
            + registroEncontrado.getEmpleado().getApellidos());
    System.out.println(
        "Salario bruto: " + registroEncontrado.getDeduccionSalarial().getSalarioBruto().getMonto());
    System.out.println(
        "Afp: " + registroEncontrado.getDeduccionSalarial().getAfp().getEmpleado().getMonto());
    System.out.println(
        "Isss: " + registroEncontrado.getDeduccionSalarial().getIsss().getEmpleado().getMonto());
    System.out.println(
        "Renta: " + registroEncontrado.getDeduccionSalarial().getRenta().getRetencion().getMonto());
    System.out.println(
        "Salario líquido: "
            + registroEncontrado.getDeduccionSalarial().getRenta().getSalarioLiquido().getMonto());
  }
}
