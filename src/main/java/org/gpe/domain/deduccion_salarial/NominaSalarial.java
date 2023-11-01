package org.gpe.domain.deduccion_salarial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class NominaSalarial {
  @Getter @Setter private String vigencia;
  private ArrayList<NominaItem> registros = new ArrayList<>();

  public Boolean agregarRegistro(NominaItem registro) {
    return this.registros.add(registro);
  }

  public Boolean removerRegistro(String identificacion) {
    NominaItem registro = buscarRegistro(identificacion);
    if (registro != null) {
      return this.registros.remove(registro);
    }
    return false;
  }

  public NominaItem buscarRegistro(String identificacion) {
    for (NominaItem registro: registros) {
       if (registro.getEmpleado().getIdenticicacion().equals(identificacion)) {
          return registro;
       }
    }
    return null;
  }

}
