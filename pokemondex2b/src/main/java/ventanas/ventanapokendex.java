/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import clases.registrospokemones;
 /**
 *
 * @author USUARIO
 */
public class ventanapokendex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    private Graphics2D Graphics2D;
    
    
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        
       g2.drawImage(buffer1,0,0,imagenPokemon.getWidth(),
                imagenPokemon.getHeight(),null);
   }
    
    
    
    
    public ventanapokendex() {
        initComponents();
        
        try {
            //imagen1 = ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
            imagen1 = ImageIO.read(new File("C:\\tmp2\\datos\\imagenes\\black-white.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        buffer1 = (BufferedImage) imagenPokemon.createImage(
        imagenPokemon.getWidth(),
        imagenPokemon.getHeight()
        );
        
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
            conexion = DriverManager.getConnection(JDBC_URL,"root","");
            estado = (Statement) conexion.createStatement();
        
        
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }
    }
     private void dibujaElPokemonQueEstaEnLaPosicion(int posicion); 
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel
                0, // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null //si no lo pones no va
                );
    @Override
        repaint();



    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        NombrePokemon = new javax.swing.JLabel();
        btncatalogo = new javax.swing.JButton();
        infopok = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ImagenPokemonLayout = new javax.swing.GroupLayout(ImagenPokemon);
        ImagenPokemon.setLayout(ImagenPokemonLayout);
        ImagenPokemonLayout.setHorizontalGroup(
            ImagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );
        ImagenPokemonLayout.setVerticalGroup(
            ImagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        izq.setText("Izquierda");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setText("Derecha");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        NombrePokemon.setFont(new java.awt.Font("Tekton Pro", 0, 24)); // NOI18N
        NombrePokemon.setText("jLabel1");

        btncatalogo.setText("Catalogo");

        infopok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Color", "Habitat", "Rate de Captura", "Experiencia base" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(izq)
                .addGap(30, 30, 30)
                .addComponent(btncatalogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(infopok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(der)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(NombrePokemon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ImagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(NombrePokemon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izq)
                    .addComponent(der)
                    .addComponent(btncatalogo)
                    .addComponent(infopok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        String cuerito = "Select * from pokemon where id="+(contador)+1;
        
        
        try {
            resultadoConsulta = estado.executeQuery(cuerito);
            if (resultadoConsulta.next()){
                nombrePokemon.setText(resultadoConsulta.getString(2));
            } else {
                nombrePokemon.setText("Este chucho no esta en el pokedex");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con mysql");
        }
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
    }//GEN-LAST:event_derActionPerformed

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        if(contador <=0){
            contador = 1;
        }
       dibujaElPokemonQueEstaEnLaPosicion(contador);
    }//GEN-LAST:event_izqActionPerformed

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
            java.util.logging.Logger.getLogger(ventanapokendex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanapokendex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanapokendex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanapokendex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanapokendex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagenPokemon;
    private javax.swing.JLabel NombrePokemon;
    private javax.swing.JButton btncatalogo;
    private javax.swing.JButton der;
    private javax.swing.JComboBox<String> infopok;
    private javax.swing.JButton izq;
    // End of variables declaration//GEN-END:variables
}
