package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.utils.Dinero;
import org.gpe.domain.utils.Porcentaje;

public class SalarioHoraExtra implements SalarioExtraordinario {
  private final Porcentaje porcentajeHorasDiurnas = new Porcentaje(100);
  private final Porcentaje porcentajeHorasNocturnas = new Porcentaje(150);

  @Getter private Dinero salarioPorHorasNocturnas;
  @Getter private Dinero salarioPorHorasDiurnas;
  @Getter private Dinero salario;
  @Getter private HorasExtra horasExtras;

  SalarioPorHora salarioPorHora;

  public SalarioHoraExtra(SalarioPorHora salario, HorasExtra horasExtras) {
    this.salarioPorHora = salario;
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  private void calcularSalario() {
    Dinero recargoDiurno = calcularRecargo(salarioPorHora.getSalario(), porcentajeHorasDiurnas);
    recargoDiurno.multiplicar(horasExtras.getHorasDiurnas());
    salarioPorHorasDiurnas = recargoDiurno;

    Dinero recargoNocturno = calcularRecargo(salarioPorHora.getSalario(), porcentajeHorasNocturnas);
    recargoNocturno.multiplicar(horasExtras.getHorasNocturnas());
    salarioPorHorasNocturnas = recargoNocturno;

    Dinero salario = recargoDiurno.clone();
    salario.sumar(recargoNocturno);
    this.salario = salario;
  }

  private Dinero calcularRecargo(Dinero salario, Porcentaje porcentaje) {
    Dinero recargo = salario.clone();
    recargo.sumar(porcentaje);
    return recargo;
  }
}
