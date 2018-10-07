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
        this.posX = inicio.centro[0];
        this.posY = inicio.centro[1];
        this.posXF = fin.centro[0];
        this.posYF = fin.centro[0];
        g = Lienzo.lienzo.getGraphics();
        dibujar();
    }

    public void dibujar() {
        g.setColor(Color.BLACK);
        g.drawLine(posX, posY, posXF, posYF);
    }

}
