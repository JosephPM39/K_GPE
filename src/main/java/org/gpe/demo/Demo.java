package org.gpe.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import org.gpe.domain.asistencia.Asistencia;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.DeduccionSalarial;
import org.gpe.domain.deduccion_salarial.NominaItem;
import org.gpe.domain.deduccion_salarial.NominaSalarial;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoMensualFactory;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.horario.HorarioDiario;
import org.gpe.domain.horario.HorarioSemanal;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorDia;
import org.gpe.domain.salario.SalarioQuincenal;
import org.gpe.domain.utils.Dias;

public class Demo {

  public static void main(String[] args) {


    // Fake Empleado
    Empleado empleado = new Empleado();
    empleado.setNombres("Jairo");
    empleado.setApellidos("Mercury");
    empleado.setIdenticicacion("234252-2");
    empleado.setFechaNacimiento(LocalDate.of(2000, 1, 1));

    // Fake Horarios
    HorarioSemanal horarioTecnicoSemanal =
        new HorarioSemanal("Horario tecnico", "Horario de los tecnicos en mantenimiento");
    HorarioDiario horarioMantenimiento =
        new HorarioDiario(
            "Mantenimiento",
            "Horario de mantenimiento de equipos",
            LocalTime.of(7, 0),
            LocalTime.of(12, 0));
    horarioTecnicoSemanal.agregarOSustituirHorario(Dias.Lunes, horarioMantenimiento);

    // Fake Asistencias
    Asistencia asistencia = new Asistencia(LocalTime.of(7, 0), LocalTime.of(4, 0));
    AsistenciaLaboral asistenciaLaboral =
        new AsistenciaLaboral(
            horarioTecnicoSemanal, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 31));
    asistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 10, 9), asistencia);

    // Fake Salarios
    // Salario salarioBase = new SalarioMensual(1200.0);
    // Salario salarioBase = new SalarioQuincenal(600.0);
    Salario salarioBase = new SalarioPorDia(40.0);
    HorasExtra horasExtras = new HorasExtra(asistenciaLaboral);

    // Fake Registro
    NominaItem registro = new NominaItem.Builder(empleado, salarioBase).construir();

    // Fake Nomina
    NominaSalarial nomina = new NominaSalarial();
    nomina.agregarRegistro(registro);
    nomina.setVigencia("From yesterday");

    NominaItem registroEncontrado = nomina.buscarRegistro("234252-2");
    registroEncontrado.calcularDeducciones();

    // Resultados
    System.out.println(
        "Empleado: "
            + registroEncontrado.getEmpleado().getNombres()
            + " "
            + registroEncontrado.getEmpleado().getApellidos());
    System.out.println("Salario bruto: " + registroEncontrado.getDeduccionSalarial().getSalarioBruto());
    System.out.println("Afp: " + registroEncontrado.getDeduccionSalarial().getAfp().getAfpEmpleado());
    System.out.println("Isss: " + registroEncontrado.getDeduccionSalarial().getIsss().getIsssEmpleado());
    System.out.println("Renta: " + registroEncontrado.getDeduccionSalarial().getDeduccionRenta().getRetencion());
    System.out.println("Salario líquido: " + registroEncontrado.getDeduccionSalarial().getDeduccionRenta().getSalarioLiquido());
  }
}
