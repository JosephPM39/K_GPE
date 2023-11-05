package org.gpe.domain.horario;

import java.util.HashMap;
import lombok.Getter;
import org.gpe.domain.utils.Dias;

public class HorarioSemanal extends Horario {

  @Getter private HashMap<Dias, HorarioDiario> horario = new HashMap<>();

  public HorarioSemanal(String nombre, String descripcion) {
    super(nombre, descripcion);
    this.horario = horario;
  }

  public boolean eliminarHorario(Dias dia) {
    if (horario.containsKey(dia)) {
      horario.remove(dia);
      return true;
    } else {
      return false;
    }
  }

  public void agregarOSustituirHorario(Dias dia, HorarioDiario horarioDiario) {
    horario.put(dia, horarioDiario);
  }
}
