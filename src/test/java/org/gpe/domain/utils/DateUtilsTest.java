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

    assertEquals(Dias.Lunes, DateUtils.getDayOfWeek(lunes));
    assertEquals(Dias.Martes, DateUtils.getDayOfWeek(martes));
    assertEquals(Dias.Miercoles, DateUtils.getDayOfWeek(miercoles));
    assertEquals(Dias.Jueves, DateUtils.getDayOfWeek(jueves));
    assertEquals(Dias.Viernes, DateUtils.getDayOfWeek(viernes));
    assertEquals(Dias.Sabado, DateUtils.getDayOfWeek(sabado));
    assertEquals(Dias.Domingo, DateUtils.getDayOfWeek(domingo));
  }
}
