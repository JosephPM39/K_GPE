package org.gpe.domain.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

  private DateUtils() {}
  public static Dias getDayOfWeek(LocalDate date) {
    if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
      return Dias.LUNES;
    }
    if (date.getDayOfWeek() == DayOfWeek.TUESDAY) {
      return Dias.MARTES;
    }
    if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
      return Dias.MIERCOLES;
    }
    if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
      return Dias.JUEVES;
    }
    if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
      return Dias.VIERNES;
    }
    if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
      return Dias.SABADO;
    }
    if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
      return Dias.DOMINGO;
    }
    return null;
  }
}
