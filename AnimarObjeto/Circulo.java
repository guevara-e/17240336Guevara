/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnimarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Eduar
 */
public class Circulo {
    // Coordenadas
    private int coordenada_x,coordenada_y;
    //Tamaño
    private int radio;
    
    //instancio color
    private Color color;
    
    //Sentido en que se mueve
    private int sentido;
    
    //Sentidos posibles
    private final int ARRIBA = 1;
    private final int DERECHA_ARRIBA = 2;
    private final int DERECHA = 3;
    private final int DERECHA_ABAJO = 4;
    private final int ABAJO = 5;
    private final int IZQUIERDA_ABAJO = 6;
    private final int IZQUIERDA = 7;
    private final int IZQUIERDA_ARRIBA = 8;
    
    
    // Velocidad
    private int velocidad;
    
    //margenes de la ventana
    private int minimo_x, minimo_y, maximo_x, maximo_y;
    
    //objeto random
    private Random random;

    public Circulo(int ancho, int alto, int radio, int velocidad) {
        //definir objeto random
        random = new Random();
        color = new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255)
        );
        
        //definir coordenadas iniciales
        this.coordenada_x = this.random.nextInt(ancho - radio);
        this.coordenada_y = this.random.nextInt(alto - radio);
        
        // definir el radio
        this.radio = radio;
        
        // definir sentido
        this.sentido = 1 + random.nextInt(8);
        
        //defiinir velocidad
        this.velocidad = velocidad;
        
        //deffinir coordenadas minimas
        this.minimo_x = 0;
        this.minimo_y = 0;
        
       // definir coordenadas maximas
       this.maximo_x = ancho;
       this.maximo_y = alto;
       
        
    }
    
    public void dibujar(Graphics g){
        g.setColor(this.color);
        g.fillOval(
                coordenada_x, 
                coordenada_y, 
                radio, 
                radio
        );
    }
    
     public void animar(){
        //Siguientes coordenadas positivas
        int x_positiva = this.coordenada_x + velocidad;
        int y_positiva = this.coordenada_y + velocidad;
        
        //Siguientes coordenadas negativas
        int x_negativa = this.coordenada_x - velocidad;
        int y_negativa = this.coordenada_y - velocidad;
        //logica
        switch(this.sentido){
            case ARRIBA:
                if (y_negativa > this.minimo_y) {
                    this.coordenada_y = y_negativa; 
                }else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = IZQUIERDA_ABAJO; break;
                        case 2:  this.sentido = ABAJO; break;  
                        case 3: this.sentido = DERECHA_ABAJO; break;
                    }
                }
                break;
            case DERECHA_ARRIBA:
                if ((x_positiva < maximo_x)&& (y_negativa > this.minimo_y)) {
                    //aplico incremento o decremento
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_negativa;
                }
                else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = IZQUIERDA; break;
                        case 2:  this.sentido = IZQUIERDA_ABAJO; break;  
                        case 3: this.sentido = ABAJO; break;
                    }
                }
                break;
            case DERECHA:
                if (x_positiva < maximo_x) {
                    this.coordenada_x = x_positiva;
                }
                else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = IZQUIERDA_ARRIBA; break;
                        case 2:  this.sentido = IZQUIERDA; break;  
                        case 3: this.sentido = IZQUIERDA_ABAJO; break;
                    }
                }
            case DERECHA_ABAJO:
                if ((x_positiva < this.maximo_x) && (y_positiva < this.maximo_y)) {
                    this.coordenada_x = x_positiva;
                    this.coordenada_y = y_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = IZQUIERDA; break;
                        case 2:  this.sentido = IZQUIERDA_ARRIBA; break;  
                        case 3: this.sentido = ARRIBA; break;
                    }
                }
                break;
                
            case ABAJO:
                if (y_positiva < this.maximo_y) {
                    this.coordenada_y = y_positiva;
                }else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = IZQUIERDA_ARRIBA; break;
                        case 2:  this.sentido = ARRIBA; break;  
                        case 3: this.sentido = DERECHA_ARRIBA; break;
                    }
                }
                break;
            case IZQUIERDA_ABAJO:
                if ((y_positiva < this.maximo_y) && (x_negativa > this.minimo_x)) {
                    this.coordenada_x = x_negativa;
                    this.coordenada_y = y_negativa;
                }else{
                        int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = ARRIBA; break;
                        case 2:  this.sentido = DERECHA_ARRIBA; break;  
                        case 3: this.sentido = DERECHA; break;
                    }
                        }
                break;
            case IZQUIERDA:
                if (x_negativa > this.minimo_x) {
                    this.coordenada_x = x_negativa;
                }else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = DERECHA_ARRIBA; break;
                        case 2:  this.sentido = DERECHA; break;  
                        case 3: this.sentido = DERECHA_ABAJO; break;
                    }
                }
                break;
            
            case IZQUIERDA_ARRIBA:
                if ((x_negativa > this.minimo_x) && (y_negativa > this.minimo_y)) {
                    this.coordenada_x = x_negativa;
                    this.coordenada_y = y_negativa; 
                }else{
                    int sentido_temp = 1 + random.nextInt(3);
                    switch(sentido_temp){
                        case 1:  this.sentido = DERECHA; break;
                        case 2:  this.sentido = DERECHA_ABAJO; break;  
                        case 3: this.sentido = ABAJO; break;
                    }
                }
        }
    }
   
}
