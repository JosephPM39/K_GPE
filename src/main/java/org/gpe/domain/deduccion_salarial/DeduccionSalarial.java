package org.gpe.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;

import java.util.ArrayList;

@Getter
@Setter
public class DeduccionSalarial {

  private SalarioImpuestoFactory salarioImpuesto;
  private Isss isss;
  private Afp afp;
  private Renta renta;
  private Salario salario;
  private SalarioHoraExtra salarioHoraExtra;

  private HorasExtra horasExtras;
  private ArrayList<Salario> salariosExtras;

  private Double salarioBruto = 0.0;

  public DeduccionSalarial(SalarioImpuestoFactory salarioImpuesto) {
    this.salarioImpuesto = salarioImpuesto;
    calcularDeduccion();
  }

  public DeduccionSalarial(SalarioImpuestoFactory salarioImpuesto, HorasExtra horasExtras) {
    this.salarioImpuesto = salarioImpuesto;
    this.horasExtras = horasExtras;
    calcularDeduccion();
  }

  public DeduccionSalarial(SalarioImpuestoFactory salarioImpuesto, HorasExtra horasExtras, ArrayList<Salario> salariosExtras) {
    this.salarioImpuesto = salarioImpuesto;
    this.horasExtras = horasExtras;
    this.salariosExtras = salariosExtras;
    calcularDeduccion();
  }

  private void crearSalarioImpuesto() {
    this.salario = salarioImpuesto.crearSalario();
    this.isss = salarioImpuesto.crearIsss();
    this.afp = salarioImpuesto.crearAfp();
    this.renta = salarioImpuesto.crearRenta();
  }

  private void calcularSalarioBruto() {
    this.salarioBruto += this.salario.getSalario();
    if (horasExtras != null) {
      this.salarioHoraExtra = salarioImpuesto.crearSalarioHoraExtra(this.horasExtras);
      this.salarioBruto += this.salarioHoraExtra.getSalario();
    }
    if (salariosExtras != null) {
      Double totalSalarioExtra = 0.0;
      for (Salario salarioExtra : salariosExtras) {
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
    this.renta.calcularDeduccion(salarioPreRenta);
  }

  public static class Builder {
    private SalarioImpuestoFactory salarioImpuesto;
    private HorasExtra horasExtra;
    private ArrayList<Salario> salariosExtras;

    public Builder(SalarioImpuestoFactory salarioImpuesto) {
      this.salarioImpuesto = salarioImpuesto;
    }

    public Builder conHorasExtras(HorasExtra horasExtra) {
      this.horasExtra = horasExtra;
      return this;
    }

    public Builder conSalariosExtras(ArrayList<Salario> salariosExtras) {
      this.salariosExtras = salariosExtras;
      return this;
    }

    public DeduccionSalarial construir() {
      return new DeduccionSalarial(salarioImpuesto, horasExtra, salariosExtras);
    }
  }
}
