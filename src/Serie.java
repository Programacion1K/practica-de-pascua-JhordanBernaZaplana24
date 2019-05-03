import java.util.Objects;

public class Serie {
    private final String nombre;
    private String temporadas;

    public Serie(String nombre, String temporadas) {
        this.nombre = nombre;
        this.temporadas = temporadas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTemporadas() {
        return temporadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nombre, serie.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nombre='" + nombre + '\'' +
                ", temporadas=" + temporadas +
                '}';
    }

    public String info() {
        return "La serie " + this.nombre + ", tiene una duración de " + this.temporadas + " temporadas";
    }
}