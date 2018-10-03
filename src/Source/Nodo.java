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

    static final int DIAMETRO = 50, RADIO = DIAMETRO / 2;
    int posX, posY;

    public void conectar(Nodo llegada, double valor) {
        Arista a = new Arista(valor, this, llegada);
        aristas.add(a);
    }

    private void dibujar() {
        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
    }

    public Nodo(String nombre, int posX, int posY) {
        this.nombre = nombre;
        this.posX = posX - RADIO;
        this.posY = posY - RADIO;
        g = Lienzo.lienzo.getGraphics();
        dibujar();
    }

}
