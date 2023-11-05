package org.gpe.domain.salario;

import org.gpe.domain.utils.Dinero;

public interface SalarioEspecial {
  public Integer getUnidades();

  public Dinero getTarifa();

  public Dinero getSalario();
}
