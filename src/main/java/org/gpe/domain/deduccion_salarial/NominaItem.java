package org.gpe.domain.deduccion_salarial;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioPorHora;

public class NominaItem {
  @Getter @Setter private Empleado empleado;
  @Getter private Salario salarioBase;
  @Getter private AsistenciaLaboral asistencia;
  @Getter private HorasExtra horasExtra;
  @Getter private SalarioHoraExtra salarioHoraExtra;
  @Getter private SalarioPorHora salarioPorHora;
  @Getter private ArrayList<SalarioExtraordinario> salariosExtras = new ArrayList<>();
  @Getter private DeduccionSalarial deduccionSalarial;

  public NominaItem(Empleado empleado, Salario salarioBase) {
    this.empleado = empleado;
    this.salarioBase = salarioBase;
    calcularDeducciones();
  }

  public NominaItem(Empleado empleado, Salario salarioBase, AsistenciaLaboral asistencia) {
    this.empleado = empleado;
    this.salarioBase = salarioBase;
    this.asistencia = asistencia;
    calcularDeducciones();
  }

  public NominaItem(
      Empleado empleado,
      Salario salarioBase,
      AsistenciaLaboral asistencia,
      SalarioPorHora salarioPorHora) {
    this.empleado = empleado;
    this.salarioBase = salarioBase;
    this.asistencia = asistencia;
    this.salarioPorHora = salarioPorHora;
    calcularDeducciones();
  }

  public NominaItem(
      Empleado empleado,
      Salario salarioBase,
      AsistenciaLaboral asistencia,
      SalarioPorHora salarioPorHora,
      ArrayList<SalarioExtraordinario> salarioExtras) {
    this.empleado = empleado;
    this.salarioBase = salarioBase;
    this.asistencia = asistencia;
    this.salarioPorHora = salarioPorHora;
    if (salarioExtras != null) {
      this.salariosExtras.addAll(salarioExtras);
    }
    calcularDeducciones();
  }

  private void calcularDeducciones() {
    if (asistencia != null) {
      this.horasExtra = new HorasExtra(asistencia);
    }
    if (salarioPorHora != null) {
      this.salarioHoraExtra = new SalarioHoraExtra(salarioPorHora, horasExtra);
      salariosExtras.add(salarioHoraExtra);
    }
    this.deduccionSalarial = new DeduccionSalarial(salarioBase, salariosExtras);
  }

  public void setSalarioBase(Salario salarioBase) {
    this.salarioBase = salarioBase;
    calcularDeducciones();
  }

  public void setAsistencia(AsistenciaLaboral asistencia) {
    this.asistencia = asistencia;
    calcularDeducciones();
  }

  public void setSalarioPorHora(SalarioPorHora salarioPorHora) {
    this.salarioPorHora = salarioPorHora;
    calcularDeducciones();
  }

  public void setSalariosExtras(ArrayList<SalarioExtraordinario> salariosExtras) {
    this.salariosExtras = salariosExtras;
    calcularDeducciones();
  }

  public static class Builder {

    private Empleado empleado;
    private Salario salarioBase;
    private AsistenciaLaboral asistencia;
    private SalarioPorHora salarioPorHora;
    private ArrayList<SalarioExtraordinario> salariosExtras = new ArrayList<>();

    public Builder(Empleado empleado, Salario salarioBase) {
      this.empleado = empleado;
      this.salarioBase = salarioBase;
    }

    public Builder conAsistencia(AsistenciaLaboral asistencia) {
      this.asistencia = asistencia;
      return this;
    }

    public Builder conAsistenciaYHorasExtras(
        AsistenciaLaboral asistencia, SalarioPorHora salarioPorHora) {
      this.asistencia = asistencia;
      this.salarioPorHora = salarioPorHora;
      return this;
    }

    public Builder agregarSalarioExtra(SalarioExtraordinario salarioExtra) {
      this.salariosExtras.add(salarioExtra);
      return this;
    }

    public Builder agregarSalarioExtra(ArrayList<SalarioExtraordinario> salariosExtras) {
      this.salariosExtras.addAll(salariosExtras);
      return this;
    }

    public NominaItem construir() {
      return new NominaItem(empleado, salarioBase, asistencia, salarioPorHora, salariosExtras);
    }
  }
}
