# DP_TESTING_REFACTOR GPE Project (Gestión de Pagos a Empleados)

## Datos del estudiante:

Estudiante: José Josias Padilla Martínez

Email: josias.jjpm49@gmail.com

Repositorio: [https://github.com/JosephPM39/K_GPE](https://github.com/JosephPM39/K_GPE)

## Requerimientos

**Problema**: Tiene la tarea de diseñar un sistema de gestión de pagos para empleados. El sistema debería permitir a la empresa mantener un registro de sus empleados, incluidos los empleados a tiempo completo y parcial. También debería manejar los cálculos salariales según las leyes salvadoreñas.

1. **Registro de Empleados:**
    - Capacidad para ingresar y almacenar información detallada de cada empleado, como nombre, dirección, número de identificación, información de contacto, fecha de contratación, fecha de nacimiento, etc.
2. **Control de Asistencia y Horario Laboral:**
    - Registro de horarios de trabajo y control de asistencia de los empleados.
    - Cálculo de horas extras
3. **Gestión de Vacaciones y Ausencias:**
    - Gestión de solicitudes de vacaciones y permisos.
4. **Nómina y Remuneración:**
    - Cálculo y generación de nóminas de pago, incluyendo deducciones, impuestos y bonificaciones.
    - Formas de remuneración salarial
        1. Los salarios se deberán pagar de forma semanal, quincenal y mensual.
        2. Se admiten salarios por hora, y por día, no obstante, la suma de estos en la semana, quincena o mes, será el pago correspondiente. Con fines de simplificar las nóminas.
        3. Los salarios base serán considerados los de forma semanal, quincenal y mensual, los por hora y por día, tendrán que ser convertidos como se describe en el punto anterior.
        4. Se debe considerar la opción de agregar salarios extras que cuentan como bonos, comisiones, o incluso las mismas horas extras, los cuales se pueden sumar al salario base para formar el salario bruto.
        5. Debe existir la opción para pagar vacaciones y aguinaldos, ya sean proporcionales o completos, así como los asuetos.

## Patrones de Diseño

### Diagrama antiguo
![image](https://raw.githubusercontent.com/JosephPM39/K_GPE/main/images/project%20diagrams-GPE%20v1.png)

### Diagrama nuevo implementando DP
    - Abstract Factory
    - Factory Method
    - Strategy
    - Template Method
    - Builder
![image](https://github.com/JosephPM39/K_GPE/blob/main/images/project%20diagrams-GPE%20v5.png?raw=true)

- Problemas que soluciona
    - Se soluciona un bug con respecto al tipo de salario
    - Permite la extensibilidad al considerar una incertidumbre grande en cuanto a que tipos de salarios pueden existir, y que tipos de calculos y tributos se les podría aplicar
    - Permite una mayor simplicidad al leer el código
    - Permite tener una mejor estructura

## Testing

- Pruebas unitarias con Junit & Mockito
- Code coverage mayor al 80%
### Jacoco
![image](https://raw.githubusercontent.com/JosephPM39/K_GPE/main/images/jacoco.png)
## Intellij
![image](https://raw.githubusercontent.com/JosephPM39/K_GPE/main/images/intellij.png)

## Refactor

- Refactor de renombrado de variables, paquetes, etc.
- Refactor de simplificar expresiones booleanas.
- Refactor de eliminar código innecesario.
- Refactor de utilizar Template Method para las familias de abstract factory.
