package org.gpe.domain.horario;

import java.util.EnumMap;
import lombok.Getter;
import org.gpe.domain.utils.Dias;

public class HorarioSemanal extends Horario {

  @Getter private final EnumMap<Dias, HorarioDiario> horario = new EnumMap<>(Dias.class);

  public HorarioSemanal(String nombre, String descripcion) {
    super(nombre, descripcion);
  }

  public void eliminarHorario(Dias dia) {
    horario.remove(dia);
  }

  public void agregarOSustituirHorario(Dias dia, HorarioDiario horarioDiario) {
    horario.put(dia, horarioDiario);
  }
}
