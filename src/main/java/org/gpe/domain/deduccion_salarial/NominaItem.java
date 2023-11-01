package org.gpe.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioExtraordinario;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioPorHora;

import java.util.ArrayList;

public class NominaItem {
    @Getter @Setter
    private Empleado empleado;
    @Getter @Setter
    private Salario salarioBase;
    @Getter @Setter
    private AsistenciaLaboral asistencia;
    @Getter @Setter
    private HorasExtra horasExtra;
    @Getter
    private SalarioHoraExtra salarioHoraExtra;
    @Getter @Setter
    private SalarioPorHora salarioPorHora;
    @Getter @Setter
    private ArrayList<SalarioExtraordinario> salariosExtras = new ArrayList<>();
    @Getter @Setter
    private DeduccionSalarial deduccionSalarial;

    public NominaItem(Empleado empleado, Salario salarioBase) {
        this.empleado = empleado;
        this.salarioBase = salarioBase;
    }
    public NominaItem(Empleado empleado, Salario salarioBase, AsistenciaLaboral asistencia) {
        this.empleado = empleado;
        this.salarioBase = salarioBase;
        this.asistencia = asistencia;
    }
    public NominaItem(Empleado empleado, Salario salarioBase, AsistenciaLaboral asistencia, SalarioPorHora salarioPorHora) {
        this.empleado = empleado;
        this.salarioBase = salarioBase;
        this.asistencia = asistencia;
        this.salarioPorHora = salarioPorHora;
    }
    public NominaItem(Empleado empleado, Salario salarioBase, AsistenciaLaboral asistencia, SalarioPorHora salarioPorHora, ArrayList<SalarioExtraordinario> salarioExtras) {
        this.empleado = empleado;
        this.salarioBase = salarioBase;
        this.asistencia = asistencia;
        this.salarioPorHora = salarioPorHora;
        if (salarioExtras != null) {
            this.salariosExtras.addAll(salarioExtras);
        }
    }

    public void calcularDeducciones() {
        if (salarioPorHora != null) {
            this.salarioHoraExtra = new SalarioHoraExtra(salarioPorHora, horasExtra);
            this.salariosExtras = new ArrayList<>();
        }
        this.deduccionSalarial = new DeduccionSalarial.Builder(salarioBase).conSalariosExtraordinarios(salariosExtras).construir();
    }

    static public class Builder {

        private Empleado empleado;
        private Salario salarioBase;
        private AsistenciaLaboral asistencia;
        private SalarioPorHora salarioPorHora;
        private ArrayList<SalarioExtraordinario> salariosExtras;
        public Builder(Empleado empleado, Salario salarioBase) {
           this.empleado = empleado;
           this.salarioBase = salarioBase;
        }

        public Builder conAsistencia(AsistenciaLaboral asistencia) {
            this.asistencia = asistencia;
            return this;
        }

        public Builder conAsistenciaYHorasExtras(AsistenciaLaboral asistencia, SalarioPorHora salarioPorHora) {
            this.asistencia = asistencia;
            this.salarioPorHora = salarioPorHora;
            return this;
        }

        public Builder conSalariosExtraordinarios(ArrayList<SalarioExtraordinario> salariosExtras) {
           this.salariosExtras = salariosExtras;
           return this;
        }

        public NominaItem construir() {
            return new NominaItem(empleado, salarioBase, asistencia, salarioPorHora, salariosExtras);
        }
    }

}
