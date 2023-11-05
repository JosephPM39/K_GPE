package org.gpe.domain.deduccion_salarial;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.afp.DeduccionAfp;
import org.gpe.domain.deduccion_salarial.impuestos.isss.DeduccionIsss;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.renta.DeduccionRenta;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;
import org.gpe.domain.utils.Dinero;

public class DeduccionSalarial {

  private SalarioImpuestoFactory salarioImpuesto;
  private Isss isss;
  private Afp afp;
  private Renta renta;

  @Getter private Salario salarioBase;
  @Getter private Dinero salarioBruto = new Dinero(0.0);
  @Getter private ArrayList<SalarioExtraordinario> salariosExtraordinarios;
  @Getter private DeduccionRenta deduccionRenta;
  @Getter private DeduccionIsss deduccionIsss;
  @Getter private DeduccionAfp deduccionAfp;

  public DeduccionSalarial(Salario salarioBase) {
    this.salarioBase = salarioBase;
    calcularDeduccion();
  }

  public DeduccionSalarial(
      Salario salarioBase, ArrayList<SalarioExtraordinario> salariosExtraordinarios) {
    this.salarioBase = salarioBase;
    this.salariosExtraordinarios = salariosExtraordinarios;
    calcularDeduccion();
  }

  private void crearSalarioImpuesto() {
    this.salarioImpuesto = salarioBase.getSalarioImpuesto();
    this.isss = salarioImpuesto.crearIsss();
    this.afp = salarioImpuesto.crearAfp();
    this.renta = salarioImpuesto.crearRenta();
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
    crearSalarioImpuesto();
    calcularSalarioBruto();
    deduccionIsss = isss.calcularDeduccion(salarioBruto);
    deduccionAfp = afp.calcularDeduccion(salarioBruto);
    Dinero salarioPreRenta = salarioBruto.clone();
    salarioPreRenta.restar(deduccionIsss.getEmpleado());
    salarioPreRenta.restar(deduccionAfp.getEmpleado());
    this.deduccionRenta = this.renta.calcularDeduccion(salarioPreRenta);
  }
}
