
package Icono;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dibujo extends JPanel{
    
    private int direccion;
    
    private int contador;
    //ventana
    private JFrame ventana;
    //contenedor
    private Container contenedor;
    //Figura representada en hexadecimal
    private final int [] FIGURA = {
        0x0000000,
        0x01c3800,
        0x0224400,
        0x0418200,
        0x0418200,
        0x0418200,
        0x0418200,
        0x0200400,
        0x0100800,
        0x0081000,
        0x0042000,
        0x0024000,
        0x0018000,
        0x0000000,
        0x0000000

    };
    
    //máscara
    private final int MASCARA = 0x8000000;
    
    //ancho en bits
    private final int ANCHO_BITS = 32;
    
    //coordenadas
    private int coordenada_x, coordenada_y,coordenada_gral;
    
    //declarar hilo de ejecución
    private Thread hilo;

    public Dibujo() {
        
        direccion = 0;
        
        contador = 0;
        
        //inicializar la ventana
        ventana = new JFrame("Examen");
        //definir tamaño a ventana
        ventana.setSize(80, 100);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(80, 100);
        //agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        
        //definir el hilo
        this.hilo = new Thread();
        
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); 
        
        //iterador de la figura
        for (int i = 0; i < this.FIGURA.length; i++) {
            // ITERADOR PARA EL ANCHO EN BITS DE LA FIGURA
            for (int j = 0; j < this.ANCHO_BITS; j++) {
                int temp = this.FIGURA[i] & (this.MASCARA >> j);
                
                //esta sirve para indicarle donde empezar a dibujar y seguir dibujando
                if (temp != 0) {
                    graphics.drawLine(
                            this.coordenada_x + j, 
                            this.coordenada_y + i, 
                            this.coordenada_x + j, 
                            this.coordenada_y + i);
                }
            }
        }
        
    }
    
    public void dibujar() {
        this.coordenada_x = (int) (Math.random() * 50);
        this.coordenada_y = (int) (Math.random() * 50);

        while (contador != 10) {
            //BORDE IZQUIERDO
                try {
                //this.coordenada_x = this.coordenada_x - 1;
                direccion = (int) (Math.random()*20);
                escogerDireccion();
                this.hilo.sleep(10);
                paint(getGraphics());
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
                
            //Borde Derecho
            if (coordenada_x > 115) {
                contador++;
                System.out.println("Colisiones: " + contador);
                dibujar();
            }
            //Borde izq
            if (coordenada_x < -5) {
                contador++;
                System.out.println("Colisiones: " + contador);
                dibujar();
            }
            //Borde Superior
            if (coordenada_y < 0) {
                contador++;
                System.out.println("Colisiones: " + contador);
                dibujar();
            }
            //Borde inferior
            if (coordenada_y > 60) {
                contador++;
                System.out.println("Colisiones: " + contador);
                dibujar();
            }
            
        }
    }
    
    public void escogerDireccion(){
        
        if (direccion < 5) {
            this.coordenada_x = this.coordenada_x + 2;
        }
        
        if (direccion > 5 && direccion < 10) {
            this.coordenada_x = this.coordenada_x - 2;
        }
        
        if (direccion > 10 && direccion < 15) {
            this.coordenada_y = this.coordenada_y - 2;
        }
        
        if (direccion > 15 && direccion < 20) {
            this.coordenada_y = this.coordenada_y + 2;
        }
    }
    
    
    
    
}
