# ListaDeVuelos - Sistema de Filtrado de Vuelos

## Descripcion

Sistema en Java para filtrar vuelos por rango de fechas usando Streams API

## Estructura

```
- src/entities/Vuelo.java -> Entidad Vuelo con validaciones
- src/utils/FiltroVuelos.java -> Logica del filtrado
- src/Main.java - Demostracion
``` 

# Funcionalidad

- Filtrado por fechas: Soporta 4 casos (inicio nulo, fin nulo, ambos, ninguno)
- Validaciones: fechaLlegada >= fechaSalida
- Ordenamiento: Automatico por fechaSalida
- Excepciones: Manejo de nulos y fechas invalidas

## Ejecucion

Ejecuta el metodo `Main` desde tu IDE

## Salida Esperada

```
------------------------------ TODOS LOS VUELOS ------------------------------
[Muestra los 10 vuelos de prueba distribuidos en diciembre 2025, enero 2026 y febrero 2026]

----------------------- VUELOS FILTRADOS (DICIEMBRE 2025) -----------------------
[Muestra solo los vuelos que cumplen con el rango de fechas especificado]
```

## Excepciones

- `IllegalArgumentException`: Fecha llegada anterior a salida
- `NullPointerException`: Parametros nulos

## Requisitos Cumplidos

Constantes de fecha configurables  
Entidad Vuelo completa             
Filtrado por fechaSalida       
Manejo de fechas nulas    
Ordenamiento automatico   
10 vuelos de prueba  
Impresion en terminal  
Estructura de packages  
Validaciones implementadas  

## Tecnologias usadas

- JDK 21+
- Streams API
- LocalDate
- POO
- IDE: IntelliJ

