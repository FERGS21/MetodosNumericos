package MetodoBiseccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import org.nfunk.jep.*;
import org.nfunk.jep.type.*;
import org.lsmp.djep.djep.DJep;

public class Graficador extends JPanel {
 
    private JEP miEvaluador, miEvaluadorDerivadas;
    private DJep miEvaluador2;
    Node nodin;
    boolean errorEnExpresion; //si hay error de sintaxis en la función
    boolean errorEnNumero; //si hay error de sintaxis en la función

   

    //CAMPOS DE TEXTO
    JTextField campoFuncion;
    JTextField campoIntervaloA, campoIntervaloB;
    JTextField campoNoPuntos;
    JTextField campoNumeroDeInteraciones;

    JLabel Mensaje;
    JScrollPane scrollPane;
    JList listBusca;
    DefaultListModel listModel;

    //BOTONES
    JButton BtnGraficar;
    JButton botonMetodo1;
    JButton btnsalir;
    int puntosInt;

    //PANELES
    //JPanel panelEscalas; //Panel para las escalas
    JPanel panelGrafico; //Aqu’ va la Zona grafica
    JPanel panelControles; //panel para botones y campos de texto,etc
    JPanel panelBotones;//
    JPanel DisplayPanel1 = new JPanel(); //Panel grande para la grafica
    JPanel DisplayPanel2 = new JPanel(); //panel grande para todos los controles

    JFrame fFrame; //ventana de ayuda

    int Galto, Gancho;       //dimesiones de la zona de graficación
    int x0, y0;           //origen
    int escalaX, escalaY;
    int aumento1, aumento2;
    int intervaloA, intervaloB;
    int numeroDeInteraciones;
    double xmin, xmax, imgx;

    //VARIABLES PARA GROSOR DE LAS LINEAS
    final static BasicStroke grosor1 = new BasicStroke(1.5f); //thickness
    final static float dash1[] = {5.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            5.0f, dash1, 0.0f);
    ImageIcon imageIcon;

    public Graficador(Container Contenedor) {
        imageIcon = new ImageIcon(getClass().getResource("background.jpg"));  //imagen de fondo

        //= BOTONES
        BtnGraficar = new JButton("Graficar");
        botonMetodo1 = new JButton("Simulacion de Iteraciones");
        btnsalir = new JButton ("Salir");


        campoIntervaloA = new JTextField("", 3);
        campoIntervaloB = new JTextField("", 3);
        campoNumeroDeInteraciones = new JTextField("100", 3);
        campoNoPuntos = new JTextField("99", 3);
        campoFuncion = new JTextField("", 15);//x^3+2x^2+7x-20//cos(x)


        Mensaje = new JLabel("", JLabel.LEFT);

        listModel = new DefaultListModel();
        listBusca = new JList(listModel);

        Gancho = 650 - 10;
        Galto = 70 * 490 / 100;

        panelGrafico = new ZonaGrafica(); //zona grafica
        panelControles = new JPanel();

        scrollPane = new JScrollPane(panelGrafico);///////

        DisplayPanel1.setLayout(new BorderLayout());
        DisplayPanel1.add(scrollPane, BorderLayout.CENTER);//panelGrafico

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1));
        panelBotones.add(botonMetodo1);
        panelBotones.add(btnsalir);

        panelControles.setLayout(new GridLayout(4, 2));
        panelControles.add(campoFuncion);
        panelControles.add(BtnGraficar);
        panelControles.add(Mensaje);

        JPanel miniPanelintervalos = new JPanel();//mini panel para intervalos a y b
        JLabel etiquetaA = new JLabel("xi: ");
        JLabel etiquetaB = new JLabel("xu: ");
        JLabel etiquetaNumPuntos = new JLabel("N. de puntos: ");
        miniPanelintervalos.setLayout(new GridLayout(1, 6));
        miniPanelintervalos.add(etiquetaA);
        miniPanelintervalos.add(campoIntervaloA);
        miniPanelintervalos.add(etiquetaB);
        miniPanelintervalos.add(campoIntervaloB);
        miniPanelintervalos.add(etiquetaNumPuntos);
        miniPanelintervalos.add(campoNoPuntos);
        panelControles.add(miniPanelintervalos);


        JPanel miniPanelNumPuntos = new JPanel();
        panelControles.add(miniPanelNumPuntos);
        DisplayPanel1.setPreferredSize(new Dimension(Gancho, Galto - 20));

        DisplayPanel2.setLayout(new BorderLayout(1, 1));
        DisplayPanel2.add("Center", panelControles);
        DisplayPanel2.add("West", panelBotones);

        Contenedor.setLayout(new BorderLayout());
        Contenedor.add("North", DisplayPanel1);
        Contenedor.add("South", DisplayPanel2);

        //EVALUADOR DE FUNCIONES
        miEvaluador = new JEP();
        miEvaluador.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluador.addStandardConstants();
        miEvaluador.addComplex();
        miEvaluador.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluador.addVariable("x", 0);
        miEvaluador.setImplicitMul(true); //permite 2x en vez de 2*x

        miEvaluadorDerivadas = new JEP();
        miEvaluadorDerivadas.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluadorDerivadas.addStandardConstants();
        miEvaluadorDerivadas.addComplex();
        miEvaluadorDerivadas.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluadorDerivadas.addVariable("x", 0);
        miEvaluadorDerivadas.setImplicitMul(true); //permite 2x en vez de 2*x

        miEvaluador2 = new DJep();
        miEvaluador2.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluador2.addStandardConstants();
        miEvaluador2.addComplex();
        miEvaluador2.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluador2.addVariable("x", 0);
        miEvaluador2.setImplicitMul(true); //permite 2x en vez de 2*x
        miEvaluador2.setAllowUndeclared(true);
        miEvaluador2.setAllowAssignment(true);
        miEvaluador2.addStandardDiffRules();

        escalaX = 30;
        escalaY = 30;
        x0 = Gancho / 2;
        y0 = Galto / 2;
        aumento1 = 7;

        ManejadorDeEvento ManejadorDevt = new ManejadorDeEvento();
        campoFuncion.addActionListener(ManejadorDevt);
        BtnGraficar.addActionListener(ManejadorDevt);
        campoIntervaloA.addActionListener(ManejadorDevt);
        campoIntervaloB.addActionListener(ManejadorDevt);
        campoNoPuntos.addActionListener(ManejadorDevt);
        btnsalir.addActionListener(ManejadorDevt);

        botonMetodo1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                listModel.clear();
                Biseccion animacion1 = new Biseccion();
                animacion1.start();
                panelGrafico.repaint();
            }
        });
        
               
    }//

//////// CLASE PARA EL MANEJO DE LOS EVENTOS ///////////////////////////////////
    private class ManejadorDeEvento implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            Object source = evt.getSource();
            //ACTUALIZA LA GRAFICA SI SE OPROME UN BOTON O ENTER EN UN CAMPO DE TEXTO
            if (source == BtnGraficar || source == campoFuncion || source == campoIntervaloA || source == campoIntervaloB || source == campoNoPuntos) {
                panelGrafico.repaint();
            }
            else if(source == btnsalir)
            {
               // VentanaPrincipal vp = new VentanaPrincipal();
               // vp.setVisible(true);
                
            }
  
        }
    }//


/////// CLASE QUE DE LA ZONA GRçFICA ///////////////////////////////////////////
    public class ZonaGrafica extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

        int offsetX, offsetY;
        boolean dragging;

        ZonaGrafica() {
            setBackground(Color.white);
            offsetX = x0;
            offsetY = y0;
            addMouseListener(this);
            addMouseMotionListener(this);
            addMouseWheelListener(this);
        }

        public void mousePressed(MouseEvent evt) {
            if (dragging) {
                return;
            }
            int x = evt.getX();  // clic inicial
            int y = evt.getY();
            offsetX = x - x0;
            offsetY = y - y0;
            dragging = true;
        }

        public void mouseReleased(MouseEvent evt) {
            dragging = false;
            repaint();
        }

        public void mouseDragged(MouseEvent evt) {
            if (dragging == false) {
                return;
            }
            int x = evt.getX();   // posici—n del mouse
            int y = evt.getY();
            x0 = x - offsetX;     // mover origen
            y0 = y - offsetY;
            repaint();
        }

        public void mouseWheelMoved(MouseWheelEvent evt) {
            int zoom = evt.getWheelRotation();
            escalaY += -zoom;
            escalaX += -zoom;
            repaint();
        }

        //el resto hace nada 
        public void mouseMoved(MouseEvent evt) {
        }

        public void mouseClicked(MouseEvent evt) {
        }

        public void mouseEntered(MouseEvent evt) {
        }

        public void mouseExited(MouseEvent evt) {
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graficar(g, x0, y0);
        }

        //METODO QUE PINTA TODA LA GRçFICA
        void Graficar(Graphics ap, int xg, int yg) {
            ap.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
            //setBackground(new Color(36,85,102)); //COLOR FONDO/////////////////////////////////////////////////
            int xi = 0, yi = 0, xi1 = 0, yi1 = 0, numPuntos = 1;
            int cxmin, cxmax, cymin, cymax;
            double valxi = 0.0, valxi1 = 0.0, valyi = 0.0, valyi1 = 0.0;
            Thread animation;

            //convertimos el objeto ap en un objeto Graphics2D para usar los mŽtodos Java2D
            Graphics2D g = (Graphics2D) ap;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



            //PINTAMOS EL EJE X Y EL EJE Y
            g.draw(new Line2D.Double(xg, 10, xg, Galto - 10)); //EJE Y
            g.draw(new Line2D.Double(10, yg, Gancho - 10, yg));//EJE X

            xmin = -1.0 * xg / escalaX;
            xmax = (1.0 * (Gancho - xg) / escalaX);
            cxmin = (int) Math.round(xmin); //pantalla
            cxmax = (int) Math.round(xmax);

            if (campoIntervaloA.getText().equals("")) {
                intervaloA = cxmin;
            } else {
                intervaloA = Integer.parseInt(campoIntervaloA.getText());
            }

            if (campoIntervaloB.getText().equals("")) {
                intervaloB = cxmax;
            } else {
                intervaloB = Integer.parseInt(campoIntervaloB.getText());
            }

            puntosInt = Integer.parseInt(campoNoPuntos.getText());
            //intervalos para pintar funci—n
            cymin = (int) Math.round(1.0 * (yg - Galto) / escalaY);
            cymax = (int) Math.round(1.0 * yg / escalaY);

            numPuntos = Gancho; //num pixels

            g.setPaint(new Color(49, 173, 215)); //COLOR CUADRICULA


            //PINTAMOS TODOS LOS EJES PARA FORMAR LA CUADRICULA
            if (escalaX > 5) {
                for (int i = cxmin; i <= cxmax; i++) {   //EJES PARALELOS AL EJE Y
                    g.setPaint(new Color(49, 173, 215)); //COLOR CUADRICULA
                    g.draw(new Line2D.Double(xg + i * escalaX, yg - 2, xg + i * escalaX, yg + 2));
                    if ((xg + i * escalaX) != xg) {
                        g.draw(new Line2D.Double(xg + i * escalaX, 10, xg + i * escalaX, Galto - 10));
                    }

                    if (i > 0) {
                        g.setPaint(new Color(255, 255, 255));//COLOR NUMEROS
                        g.drawString("" + i, xg + i * escalaX - aumento1, yg + 12);
                    }
                    if (i < 0) {
                        g.setPaint(new Color(255, 255, 255));//COLOR NUMEROS
                        g.drawString("" + i, xg + i * escalaX - 8, yg + 12);
                    }
                }
            }

            if (escalaY > 5) {
                for (int i = cymin + 1; i < cymax; i++) {   //EJES PARALELOS AL EJE X
                    g.setPaint(new Color(49, 173, 215)); //COLOR CUADRICULA
                    g.draw(new Line2D.Double(xg - 2, yg - i * escalaY, xg + 2, yg - i * escalaY));
                    if ((yg - i * escalaY) != yg) {
                        g.draw(new Line2D.Double(10, yg - i * escalaY, Gancho - 10, yg - i * escalaY));
                    }
                    if (i > 0) {
                        g.setPaint(new Color(255, 255, 255));//COLOR NUMEROS
                        g.drawString("" + i, xg - 12, yg - i * escalaY + 8);
                    }
                    if (i < 0) {
                        g.setPaint(new Color(255, 255, 255));//COLOR NUMEROS
                        g.drawString("" + i, xg - 14, yg - i * escalaY + 8);
                    }
                }
            }

            g.setPaint(new Color(29, 220, 248));//COLOR DE LA FUNCION

            g.setStroke(grosor1);

            miEvaluador.parseExpression(campoFuncion.getText());
            errorEnExpresion = miEvaluador.hasError(); //hay error?

            String derivada = "";

            if (!errorEnExpresion) {
                
                campoFuncion.setForeground(Color.black);

                //CICLO QUE PINTA LA FUNCIîN
                for (int i = (xg + intervaloA * escalaX); i < (xg + intervaloB * escalaY) - 1; i++)//numPuntos
                {
                    valxi = xmin + i * 1.0 / escalaX;
                    valxi1 = xmin + (i + 1) * 1.0 / escalaX;
                    miEvaluador.addVariable("x", valxi);
                    valyi = miEvaluador.getValue();
                    miEvaluador.addVariable("x", valxi1);
                    valyi1 = miEvaluador.getValue();
                    xi = (int) Math.round(escalaX * (valxi));
                    yi = (int) Math.round(escalaY * valyi);
                    xi1 = (int) Math.round(escalaX * (valxi1));
                    yi1 = (int) Math.round(escalaY * valyi1);

                    //control de discontinuidades groseras y complejos
                    //control de puntos
                    if (i % (100 - puntosInt) == 0) {
                        Complex valC = miEvaluador.getComplexValue();
                        //System.out.println("valc "+valC);
                        double imgx = (double) Math.abs(valC.im());
                        if (dist(valxi, valyi, valxi1, valyi1) < 1000 && imgx == 0) {
                            g.draw(new Line2D.Double(xg + xi, yg - yi, xg + xi1, yg - yi1));
                        }
                    }
                }//fin del for 
            } else {
                Mensaje.setText(":. Hay un error.");
                campoFuncion.setForeground(Color.red);
            }

        }//Graficar

        double dist(double xA, double yA, double xB, double yB) {
            return (xA - xB) * (xA - xB) + (yA - yB) * (yA - yB);
        }//

    } // class

////////metodos
    class Biseccion extends Thread {

        float puntoMedio, a1, b1;
        double p1, p2, p3;
        Graphics2D g = (Graphics2D) panelGrafico.getGraphics();  //clave para poder pintar con el run
        int numeroDeInteraciones;
        int interaciones;
        String cadenaLista;

        Point2D.Double puntoA1;
        Point2D.Double puntoB1;
        Point2D.Double pointMedio;

        Biseccion() {
            a1 = intervaloA;
            b1 = intervaloB;
            puntoA1 = new Point2D.Double(x0 + a1 * escalaX, y0);
            puntoB1 = new Point2D.Double(x0 + b1 * escalaX, y0);
            numeroDeInteraciones = Integer.parseInt(campoNumeroDeInteraciones.getText());
            interaciones = 0;
            puntoMedio = (a1 + b1) / 2;

        }

        public void run() {
            miEvaluador.addVariable("x", a1);
            p1 = miEvaluador.getValue();
            miEvaluador.addVariable("x", b1);
            p2 = miEvaluador.getValue();

            g.setPaint(Color.red);
            g.drawLine((int) Math.round(puntoA1.getX()), y0 + 10, (int) Math.round(puntoA1.getX()), y0 - 10);
            g.drawLine((int) Math.round(puntoB1.getX()), y0 + 10, (int) Math.round(puntoB1.getX()), y0 - 10);
            try {
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.out.println("error" + e.toString());
            }

            if (p1 * p2 <= 0) {
                cadenaLista = new String(" n \t\t\t " + " int A \t\t\t" + " int B \t\t\t" + " punto medio \t\t\t" + " f(punto medio)");
                listModel.addElement(cadenaLista);

                g.setPaint(Color.red);
                g.drawLine((int) Math.round(puntoA1.getX()), y0 + 10, (int) Math.round(puntoA1.getX()), y0 - 10);
                g.drawLine((int) Math.round(puntoB1.getX()), y0 + 10, (int) Math.round(puntoB1.getX()), y0 - 10);

                g.setPaint(Color.blue);
                pointMedio = new Point2D.Double(x0 + puntoMedio * escalaX, y0);
                g.drawLine((int) Math.round(pointMedio.getX()), y0 + 10, (int) Math.round(pointMedio.getX()), y0 - 10);
                try {
                    sleep((int) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    System.out.println("error" + e.toString());
                }

                miEvaluador.addVariable("x", puntoMedio);
                p3 = miEvaluador.getValue();

                while (p3 != 0 && interaciones < numeroDeInteraciones) {
                    cadenaLista = new String();
                    listModel.addElement(cadenaLista);
                    miEvaluador.addVariable("x", a1);
                    p1 = miEvaluador.getValue();
                    miEvaluador.addVariable("x", b1);
                    p2 = miEvaluador.getValue();
                    miEvaluador.addVariable("x", puntoMedio);
                    p3 = miEvaluador.getValue();

                    if (p1 * p3 < 0) {
                        cadenaLista = new String("" + interaciones + " \t\t\t " + a1 + " \t\t\t " + b1 + " \t\t\t" + puntoMedio);
                        listModel.addElement(cadenaLista);

                        g.setPaint(Color.yellow);
                        g.drawLine((int) Math.round(puntoB1.getX()), y0 + 10, (int) Math.round(puntoB1.getX()), y0 - 10);
                        b1 = puntoMedio;
                        puntoA1 = new Point2D.Double(x0 + a1 * escalaX, y0);
                        puntoB1 = new Point2D.Double(x0 + b1 * escalaX, y0);

                        g.setPaint(Color.red);
                        g.drawLine((int) Math.round(puntoA1.getX()), y0 + 10, (int) Math.round(puntoA1.getX()), y0 - 10);
                        g.drawLine((int) Math.round(puntoB1.getX()), y0 + 10, (int) Math.round(puntoB1.getX()), y0 - 10);
                        puntoMedio = (a1 + b1) / 2;

                        try {
                            sleep((int) (Math.random() * 2000));
                        } catch (InterruptedException e) {
                            System.out.println("error" + e.toString());
                        }

                        g.setPaint(Color.blue);
                        pointMedio = new Point2D.Double(x0 + puntoMedio * escalaX, y0);
                        g.drawLine((int) Math.round(pointMedio.getX()), y0 + 10, (int) Math.round(pointMedio.getX()), y0 - 10);

                        try {
                            sleep((int) (Math.random() * 2000));
                        } catch (InterruptedException e) {
                            System.out.println("error" + e.toString());
                        }

                    } else if (p3 * p2 < 0) {
                        cadenaLista = new String("" + interaciones + " \t\t\t " + a1 + " \t\t\t " + b1 + " \t\t\t" + puntoMedio);
                        listModel.addElement(cadenaLista);

                        g.setPaint(Color.yellow);
                        g.drawLine((int) Math.round(puntoA1.getX()), y0 + 10, (int) Math.round(puntoA1.getX()), y0 - 10);

                        a1 = puntoMedio;
                        puntoA1 = new Point2D.Double(x0 + a1 * escalaX, y0);
                        puntoB1 = new Point2D.Double(x0 + b1 * escalaX, y0);

                        g.setPaint(Color.red);
                        g.drawLine((int) Math.round(puntoA1.getX()), y0 + 10, (int) Math.round(puntoA1.getX()), y0 - 10);
                        g.drawLine((int) Math.round(puntoB1.getX()), y0 + 10, (int) Math.round(puntoB1.getX()), y0 - 10);
                        puntoMedio = (a1 + b1) / 2;

                        try {
                            sleep((int) (Math.random() * 2000));
                        } catch (InterruptedException e) {
                            System.out.println("error" + e.toString());
                        }

                        g.setPaint(Color.blue);
                        pointMedio = new Point2D.Double(x0 + puntoMedio * escalaX, y0);
                        g.drawLine((int) Math.round(pointMedio.getX()), y0 + 10, (int) Math.round(pointMedio.getX()), y0 - 10);

                        try {
                            sleep((int) (Math.random() * 2000));
                        } catch (InterruptedException e) {
                            System.out.println("error" + e.toString());
                        }
                    }
                    interaciones++;
                }//while
            }//if
            else {
                Mensaje.setText("esa funci—n no sirve para este metodo");
                //Mensaje.setForeground(Color.red);
                campoFuncion.setForeground(Color.red);
            }
            repaint();
        }//run

    }//clase Bisecci—n

    class Newton extends Thread {

        double x1, xi;
        double fx1, fxi;
        int numeroDeInteraciones;
        int interaciones = 0;
        Graphics2D g = (Graphics2D) panelGrafico.getGraphics();  //clave para poder pintar con el run
        Point2D.Double puntoA1;

        public Newton() {
            xi = 1;
            numeroDeInteraciones = Integer.parseInt(campoNumeroDeInteraciones.getText());
            puntoA1 = new Point2D.Double(x0 + xi * escalaX, y0);
        }

        public void run() {
            //  while(true){//interaciones < numeroDeInteraciones){
            g.setPaint(Color.red);
            g.drawLine(x0, 20, x0, -20);
            if (true) {
                g.drawLine(x0, 20, x0, -20);
            }
            g.drawLine(x0, 20, x0, -20);
            g.drawLine(x0, 20, x0, -20);
            System.out.println("llega   ," + puntoA1.getX());

            repaint();
        }

    }

}
