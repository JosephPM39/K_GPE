package org.gpe.domain.deduccion_salarial;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.gpe.domain.deduccion_salarial.tributos.afp.Afp;
import org.gpe.domain.deduccion_salarial.tributos.afp.DeduccionAfp;
import org.gpe.domain.deduccion_salarial.tributos.isss.DeduccionIsss;
import org.gpe.domain.deduccion_salarial.tributos.isss.Isss;
import org.gpe.domain.deduccion_salarial.tributos.renta.DeduccionRenta;
import org.gpe.domain.deduccion_salarial.tributos.renta.Renta;
import org.gpe.domain.deduccion_salarial.tributo_factory.TributoFactory;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;
import org.gpe.domain.utils.Dinero;

public class DeduccionSalarial {

  @Getter private final Salario salarioBase;
  @Getter private final Dinero salarioBruto = new Dinero(0.0);
  @Getter private ArrayList<SalarioExtraordinario> salariosExtraordinarios;
  @Getter private DeduccionRenta renta;
  @Getter private DeduccionIsss isss;
  @Getter private DeduccionAfp afp;

  public DeduccionSalarial(Salario salarioBase) {
    this.salarioBase = salarioBase;
    calcularDeduccion();
  }

  public DeduccionSalarial(
      Salario salarioBase, List<SalarioExtraordinario> salariosExtraordinarios) {
    this.salarioBase = salarioBase;
    this.salariosExtraordinarios = new ArrayList<>(salariosExtraordinarios);
    calcularDeduccion();
  }

  private void calcularSalarioBruto() {
    this.salarioBruto.sumar(this.salarioBase.getSalario());
    if (salariosExtraordinarios != null) {
      Dinero totalSalarioExtra = new Dinero(0.0);
      for (SalarioExtraordinario salarioExtra : salariosExtraordinarios) {
        totalSalarioExtra.sumar(salarioExtra.getSalario());
      }
      this.salarioBruto.sumar(totalSalarioExtra);
    }
  }

  private void calcularDeduccion() {
    TributoFactory salarioImpuesto = salarioBase.getSalarioImpuesto();
    Isss isssCalculator = salarioImpuesto.crearIsss();
    Afp afpCalculator = salarioImpuesto.crearAfp();
    Renta rentaCalculator = salarioImpuesto.crearRenta();

    calcularSalarioBruto();

    this.isss = isssCalculator.calcularDeduccion(salarioBruto);
    this.afp = afpCalculator.calcularDeduccion(salarioBruto);

    Dinero salarioPreRenta = new Dinero(salarioBruto);
    salarioPreRenta.restar(this.isss.getEmpleado());
    salarioPreRenta.restar(this.afp.getEmpleado());

    this.renta = rentaCalculator.calcularDeduccion(salarioPreRenta);
  }
}
