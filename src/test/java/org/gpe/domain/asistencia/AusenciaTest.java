package org.gpe.domain.asistencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AusenciaTest {

  Ausencia ausencia;

  @BeforeEach
  void setUp() {
    ausencia = new Ausencia();
  }

  @AfterEach
  void tearDown() {
    ausencia = null;
  }

  @Test
  void getMotivo() {
    Ausencia ausencia = new Ausencia("Desconocido", "No aprobado");
    assertEquals("Desconocido", ausencia.getMotivo());
  }

  @Test
  void getEstadoAprobacion() {
    Ausencia ausencia = new Ausencia("Desconocido", "No aprobado");
    assertEquals("No aprobado", ausencia.getEstadoAprobacion());
  }

  @Test
  void setMotivo() {
    ausencia.setMotivo("Salud");
    assertEquals("Salud", ausencia.getMotivo());
  }

  @Test
  void setEstadoAprobacion() {
    ausencia.setEstadoAprobacion("Aprobado");
    assertEquals("Aprobado", ausencia.getEstadoAprobacion());
  }
}
