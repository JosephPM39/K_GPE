package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpDiario;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssDiario;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaDiaria;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorDia;

public class SalarioImpuestoDiarioFactory implements SalarioImpuestoFactory {
    private SalarioMensual salarioMensual;
    private Double salario;

    public SalarioImpuestoDiarioFactory(Double salario) {
        this.salario = salario;
    }
    public SalarioImpuestoDiarioFactory(SalarioMensual salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    @Override
    public SalarioPorDia crearSalario() {
        if (salario != null) {
            return new SalarioPorDia(salario);
        }
        return new SalarioPorDia(salarioMensual);
    }

    @Override
    public SalarioHoraExtra crearSalarioHoraExtra(HorasExtra horasExtra) {
        return new SalarioHoraExtra(this.crearSalario(), horasExtra);
    }

    @Override
    public IsssDiario crearIsss() {
        return new IsssDiario();
    }

    @Override
    public AfpDiario crearAfp() {
        return new AfpDiario();
    }

    @Override
    public RentaDiaria crearRenta() {
        return new RentaDiaria();
    }
}