/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author lmejiaf
 */
public class Nodo {

    ArrayList<Arista> aristas = new ArrayList();
    String nombre;

    Graphics g;
    final int radio = 50;
    int posX, posY;

    public void conectar(Nodo llegada, double valor) {
        Arista a = new Arista();
        a.valor = valor;
        a.inicio = this;
        a.fin = llegada;
        aristas.add(a);
    }

    public void dibujar() {
        g.setColor(Color.red);
        g.fillOval(posX, posY, radio, radio);
    }

    public Nodo(String nombre, JPanel lienzo, int posX, int posY) {
        this.nombre = nombre;
        this.posX = posX + posX / 2;
        this.posY = posY + posY / 2;
        g = lienzo.getGraphics();
        dibujar();
    }

}
