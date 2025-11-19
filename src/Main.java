import entities.Vuelo;
import utils.FiltroVuelos;
import java.time.LocalDate;
import java.util.List;

public class Main {
    //aqui dejo algunas fechas para filtrar (la cual en este caso va a ser las de diciembre pero pueden ser null para probar diferentes casos)
    private static final LocalDate FECHA_INICIO = LocalDate.of(2025, 12, 1);
    private static final LocalDate FECHA_FIN = LocalDate.of(2025, 12, 31);

    public static void main(String[] args) {
        //aqui creare una lista de vuelos de prueba, filters en si y filters por rango de fecha,
        // tambien exceptions como algun error y que los muestre la lista de todos los vuelos
        try {
            List<Vuelo> vuelos = vuelosDePrueba();
            System.out.println("------------------------------ TODOS LOS VUELOS ------------------------------");
            System.out.println();
            vuelos.forEach(System.out::println);

            /// Dato: aqui uso el ? ya que es una forma abreviada de escribir if-else en java ///
            System.out.println("\n----------------------- VUELOS FILTRADOS (DICIEMBRE 2025) -----------------------");
            System.out.printf("Filtro aplicado: desde %s hasta %s%n%n",
                    FECHA_INICIO != null ? FECHA_INICIO : "sin limite",
                    FECHA_FIN != null ? FECHA_FIN : "sin limite");

            List<Vuelo> vuelosFiltrados = FiltroVuelos.filtrarVuelos(vuelos, FECHA_INICIO, FECHA_FIN);
            if (vuelosFiltrados.isEmpty()) {
                System.out.println("No se encontraron vuelos en el rango especificado.");
            } else {
                vuelosFiltrados.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Se produjo un error: " + e.getMessage());
        }
    }

    //aqui estarian los metodos de prueba
    private static List<Vuelo> vuelosDePrueba() {
        return List.of(
                //aqui estarian los vuelos de diciembre 2025
                new Vuelo(1, "VL101", "LATAM Airlines", "Santiago De Chile (SCL)", "Madrid (MAD)",
                        LocalDate.of(2025, 12, 15), LocalDate.of(2025, 12, 16)),
                new Vuelo(2, "VL102", "American Airlines", "Miami (MIA)", "Nueva York (JFK)",
                        LocalDate.of(2025, 12, 20), LocalDate.of(2025, 12, 20)),

                //aqui estarian los vuelos de enero 2026
                new Vuelo(3, "VL103", "Iberia", "Madrid (MAD)", "Buenos Aires (EZE)",
                        LocalDate.of(2026, 1, 5), LocalDate.of(2026, 1, 6)),
                new Vuelo(4, "VL104", "Avianca", "Bogota (BOG)", "Ciudad de Mexico (MEX)",
                        LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 10)),
                new Vuelo(5, "VL105", "Delta", "Atlanta (ATL)", "Roma (FCO)",
                        LocalDate.of(2026, 1, 15), LocalDate.of(2026, 1, 16)),
                new Vuelo(6, "VL106", "Emirates", "Dubai (DXB)", "Nueva York (JFK)",
                        LocalDate.of(2026, 1, 19), LocalDate.of(2026, 1, 20)),
                new Vuelo(7, "VL107", "ITA Airways", "Roma (FCO)", "Paris (CDG)",
                        LocalDate.of(2026, 1, 25), LocalDate.of(2026, 1, 25)),

                //aqui estarian los vuelos de febrero 2026
                new Vuelo(8, "VL108", "Virgin Atlantic", "Londres (LHR)", "Miami (MIA)",
                        LocalDate.of(2026, 2, 5), LocalDate.of(2026, 2, 5)),
                new Vuelo(9, "VL109", "Turkish Airlines", "Estambul (IST)", "Caracas (CCS)",
                        LocalDate.of(2026, 2, 9), LocalDate.of(2026, 2, 10)),
                new Vuelo(10, "VL110", "Copa Airlines", "Ciudad de Panama (PTY)", "Lima (LIM)",
                        LocalDate.of(2026, 2, 15), LocalDate.of(2026, 2, 15))
        );
    }
}