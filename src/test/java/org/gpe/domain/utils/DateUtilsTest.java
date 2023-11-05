package org.gpe.domain.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class DateUtilsTest {
  @Test
  void getDayOfWeekLunes() {
    LocalDate lunes = LocalDate.of(2023, 11, 6);
    LocalDate martes = LocalDate.of(2023, 11, 7);
    LocalDate miercoles = LocalDate.of(2023, 11, 8);
    LocalDate jueves = LocalDate.of(2023, 11, 9);
    LocalDate viernes = LocalDate.of(2023, 11, 10);
    LocalDate sabado = LocalDate.of(2023, 11, 11);
    LocalDate domingo = LocalDate.of(2023, 11, 12);

    assertEquals(Dias.LUNES, DateUtils.getDayOfWeek(lunes));
    assertEquals(Dias.MARTES, DateUtils.getDayOfWeek(martes));
    assertEquals(Dias.MIERCOLES, DateUtils.getDayOfWeek(miercoles));
    assertEquals(Dias.JUEVES, DateUtils.getDayOfWeek(jueves));
    assertEquals(Dias.VIERNES, DateUtils.getDayOfWeek(viernes));
    assertEquals(Dias.SABADO, DateUtils.getDayOfWeek(sabado));
    assertEquals(Dias.DOMINGO, DateUtils.getDayOfWeek(domingo));
  }
}
