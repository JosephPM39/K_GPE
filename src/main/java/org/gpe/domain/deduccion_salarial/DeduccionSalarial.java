package org.gpe.domain.deduccion_salarial;

import java.util.ArrayList;
import lombok.Getter;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.renta.DeduccionRenta;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;

public class DeduccionSalarial {

  private SalarioImpuestoFactory salarioImpuesto;
  @Getter private Isss isss;
  @Getter private Afp afp;
  @Getter private Renta renta;
  @Getter private Salario salarioBase;
  @Getter private ArrayList<SalarioExtraordinario> salariosExtraordinarios;

  @Getter private DeduccionRenta deduccionRenta;

  private Double salarioBruto = 0.0;

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
    this.salarioBruto += this.salarioBase.getSalario();
    if (salariosExtraordinarios != null) {
      Double totalSalarioExtra = 0.0;
      for (SalarioExtraordinario salarioExtra : salariosExtraordinarios) {
        totalSalarioExtra += salarioExtra.getSalario();
      }
      this.salarioBruto += totalSalarioExtra;
    }
  }

  private void calcularDeduccion() {
    crearSalarioImpuesto();
    calcularSalarioBruto();
    isss.calcularDeduccion(salarioBruto);
    afp.calcularDeduccion(salarioBruto);
    Double salarioPreRenta = salarioBruto - afp.getAfpEmpleado() - isss.getIsssEmpleado();
    this.deduccionRenta = this.renta.calcularDeduccion(salarioPreRenta);
  }
}
