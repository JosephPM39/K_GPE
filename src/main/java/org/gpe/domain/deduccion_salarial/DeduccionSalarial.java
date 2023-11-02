package org.gpe.domain.deduccion_salarial;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.renta.DeduccionRenta;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;

@Getter
@Setter
public class DeduccionSalarial {

  private SalarioImpuestoFactory salarioImpuesto;
  private Isss isss;
  private Afp afp;
  private Renta renta;
  private Salario salarioBase;
  private ArrayList<SalarioExtraordinario> salariosExtraordinarios;

  private DeduccionRenta deduccionRenta;

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

  public static class Builder {
    private Salario salarioBase;
    private ArrayList<SalarioExtraordinario> salariosExtraordinarios;

    public Builder(Salario salarioBase) {
      this.salarioBase = salarioBase;
    }

    public Builder conSalariosExtraordinarios(
        ArrayList<SalarioExtraordinario> salariosExtraordinarios) {
      this.salariosExtraordinarios = salariosExtraordinarios;
      return this;
    }

    public DeduccionSalarial construir() {
      return new DeduccionSalarial(salarioBase, salariosExtraordinarios);
    }
  }
}
