/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import javax.swing.DefaultListModel;


/**
 *
 * @author Practica
 */
public class HiloCliente extends  Thread {
    private DataInputStream entrada;
    private Socket SocketCliente;
    private Cliente cliente;
    private ObjectInputStream entradaObjeto;
    
    public HiloCliente (Socket  SocketCliente, Cliente cliente){
        this.SocketCliente = SocketCliente;
        this.cliente= cliente;
    }
  public void run(){    
        while (true) {
            try {
                entrada =new DataInputStream(SocketCliente.getInputStream());
                cliente.mensajeria(entrada.readUTF());
                
                entradaObjeto = new ObjectInputStream (SocketCliente.getInputStream());
                cliente.actualizacionLista((DefaultListModel)entradaObjeto.readObject () );
                
                
                    
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HiloCliente.class. getName()).log(Level.SEVERE, null, ex);
               
            } catch (IOException ex) {
                    Logger.getLogger(HiloCliente.class. getName()).log(Level.SEVERE,null, ex);
            
        
      
        }}}
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
