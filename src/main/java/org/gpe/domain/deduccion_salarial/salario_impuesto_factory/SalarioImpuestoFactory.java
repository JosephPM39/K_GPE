package org.gpe.domain.deduccion_salarial.salario_impuesto_factory;

import org.gpe.domain.asistencia.HorasExtra;
import org.gpe.domain.deduccion_salarial.impuestos.afp.Afp;
import org.gpe.domain.deduccion_salarial.impuestos.isss.Isss;
import org.gpe.domain.deduccion_salarial.impuestos.renta.Renta;
import org.gpe.domain.salario.Salario;
import org.gpe.domain.salario.SalarioHoraExtra;

public interface SalarioImpuestoFactory {
    public Renta crearRenta();
    public Salario crearSalario();
    public SalarioHoraExtra crearSalarioHoraExtra(HorasExtra horasExtra);
    public Afp crearAfp();
    public Isss crearIsss();
}
