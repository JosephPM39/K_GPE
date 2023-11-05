package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.asistencia.HorasExtra;

public class SalarioHoraExtra implements SalarioExtraordinario {
  private final Double porcentajeHorasDiurnas = 100.0 / 100.0;
  private final Double porcentajeHorasNocturnas = 150.0 / 100.0;

  @Getter private Double salarioPorHorasNocturnas;
  @Getter private Double salarioPorHorasDiurnas;
  @Getter private Double salario;
  @Getter private HorasExtra horasExtras;

  SalarioPorHora salarioPorHora;

  public SalarioHoraExtra(SalarioPorHora salario, HorasExtra horasExtras) {
    this.salarioPorHora = salario;
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
