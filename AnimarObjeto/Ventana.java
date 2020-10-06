/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimarObjeto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Eduar
 */
public class Ventana extends JPanel{
     //ventana
    private JFrame ventana;
    //contenedor
    private Container contenedor;
    
    //arreglo de circulos
    private Circulo circulos[];
    private int velocidad;
    public Ventana(){
        // inicializar la ventana
        ventana = new JFrame("Dibujando icono");
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        
        //definir el arreglo de circulos
        int tamanio = 5;
        this.circulos = new Circulo[tamanio];
        
        //llenar el arreglo
        
        for (int i = 0; i < tamanio; i++) {
            this.circulos[i] = new Circulo(800, 600, 25, 10);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Circulo circulo : circulos) {
            circulo.dibujar(g);
        }
        
    }
    
    public void animar(){
        while(this.ventana.isVisible()){
            for (Circulo circulo : circulos) {
                circulo.animar();
                try {
                    Thread.sleep(50);
                } catch (Exception ex) {}
                repaint();
            }
 
        }
    }
    
}
