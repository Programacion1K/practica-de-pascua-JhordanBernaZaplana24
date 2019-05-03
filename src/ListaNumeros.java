import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListaNumeros implements Utilizable {
    List<Integer> lista = new ArrayList<>();

    @Override
    public String muestraTodos() {
        return lista.stream().map(Objects::toString).collect(Collectors.joining(", "));
    }

    @Override
    public void leeDeFichero(File nombreFichero) {
        try {
            List<String> listaLeida = Files.readAllLines(nombreFichero.toPath());
            lista = listaLeida.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardaEnFichero(File nombreFichero) {
        try (PrintWriter out = new PrintWriter(nombreFichero)) {
            out.print(lista.stream().map(Objects::toString).collect(Collectors.joining("\n")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        lista.add(Integer.parseInt(JOptionPane.showInputDialog(null, "¿Número a añadir?")));


    }

}
