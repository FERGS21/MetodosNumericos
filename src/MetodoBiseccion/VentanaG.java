package MetodoBiseccion;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class VentanaG extends JFrame {

    JPanel a;

    VentanaG() {
        setSize(650, 500);//500,350
        setTitle("Grafica");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container Contenedor = getContentPane();
        Graficador mipanel = new Graficador(Contenedor);

        this.add(mipanel);

        setVisible(true);

    }
}
