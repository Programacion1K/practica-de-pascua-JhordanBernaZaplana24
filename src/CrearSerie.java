import javax.swing.*;
import java.awt.*;

public class CrearSerie extends JPanel {

    private JLabel nombreSerie = new JLabel("Nombre de la serie");
    private JTextField serieIntroducir = new JTextField();

    private JLabel temporadasSerie = new JLabel("Temporadas de la serie");
    private JTextField temporadasSerieIntroducir = new JTextField();


    CrearSerie() {
        setLayout(new GridLayout(2, 2));
        add(nombreSerie);
        add(serieIntroducir);
        add(temporadasSerie);
        add(temporadasSerieIntroducir);
    }

    public JTextField getNombreSerie() {
        return serieIntroducir;
    }

    public JTextField getTemporadasSerieIntroducir() {
        return temporadasSerieIntroducir;
    }
}
