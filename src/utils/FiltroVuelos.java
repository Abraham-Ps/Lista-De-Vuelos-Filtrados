package utils;
import entities.Vuelo;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class FiltroVuelos {
    private FiltroVuelos(){}

    // aqui aplico un filtro de vuelos por el rango de las fechas de salidas
    public static List<Vuelo> filtrarVuelos(List<Vuelo> vuelos, LocalDate fechaInicio, LocalDate fechaFin){

        // aqui validamos que la lista de vuelos no sea nula
        Objects.requireNonNull(vuelos, "La lista de vuelos no puede ser nula");
        return vuelos.stream()
                .filter(v -> cumpleFiltroFecha(v.getFechaSalida(), fechaInicio, fechaFin))
                .sorted()
                .toList();
    }

    // aqui aplico un metodo auxiliar para validar si las fechas estan en el rango
    private static boolean cumpleFiltroFecha(LocalDate fechaVuelo, LocalDate fechaInicio, LocalDate fechaFin) {
        //aqui si no hay fecha de inicio, se considera como si fuera desde el principio
        boolean cumpleInicio = fechaInicio == null || !fechaVuelo.isBefore(fechaInicio);
        boolean cumpleFin = fechaFin == null || !fechaVuelo.isAfter(fechaFin);
        return cumpleInicio && cumpleFin;

    }
}
