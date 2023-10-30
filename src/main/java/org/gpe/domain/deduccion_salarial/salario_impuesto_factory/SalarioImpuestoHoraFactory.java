package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpHora;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssHora;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaHora;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorHora;

public class SalarioImpuestoHoraFactory implements SalarioImpuestoFactory {
    private SalarioMensual salarioMensual;
    private Double salario;

    public SalarioImpuestoHoraFactory(Double salario) {
        this.salario = salario;
    }
    public SalarioImpuestoHoraFactory(SalarioMensual salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public SalarioPorHora crearSalario() {
        if (salario != null) {
            return new SalarioPorHora(salario);
        }
        return new SalarioPorHora(salarioMensual);
    }

    @Override
    public SalarioHoraExtra crearSalarioHoraExtra(HorasExtra horasExtra) {
        return new SalarioHoraExtra(this.crearSalario(), horasExtra);
    }

    @Override
    public IsssHora crearIsss() {
        return new IsssHora();
    }

    @Override
    public AfpHora crearAfp() {
        return new AfpHora();
    }

    @Override
    public RentaHora crearRenta() {
        return new RentaHora();
    }
}