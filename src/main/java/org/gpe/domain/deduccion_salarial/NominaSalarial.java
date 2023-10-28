package org.gpe.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.gpe.domain.asistencia.AsistenciaLaboral;
import org.gpe.domain.empleado.Empleado;
import org.gpe.domain.salario.Salario;

public class NominaSalarial {
  @Getter @Setter private Empleado empleado;
  @Getter @Setter private Salario salario;
  @Getter @Setter private AsistenciaLaboral asistenciaLaboral;
  @Getter @Setter private DeduccionSalarial deduccionSalarial;
  @Getter @Setter private String vigencia;
}
