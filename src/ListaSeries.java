import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListaSeries implements Utilizable {
    List<Serie> lista = new ArrayList<>();

    @Override
    public String muestraTodos() {
        String salida = "Lista de películas:\n";
        for (Serie p : lista) {
            salida += p.info() + "\n";
        }
        return salida;
    }

    @Override
    public void leeDeFichero(File fichero) {
        try {
            List<String> leido = Files.readAllLines(fichero.toPath());

            String nombreSerie;
            String temporadas;
            for (String serieActual : leido) {
                nombreSerie = serieActual.substring(0, serieActual.indexOf('{'));
                temporadas = serieActual.substring(0, serieActual.indexOf('}'));
                lista.add(new Serie(nombreSerie, temporadas));
            }


        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el fichero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (StringIndexOutOfBoundsException sioobe) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el fichero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "No se ha podido leer el fichero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Serie s : lista) {
                salida.print(s.toString() + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        JFrame salida = new JFrame("Nueva serie");
        CrearSerie panel = new CrearSerie();
        JButton anyadirALista = new JButton("Crear serie");


        salida.setLayout(new BorderLayout());
        salida.setSize(420, 150);
        salida.setResizable(false);
        salida.setLocationRelativeTo(null);
        salida.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        salida.add(panel, BorderLayout.CENTER);
        anyadirALista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreSerie = panel.getNombreSerie().getText();
                    String temporadas = panel.getTemporadasSerieIntroducir().getText();
                    lista.add(new Serie(nombreSerie, temporadas));
                    salida.dispose();

                } catch (IllegalArgumentException iae) {
                    JOptionPane.showMessageDialog(null, iae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        salida.add(anyadirALista, BorderLayout.SOUTH);
        salida.setVisible(true);
    }
}

