/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lmejiaf
 */
public final class Arista {
    
    double valor;
    
    Nodo inicio;
    Nodo fin;
    
    int posX, posY, posXF, posYF;
    Graphics g;
    
    public Arista(double valor, Nodo inicio, Nodo fin) {
        this.valor = valor;
        this.inicio = inicio;
        this.fin = fin;
        this.posX = inicio.posX+ Nodo.RADIO;
        this.posY = inicio.posY;
        this.posXF = fin.posX;
        this.posYF = fin.posY;
        g = Lienzo.lienzo.getGraphics();
        dibujar();
    }
    
    public void dibujar() {
        g.setColor(Color.WHITE);
        g.drawLine(posX, posY, posXF, posYF);
    }
    
}
