package org.gpe.domain.asistencia;

import org.junit.jupiter.api.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class AsistenciaTest {

    static Asistencia asistencia;

    @BeforeAll
    static void setUp() {
        LocalTime entrada = LocalTime.of(7, 0);
        LocalTime salida = LocalTime.of(12, 0);
        asistencia = new Asistencia(entrada, salida);
    }

    @AfterAll
    static void tearDown() {
        asistencia = null;
    }

    @Test
    void getHoraEntrada() {
        LocalTime entrada = LocalTime.of(7, 0);
        assertEquals(entrada, asistencia.getHoraEntrada());
      }

    @Test
    void getHoraSalida() {
        LocalTime salida = LocalTime.of(12, 0);
        assertEquals(salida, asistencia.getHoraSalida());
    }

    @Test
    void setHoraEntrada() {
        LocalTime entrada = LocalTime.of(7, 0);
        asistencia.setHoraEntrada(entrada);
        assertEquals(entrada, asistencia.getHoraEntrada());
      }

    @Test
    void setHoraSalida() {
        LocalTime salida = LocalTime.of(12, 0);
        asistencia.setHoraSalida(salida);
        assertEquals(salida, asistencia.getHoraSalida());
      }
}