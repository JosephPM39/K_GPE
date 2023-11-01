package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpSemanal;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssSemanal;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaSemanal;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;
import org.gpe.domain.salario.SalarioPorSemana;

public class SalarioImpuestoSemanalFactory implements SalarioImpuestoFactory {
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