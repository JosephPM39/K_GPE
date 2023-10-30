package org.gpe.domain.salario;

import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.asistencia.HorasExtra;

public class SalarioHoraExtra implements Salario {
  private final Double porcentajeHorasDiurnas = 100.0 / 100.0;
  private final Double porcentajeHorasNocturnas = 150.0 / 100.0;

  @Getter private Double salarioPorHorasNocturnas;
  @Getter private Double salarioPorHorasDiurnas;
  @Getter private Double salario;
  @Getter @Setter private HorasExtra horasExtras;

  SalarioPorHora salarioPorHora;

  public SalarioHoraExtra(Double salario, HorasExtra horasExtras) {
    salarioPorHora = new SalarioPorHora(salario);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  public SalarioHoraExtra(SalarioMensual salario, HorasExtra horasExtras) {
    this.salarioPorHora = new SalarioPorHora(salario);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  public SalarioHoraExtra(SalarioPorSemana salario, HorasExtra horasExtras) {
    this.salarioPorHora = new SalarioPorHora(salario.getSalario() / 7 / 8);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  public SalarioHoraExtra(SalarioPorDia salario, HorasExtra horasExtras) {
    this.salarioPorHora = new SalarioPorHora(salario.getSalario() / 8);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  public SalarioHoraExtra(SalarioPorHora salario, HorasExtra horasExtras) {
    this.salarioPorHora = new SalarioPorHora(salario.getSalario());
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  public SalarioHoraExtra(SalarioQuincenal salario, HorasExtra horasExtras) {
    this.salarioPorHora = new SalarioPorHora(salario.getSalario() / 15 / 8);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  private void calcularSalario() {
    Double recargoDiurno = calcularRecargo(salarioPorHora.getSalario(), porcentajeHorasDiurnas);
    Double recargoNocturno = calcularRecargo(salarioPorHora.getSalario(), porcentajeHorasNocturnas);
    salarioPorHorasDiurnas = horasExtras.getHorasDiurnas() * recargoDiurno;
    salarioPorHorasNocturnas = horasExtras.getHorasNocturnas() * recargoNocturno;
    salario = salarioPorHorasDiurnas + salarioPorHorasNocturnas;
  }

    private Double calcularRecargo(Double salario, Double porcentaje) {
        return (salario * porcentaje) + salario;
    }
}
