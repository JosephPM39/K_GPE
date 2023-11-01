package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.AfpMensual;
import org.gpe.domain.deduccion_salarial.impuestos.isss.IsssMensual;
import org.gpe.domain.deduccion_salarial.impuestos.renta.RentaMensual;
import org.gpe.domain.salario.SalarioHoraExtra;
import org.gpe.domain.salario.SalarioMensual;

public class SalarioImpuestoMensualFactory implements SalarioImpuestoFactory {
    @Override
    public IsssMensual crearIsss() {
       return new IsssMensual();
    }

    @Override
    public AfpMensual crearAfp() {
        return new AfpMensual();
    }

    @Override
    public RentaMensual crearRenta() {
        return new RentaMensual();
    }
}