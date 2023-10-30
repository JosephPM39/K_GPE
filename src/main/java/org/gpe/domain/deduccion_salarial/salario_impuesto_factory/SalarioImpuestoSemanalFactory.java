package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpSemanal;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssSemanal;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaSemanal;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorSemana;

public class SalarioImpuestoSemanalFactory implements SalarioImpuestoFactory {
    private SalarioMensual salarioMensual;
    private Double salario;

    public SalarioImpuestoSemanalFactory(Double salario) {
        this.salario = salario;
    }
    public SalarioImpuestoSemanalFactory(SalarioMensual salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public SalarioPorSemana crearSalario() {
        if (salario != null) {
            return new SalarioPorSemana(salario);
        }
        return new SalarioPorSemana(salarioMensual);
    }

    @Override
    public SalarioHoraExtra crearSalarioHoraExtra(HorasExtra horasExtra) {
        return new SalarioHoraExtra(this.crearSalario(), horasExtra);
    }

    @Override
    public IsssSemanal crearIsss() {
        return new IsssSemanal();
    }

    @Override
    public AfpSemanal crearAfp() {
        return new AfpSemanal();
    }

    @Override
    public RentaSemanal crearRenta() {
        return new RentaSemanal();
    }
}