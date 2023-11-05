package org.gpe.domain.salario;

import lombok.Getter;
import org.gpe.domain.utils.Dinero;

public class SalarioPorDia implements SalarioEspecial {
  @Getter private final Dinero tarifa;
  @Getter private final Integer unidades;
  @Getter private final Dinero salario;

  public SalarioPorDia(Double tarifa, Integer unidades) {
    this.tarifa = new Dinero(tarifa);
    this.unidades = unidades;
    salario = new Dinero(tarifa);
    salario.multiplicar(unidades);
  }
}
