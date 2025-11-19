package entities;
import java.time.LocalDate;
import java.util.Objects;

public class Vuelo implements Comparable<Vuelo>{
    ///  En esta clase vamos con el objetivo de representar los vuelos con todos sus datos y validaciones basicas ///

    private final int id;
    private final String nombreVuelo;
    private final String empresa;
    private final String lugarSalida;
    private final String lugarLlegada;
    private final LocalDate fechaSalida;
    private final LocalDate fechaLlegada;

    public Vuelo(int id, String nombreVuelo, String empresa, String lugarSalida, String lugarLlegada, LocalDate fechaSalida,
                 LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = Objects.requireNonNull(nombreVuelo, "El nombre del vuelo no puede ser nulo");
        this.empresa = Objects.requireNonNull(empresa, "El nombre de la empresa no puede ser nula");
        this.lugarSalida = Objects.requireNonNull(lugarSalida, "El lugar de salida no puede ser nulo");
        this.lugarLlegada = Objects.requireNonNull(lugarLlegada, "El lugar de llegada no puede ser nulo");
        this.fechaSalida = Objects.requireNonNull(fechaSalida, "La fecha de salida no puede ser nula");
        this.fechaLlegada = Objects.requireNonNull(fechaLlegada, "La fecha de llegada no puede ser nula");

        //aqui aplicare una validacion para asegurar que la llegada no sea antes de la salida
        if (fechaLlegada.isBefore(fechaSalida)){
            throw new IllegalArgumentException("La fecha de llegada no puede ser anterior a la de salida");
        }
    }


/// Aqui dejo el return al lado de cada getter para no ocupar tantas lineas, solo es cuestion estetica ////
    public int getId() { return id; }
    public String getNombreVuelo() { return nombreVuelo; }
    public String getEmpresa() { return empresa; }
    public String getLugarSalida() { return lugarSalida; }
    public String getLugarLlegada() { return lugarLlegada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public LocalDate getFechaLlegada() { return fechaLlegada; }

    // aqui aplicamos una representacion del vuelo
    /// Dato: aqui implementare el %s esto es un marcador para insertar textos, basicamente cada %s lo reemplaza por el valor q tenga ////
    @Override
    public String toString(){
        return String.format("Vuelo %s (%s) - %s a %s (%s - %s)",
        nombreVuelo, empresa, lugarSalida, lugarLlegada, fechaSalida, fechaLlegada);
    }

    // aqui aplicamos un orden natural por fecha de salida (lo usaremos en el filtrado de Comparable al inicio de la clase)
    @Override
    public int compareTo(Vuelo otro){
        return this.fechaSalida.compareTo(otro.fechaSalida);
    }

    // aqui aplico una igualdad que se base en los id (lo puedo hacer sin esto, pero es util para cuando se usa collections)
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass()
                != o.getClass())
            return false;
        Vuelo vuelo = (Vuelo) o;
        return id == vuelo.id;
    }

    // aqui aplicare estos metodos para usarlos en collections (HashMap || HashSet)
    /// DATO: un hashcode es el metodo que devuelve un nro entero unico para cada object ///
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
