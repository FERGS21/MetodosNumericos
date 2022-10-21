package MetodoBiseccion;

import MetodoBiseccion.Biseccionm;
import MetodoBiseccion.Funcionm;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents(); 
        setLocationRelativeTo(null);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        exp = new javax.swing.JTextField();
        x1 = new javax.swing.JTextField();
        x2 = new javax.swing.JTextField();
        Iteraciones = new javax.swing.JTextField();
        Error = new javax.swing.JTextField();
        EncontrarSolucion = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Raiz = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnlimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Método de Bisección");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 20, 210, 24);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Función");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 44, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("xi");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 80, 10, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("xu");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(320, 80, 14, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Iteraciones");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(430, 80, 64, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Error");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(540, 80, 29, 16);

        exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expActionPerformed(evt);
            }
        });
        exp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                expKeyTyped(evt);
            }
        });
        jPanel1.add(exp);
        exp.setBounds(20, 100, 130, 24);

        x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x1ActionPerformed(evt);
            }
        });
        x1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x1KeyTyped(evt);
            }
        });
        jPanel1.add(x1);
        x1.setBounds(200, 100, 61, 24);

        x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2ActionPerformed(evt);
            }
        });
        x2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x2KeyTyped(evt);
            }
        });
        jPanel1.add(x2);
        x2.setBounds(320, 100, 61, 24);

        Iteraciones.setEditable(false);
        Iteraciones.setText("100");
        Iteraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IteracionesActionPerformed(evt);
            }
        });
        jPanel1.add(Iteraciones);
        Iteraciones.setBounds(430, 100, 65, 24);

        Error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ErrorActionPerformed(evt);
            }
        });
        Error.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ErrorKeyTyped(evt);
            }
        });
        jPanel1.add(Error);
        Error.setBounds(540, 100, 85, 24);

        EncontrarSolucion.setText("Mostrar Solución");
        EncontrarSolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncontrarSolucionActionPerformed(evt);
            }
        });
        jPanel1.add(EncontrarSolucion);
        EncontrarSolucion.setBounds(20, 170, 127, 32);

        enviar.setText("Graficar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel1.add(enviar);
        enviar.setBounds(470, 220, 76, 32);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Raíz");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 220, 24, 16);

        Raiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaizActionPerformed(evt);
            }
        });
        jPanel1.add(Raiz);
        Raiz.setBounds(70, 220, 210, 24);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Iteración", "xi", "xu", "xu-xi", "xr", "F(xi)", "F(xr)", "F(x1)F(xr)"
            }
        ));
        jScrollPane2.setViewportView(table);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 260, 620, 180);

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnlimpiar);
        btnlimpiar.setBounds(160, 170, 77, 32);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(570, 220, 56, 32);
        jPanel1.add(a1);
        a1.setBounds(30, 140, 0, 0);
        jPanel1.add(a2);
        a2.setBounds(200, 140, 0, 0);
        jPanel1.add(a3);
        a3.setBounds(320, 140, 0, 0);
        jPanel1.add(a4);
        a4.setBounds(540, 140, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expActionPerformed

    }//GEN-LAST:event_expActionPerformed

    private void x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2ActionPerformed

    }//GEN-LAST:event_x2ActionPerformed

    private void EncontrarSolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncontrarSolucionActionPerformed
        if(exp.getText().isEmpty() || x1.getText().isEmpty() || x2.getText().isEmpty()  || Iteraciones.getText().isEmpty()|| Error.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane,"Favor de no dejar campos vacios");
        }
        else
        {
        F = exp.getText();
        double X1 = Double.parseDouble(x1.getText());
        double X2 = Double.parseDouble(x2.getText());
        int Lim = Integer.parseInt(Iteraciones.getText());
        double E = Double.parseDouble(Error.getText());
        Funcionm f = new Funcionm(F);
        try {
            if (f.eval(X1) * f.eval(X2) < 0) {

                Biseccionm B = new Biseccionm(F, X1, X2, E, Lim);

                try {
                    B.Inciar();
                    if (B.getBandera() != false) {
                        JOptionPane.showMessageDialog(jPanel1,
                                "No se encotro la raiz en el intervalo");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Object[][] Resultados = B.getResultados();

                table.setModel(new DefaultTableModel(Resultados,
                        new String[]{"I", "xi", "xu", "xu-xi", "Xr", "F(xi)", "F(xr)", "F(xi)F(xr)"}
                ));

                Raiz.setText(Double.toString(B.getRaiz()));
                //Raiz.setText(F);
            } else {
                JOptionPane.showMessageDialog(jPanel1,
                        "No Existe Raiz en ese intervalo \n Ingrese otros valores " + "o una funcion diferente no lineal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_EncontrarSolucionActionPerformed

    private void RaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RaizActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        VentanaG aplicacion = new VentanaG();
       
    }//GEN-LAST:event_enviarActionPerformed

    private void IteracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IteracionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IteracionesActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
      borrar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void expKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expKeyTyped
        char validar=evt.getKeyChar();
        
    }//GEN-LAST:event_expKeyTyped

    private void x1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1KeyTyped
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar))
        {
           getToolkit().beep();
           evt.consume();
           
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_x1KeyTyped

    private void x2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2KeyTyped
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar))
        {
           getToolkit().beep();
           evt.consume();
           
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_x2KeyTyped

    private void ErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErrorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ErrorActionPerformed

    private void ErrorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ErrorKeyTyped
         char validar=evt.getKeyChar();
        if(Character.isLetter(validar))
        {
           getToolkit().beep();
           evt.consume();
           
           JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_ErrorKeyTyped
    public void borrar()
    {
        exp.setText("");
        x1.setText("");
        x2.setText("");
        Error.setText("");
        Raiz.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton EncontrarSolucion;
    private javax.swing.JTextField Error;
    private javax.swing.JTextField Iteraciones;
    private javax.swing.JTextField Raiz;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton enviar;
    public static javax.swing.JTextField exp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    public static javax.swing.JTextField x1;
    public static javax.swing.JTextField x2;
    // End of variables declaration//GEN-END:variables
    String F;
}
