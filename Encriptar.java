/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptar;

import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Encriptar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
      String mensaje;
       String mensajeEncriptado;
       String mensajeDesencriptado;
       char array[];
       mensaje = JOptionPane.showInputDialog("Ingrese el mensaje a ecnriptar");
       array = mensaje.toCharArray();
       for (int i =0; i<array.length;i++)
       {
       array [i]=(char)(array[i]+(char)6);
       }
       mensajeEncriptado=String.valueOf(array);
       System.out.println("Mensaje a encriptar: "+mensaje);
       System.out.println("Mensaje encriptado: "+mensajeEncriptado);
       for (int i =0; i<array.length;i++)
       {
       array [i]=(char)(array[i]-(char)6);
       }
       mensajeDesencriptado=String.valueOf(array);
       System.out.println("Mensaje Desencriptado: "+mensajeDesencriptado);
    }
    
}
