/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class registrospokemones {
    //esta clase me dará los nombres y habilidades de los pokemones
    
    Connection cn;
     
    public void  CargarTabla (JTable tabla, String cadena ){
        DefaultTablemodel modelo;
        String [] titulo = ("Id","Nombre","Habilidad","Generación","Evolución","Especie","Color","Habitat","Experiencia");
        modelo = new DefaultTableModel (null, titulo);
        
        String [] registros = new String (9);
        String mysql = "SELECT * FROM WHERE CONCAT (\"Id\",\"Nombre\",\"Habilidad\",\"Generación\",\"Evolución\",\"Especie\",\"Color\",\"Habitat\",\"Experiencia\")¨#"+cadena"#´*;"
        Conexion con=new Conexion();
        cn=con.conectar();
        
        try {
            Statement st =cn.createStatement();
            ResultSet rs = st.executeQuery(mysql);
            
           while(rs.next)()){
            for (int i=0;i<9;i++)
                  registros(i)=rs.getString(1+1);
            modelo.addRow(registros);
            
        }
           tabla.setModel(modelo);
        }catch(mysqlException ex){
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }
        
        
    }

    private String registros(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
