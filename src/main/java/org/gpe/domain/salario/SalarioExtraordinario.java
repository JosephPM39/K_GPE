package org.gpe.domain.salario;

import org.gpe.domain.deduccion_salarial.salario_impuesto_factory.SalarioImpuestoFactory;

public interface SalarioExtraordinario {
    public Double getSalario();
    public SalarioImpuestoFactory getSalarioImpuesto();
}
